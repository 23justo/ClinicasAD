/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.interfazGrafica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Justo
 */
@Entity
@Table(name = "usuarioentidad", catalog = "dev_censo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuarioentidad.findAll", query = "SELECT u FROM Usuarioentidad u")
    , @NamedQuery(name = "Usuarioentidad.findById", query = "SELECT u FROM Usuarioentidad u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarioentidad.findByDtype", query = "SELECT u FROM Usuarioentidad u WHERE u.dtype = :dtype")
    , @NamedQuery(name = "Usuarioentidad.findByApellidos", query = "SELECT u FROM Usuarioentidad u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarioentidad.findByDireccion", query = "SELECT u FROM Usuarioentidad u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuarioentidad.findByNombres", query = "SELECT u FROM Usuarioentidad u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuarioentidad.findByPassword", query = "SELECT u FROM Usuarioentidad u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarioentidad.findByUsuario", query = "SELECT u FROM Usuarioentidad u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuarioentidad.findByPermisosId", query = "SELECT u FROM Usuarioentidad u WHERE u.permisosId = :permisosId")
    , @NamedQuery(name = "Usuarioentidad.findByEspecialidad", query = "SELECT u FROM Usuarioentidad u WHERE u.especialidad = :especialidad")})
public class Usuarioentidad implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DTYPE")
    private String dtype;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "PERMISOS_ID")
    private BigInteger permisosId;
    @Column(name = "ESPECIALIDAD")
    private String especialidad;

    public Usuarioentidad() {
    }

    public Usuarioentidad(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        String oldDtype = this.dtype;
        this.dtype = dtype;
        changeSupport.firePropertyChange("dtype", oldDtype, dtype);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        changeSupport.firePropertyChange("apellidos", oldApellidos, apellidos);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        String oldNombres = this.nombres;
        this.nombres = nombres;
        changeSupport.firePropertyChange("nombres", oldNombres, nombres);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public BigInteger getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(BigInteger permisosId) {
        BigInteger oldPermisosId = this.permisosId;
        this.permisosId = permisosId;
        changeSupport.firePropertyChange("permisosId", oldPermisosId, permisosId);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        String oldEspecialidad = this.especialidad;
        this.especialidad = especialidad;
        changeSupport.firePropertyChange("especialidad", oldEspecialidad, especialidad);
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
        if (!(object instanceof Usuarioentidad)) {
            return false;
        }
        Usuarioentidad other = (Usuarioentidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuarios.interfazGrafica.Usuarioentidad[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
