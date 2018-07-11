/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citasFabrica;

import citas.CitaClinicaEntidad;
import citas.CitaClinicaEntidadJpaController;
import citas.CitaEntidadJpaController;
import citas.CitaExternaEntidad;
import citas.CitaExternaEntidadJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Justo
 */
public class FabricaCitas implements FabricaCitasInterfaz{
    public void crearCita(Object cita_especifico){
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("ClinicasADPU");
        if(cita_especifico.getClass().getName()=="citas.CitaClinicaEntidad"){
            CitaClinicaEntidadJpaController cita_jpa_controlador = new CitaClinicaEntidadJpaController(emf);
            cita_jpa_controlador.create((CitaClinicaEntidad) cita_especifico);
        }
        else if(cita_especifico.getClass().getName()=="citas.CitaExternaEntidad"){
            CitaExternaEntidadJpaController secretaria_jpa_controlador = new CitaExternaEntidadJpaController(emf);
            secretaria_jpa_controlador.create((CitaExternaEntidad) cita_especifico);
        }
        else{
            System.out.println("No se creo nada");
        }
    }
}
