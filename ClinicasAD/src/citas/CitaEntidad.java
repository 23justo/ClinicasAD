/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citas;

import PacientesJpa.PacienteObjeto;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import usuarios.DoctorEntidad;
import usuarios.SecretariaEntidad;

/**
 *
 * @author Justo
 */
@Entity
public class CitaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    public DoctorEntidad doctor;
    
    @OneToOne
    public SecretariaEntidad secretaria;
    
    @OneToOne
    public PacienteObjeto paciente;
    
    public java.sql.Timestamp fecha;
    public String razon; 
    public String receta;
    public float precio;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorEntidad getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntidad doctor) {
        this.doctor = doctor;
    }

    public SecretariaEntidad getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaEntidad secretaria) {
        this.secretaria = secretaria;
    }

    public PacienteObjeto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteObjeto paciente) {
        this.paciente = paciente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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
        if (!(object instanceof CitaEntidad)) {
            return false;
        }
        CitaEntidad other = (CitaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "citas.CitaEntidad[ id=" + id + " ]";
    }
    
}
