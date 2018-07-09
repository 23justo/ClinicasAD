/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.jpa.JpaHelper;
import usuarios.exceptions.NonexistentEntityException;

/**
 *
 * @author Justo
 */

public class UsuarioEntidadJpaController implements Serializable {

    public UsuarioEntidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
  
    public void create(UsuarioEntidad usuarioEntidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioEntidad usuarioEntidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioEntidad = em.merge(usuarioEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuarioEntidad.getId();
                if (findUsuarioEntidad(id) == null) {
                    throw new NonexistentEntityException("The usuarioEntidad with id " + id + " no longer exists.");
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
            UsuarioEntidad usuarioEntidad;
            try {
                usuarioEntidad = em.getReference(UsuarioEntidad.class, id);
                usuarioEntidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioEntidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioEntidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioEntidad> findUsuarioEntidadEntities() {
        return findUsuarioEntidadEntities(true, -1, -1);
    }

    public List<UsuarioEntidad> findUsuarioEntidadEntities(int maxResults, int firstResult) {
        return findUsuarioEntidadEntities(false, maxResults, firstResult);
    }

    private List<UsuarioEntidad> findUsuarioEntidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioEntidad.class));
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

    public UsuarioEntidad findUsuarioEntidad(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioEntidad.class, id);
        } finally {
            em.close();
        }
    }
    
    
}
