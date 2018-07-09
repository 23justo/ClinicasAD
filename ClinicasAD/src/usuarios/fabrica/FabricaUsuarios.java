/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.fabrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import usuarios.DoctorEntidad;
import usuarios.DoctorEntidadJpaController;
import usuarios.SecretariaEntidad;
import usuarios.SecretariaEntidadJpaController;
import usuarios.UsuarioEntidadJpaController;

/**
 *
 * @author Justo
 */
public class FabricaUsuarios implements UsuariosFabricaInterfaz{
    public void crearUsuario(Object usuario_especifico){
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("ClinicasADPU");
        if(usuario_especifico.getClass().getName()=="usuarios.DoctorEntidad"){
            DoctorEntidadJpaController doctor_jpa_controlador = new DoctorEntidadJpaController(emf);
            doctor_jpa_controlador.create((DoctorEntidad) usuario_especifico);
        }
        else if(usuario_especifico.getClass().getName()=="usuarios.SecretariaEntidad"){
            SecretariaEntidadJpaController secretaria_jpa_controlador = new SecretariaEntidadJpaController(emf);
            secretaria_jpa_controlador.create((SecretariaEntidad) usuario_especifico);
        }
        else{
            System.out.println("No se creo nada");
        }
    }
}
