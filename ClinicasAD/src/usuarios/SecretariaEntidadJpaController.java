/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Justo
 */
public class SecretariaEntidadJpaController extends UsuarioEntidadJpaController{
    
    public SecretariaEntidadJpaController(EntityManagerFactory emf) {
        super(emf);
    }
    
    public void create(SecretariaEntidad usuarioEntidad) {
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
    
}
