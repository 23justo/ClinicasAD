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
import usuarios.permisos.PermisosEntidad;
import usuarios.permisos.PermisosEntidadJpaController;

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
        PermisosEntidad permiso = new PermisosEntidad();
        PermisosEntidadJpaController permisos_jpa = new PermisosEntidadJpaController(emf);
        permisos_jpa.create(permiso);
        DoctorEntidad usuario_table = new DoctorEntidad("especialidad", "nombres", "apellidos", "usuario", "password", "direccion", permiso);
        
        UsuarioEntidadJpaController user_jpa = new UsuarioEntidadJpaController(emf);
        
        
        System.out.println(permiso.getId());
        usuario_table.setPermisos(permiso);
        
//        SecretariaEntidad secre = new SecretariaEntidad();
//        secre.setApellidos("Rivera");
//        secre.setDireccion("Direccion");
//        secre.setNombres("Justo");
//        secre.setPassword("password1");
//        secre.setUsuario("Usuario1");
//        
//        
//        SecretariaEntidad secre2 = new SecretariaEntidad();
//        secre2.setApellidos("Rivera");
//        secre2.setDireccion("Direccion");
//        secre2.setNombres("Justo");
//        secre2.setPassword("password1");
//        secre2.setUsuario("Usuario1");
        

        UsuariosFabricaInterfaz fabrica_usuarios = new FabricaUsuarios();
        fabrica_usuarios.crearUsuario(usuario_table);
//       fabrica_usuarios.crearUsuario(secre);
//       fabrica_usuarios.crearUsuario(secre2);

        

    }
    
}
