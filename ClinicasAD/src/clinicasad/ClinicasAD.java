/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicasad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import usuarios.*;
import usuarios.fabrica.*;
import PacientesJpa.*;

/**
 *
 * @author Justo
 */
public class ClinicasAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("ClinicasADPU");
        //UsuarioEntidad usuario_table = new UsuarioEntidad();
        DoctorEntidad usuario_table = new DoctorEntidad();
        UsuarioEntidadJpaController user_jpa = new UsuarioEntidadJpaController(emf);
        usuario_table.setApellidos("Rivera");
        usuario_table.setDireccion("Direccion");
        usuario_table.setNombres("Justo");
        usuario_table.setPassword("password1");
        usuario_table.setUsuario("Usuario1");
        
        SecretariaEntidad secre = new SecretariaEntidad();
        secre.setApellidos("Rivera");
        secre.setDireccion("Direccion");
        secre.setNombres("Justo");
        secre.setPassword("password1");
        secre.setUsuario("Usuario1");
        
        
        SecretariaEntidad secre2 = new SecretariaEntidad();
        secre2.setApellidos("Rivera");
        secre2.setDireccion("Direccion");
        secre2.setNombres("Justo");
        secre2.setPassword("password1");
        secre2.setUsuario("Usuario1");
        

        UsuariosFabricaInterfaz fabrica_usuarios = new FabricaUsuarios();
        fabrica_usuarios.crearUsuario(usuario_table);
       fabrica_usuarios.crearUsuario(secre);
       fabrica_usuarios.crearUsuario(secre2);

        

    }
    
}
