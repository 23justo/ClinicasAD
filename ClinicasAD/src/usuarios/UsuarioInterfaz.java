/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.util.Date;

/**
 *
 * @author Justo
 */
public interface UsuarioInterfaz {
    public String getUsuario();

    public void setUsuario(String usuario) ;

    public String getPassword();

    public void setPassword(String password);

    public String getNombre();

    public void setNombre(String nombre);

    public String getApellido();

    public void setApellido(String apellido);

    public String getDireccion();

    public void setDireccion(String direccion);

    public Date getFecha_nacimiento();

    public void setFecha_nacimiento(Date fecha_nacimiento);
}
