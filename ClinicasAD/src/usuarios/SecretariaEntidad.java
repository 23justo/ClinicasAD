/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import usuarios.permisos.PermisosEntidad;

/**
 *
 * @author Justo
 */
@Entity
public class SecretariaEntidad extends UsuarioEntidad implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SecretariaEntidad(String nombres, String apellidos, String usuario, String password, String direccion, PermisosEntidad permisos) {
        super(nombres, apellidos, usuario, password, direccion, permisos);
    }

    public SecretariaEntidad() {
    }

    public SecretariaEntidad(String text, String text0, String text1, String text2, String text3, String text4, PermisosEntidad permiso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public SecretariaEntidad editar(String nombres, String apellidos, String usuario, String password, String direccion){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        return this;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecretariaEntidad)) {
            return false;
        }
        SecretariaEntidad other = (SecretariaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuarios.SecretariaEntidad[ id=" + id + " ]";
    }
    
}
