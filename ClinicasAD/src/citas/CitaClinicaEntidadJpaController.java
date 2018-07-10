/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citas;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Justo
 */
public class CitaClinicaEntidadJpaController extends CitaEntidadJpaController {
    
    public CitaClinicaEntidadJpaController(EntityManagerFactory emf) {
        super(emf);
    }
    
}
