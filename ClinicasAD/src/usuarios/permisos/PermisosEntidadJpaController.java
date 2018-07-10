/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.permisos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import usuarios.permisos.exceptions.NonexistentEntityException;

/**
 *
 * @author Justo
 */
public class PermisosEntidadJpaController implements Serializable {

    public PermisosEntidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PermisosEntidad permisosEntidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(permisosEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PermisosEntidad permisosEntidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            permisosEntidad = em.merge(permisosEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = permisosEntidad.getId();
                if (findPermisosEntidad(id) == null) {
                    throw new NonexistentEntityException("The permisosEntidad with id " + id + " no longer exists.");
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
            PermisosEntidad permisosEntidad;
            try {
                permisosEntidad = em.getReference(PermisosEntidad.class, id);
                permisosEntidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The permisosEntidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(permisosEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PermisosEntidad> findPermisosEntidadEntities() {
        return findPermisosEntidadEntities(true, -1, -1);
    }

    public List<PermisosEntidad> findPermisosEntidadEntities(int maxResults, int firstResult) {
        return findPermisosEntidadEntities(false, maxResults, firstResult);
    }

    private List<PermisosEntidad> findPermisosEntidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PermisosEntidad.class));
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

    public PermisosEntidad findPermisosEntidad(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PermisosEntidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getPermisosEntidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PermisosEntidad> rt = cq.from(PermisosEntidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
