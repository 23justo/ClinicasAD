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
public class DoctorEntidadJpaController extends UsuarioEntidadJpaController{
    
    public DoctorEntidadJpaController(EntityManagerFactory emf) {
        super(emf);
    }
    
    public void create(DoctorEntidad usuarioEntidad) {
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
