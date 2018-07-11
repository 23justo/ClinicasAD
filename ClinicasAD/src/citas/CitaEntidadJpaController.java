/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citas;

import citas.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Justo
 */
public class CitaEntidadJpaController implements Serializable {

    public CitaEntidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CitaEntidad citaEntidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(citaEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CitaEntidad citaEntidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            citaEntidad = em.merge(citaEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = citaEntidad.getId();
                if (findCitaEntidad(id) == null) {
                    throw new NonexistentEntityException("The citaEntidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CitaEntidad citaEntidad;
            try {
                citaEntidad = em.getReference(CitaEntidad.class, id);
                citaEntidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citaEntidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(citaEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CitaEntidad> findCitaEntidadEntities() {
        return findCitaEntidadEntities(true, -1, -1);
    }

    public List<CitaEntidad> findCitaEntidadEntities(int maxResults, int firstResult) {
        return findCitaEntidadEntities(false, maxResults, firstResult);
    }

    private List<CitaEntidad> findCitaEntidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CitaEntidad.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CitaEntidad findCitaEntidad(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CitaEntidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitaEntidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CitaEntidad> rt = cq.from(CitaEntidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
