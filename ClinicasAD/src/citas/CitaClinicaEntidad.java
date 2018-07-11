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
import usuarios.DoctorEntidad;
import usuarios.SecretariaEntidad;

/**
 *
 * @author Justo
 */
@Entity
public class CitaClinicaEntidad extends CitaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public CitaClinicaEntidad(DoctorEntidad doctor, SecretariaEntidad secretaria, PacienteObjeto paciente, Timestamp fecha, String razon, String receta, float precio) {
        super(doctor, secretaria, paciente, fecha, razon, receta, precio);
    }

    public CitaClinicaEntidad() {
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
        if (!(object instanceof CitaClinicaEntidad)) {
            return false;
        }
        CitaClinicaEntidad other = (CitaClinicaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "citas.CitaClinicaEntidad[ id=" + id + " ]";
    }
    
}
