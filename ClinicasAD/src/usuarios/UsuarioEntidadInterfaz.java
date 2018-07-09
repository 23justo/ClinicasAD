/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author Justo
 */
public interface UsuarioEntidadInterfaz {
    public Long getId();

    public void setId(Long id);

    public String getNombres();

    public void setNombres(String nombres);

    public String getApellidos();

    public void setApellidos(String apellidos);

    public String getUsuario();

    public void setUsuario(String usuario) ;

    public String getPassword() ;

    public void setPassword(String password);

    public String getDireccion();

    public void setDireccion(String direccion);
    
    @Override
    public int hashCode();

    @Override
    public boolean equals(Object object);

    @Override
    public String toString() ;
    
}
