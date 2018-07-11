/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazCita;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Justo
 */
@Entity
@Table(name = "citaentidad", catalog = "dev_censo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Citaentidad.findAll", query = "SELECT c FROM Citaentidad c")
    , @NamedQuery(name = "Citaentidad.findById", query = "SELECT c FROM Citaentidad c WHERE c.id = :id")
    , @NamedQuery(name = "Citaentidad.findByDtype", query = "SELECT c FROM Citaentidad c WHERE c.dtype = :dtype")
    , @NamedQuery(name = "Citaentidad.findByFecha", query = "SELECT c FROM Citaentidad c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Citaentidad.findByPrecio", query = "SELECT c FROM Citaentidad c WHERE c.precio = :precio")
    , @NamedQuery(name = "Citaentidad.findByRazon", query = "SELECT c FROM Citaentidad c WHERE c.razon = :razon")
    , @NamedQuery(name = "Citaentidad.findByReceta", query = "SELECT c FROM Citaentidad c WHERE c.receta = :receta")
    , @NamedQuery(name = "Citaentidad.findByDoctorId", query = "SELECT c FROM Citaentidad c WHERE c.doctorId = :doctorId")
    , @NamedQuery(name = "Citaentidad.findByPacienteId", query = "SELECT c FROM Citaentidad c WHERE c.pacienteId = :pacienteId")
    , @NamedQuery(name = "Citaentidad.findBySecretariaId", query = "SELECT c FROM Citaentidad c WHERE c.secretariaId = :secretariaId")
    , @NamedQuery(name = "Citaentidad.findByDireccion", query = "SELECT c FROM Citaentidad c WHERE c.direccion = :direccion")})
public class Citaentidad implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DTYPE")
    private String dtype;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Float precio;
    @Column(name = "RAZON")
    private String razon;
    @Column(name = "RECETA")
    private String receta;
    @Column(name = "DOCTOR_ID")
    private BigInteger doctorId;
    @Column(name = "PACIENTE_ID")
    private BigInteger pacienteId;
    @Column(name = "SECRETARIA_ID")
    private BigInteger secretariaId;
    @Column(name = "DIRECCION")
    private String direccion;

    public Citaentidad() {
    }

    public Citaentidad(Long id) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        Float oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        String oldRazon = this.razon;
        this.razon = razon;
        changeSupport.firePropertyChange("razon", oldRazon, razon);
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        String oldReceta = this.receta;
        this.receta = receta;
        changeSupport.firePropertyChange("receta", oldReceta, receta);
    }

    public BigInteger getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(BigInteger doctorId) {
        BigInteger oldDoctorId = this.doctorId;
        this.doctorId = doctorId;
        changeSupport.firePropertyChange("doctorId", oldDoctorId, doctorId);
    }

    public BigInteger getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(BigInteger pacienteId) {
        BigInteger oldPacienteId = this.pacienteId;
        this.pacienteId = pacienteId;
        changeSupport.firePropertyChange("pacienteId", oldPacienteId, pacienteId);
    }

    public BigInteger getSecretariaId() {
        return secretariaId;
    }

    public void setSecretariaId(BigInteger secretariaId) {
        BigInteger oldSecretariaId = this.secretariaId;
        this.secretariaId = secretariaId;
        changeSupport.firePropertyChange("secretariaId", oldSecretariaId, secretariaId);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
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
        if (!(object instanceof Citaentidad)) {
            return false;
        }
        Citaentidad other = (Citaentidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InterfazCita.Citaentidad[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
