/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.permisos;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Justo
 */
@Entity
public class PermisosEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public boolean creacion_usuario;
    public boolean edicion_usuario;
    
    public boolean creacion_paciente;
    public boolean edicion_paciente;
    
    public boolean creacion_doctor;
    public boolean edicion_dcotor;
    
    public boolean creacion_secretaria;
    public boolean edicion_secretaria;
    
    public boolean creacion_cita;
    public boolean edicion_cita;

    public PermisosEntidad(boolean creacion_usuario, boolean edicion_usuario, boolean creacion_paciente, boolean edicion_paciente, boolean creacion_doctor, boolean edicion_dcotor, boolean creacion_secretaria, boolean edicion_secretaria, boolean creacion_cita, boolean edicion_cita) {
        this.creacion_usuario = creacion_usuario;
        this.edicion_usuario = edicion_usuario;
        this.creacion_paciente = creacion_paciente;
        this.edicion_paciente = edicion_paciente;
        this.creacion_doctor = creacion_doctor;
        this.edicion_dcotor = edicion_dcotor;
        this.creacion_secretaria = creacion_secretaria;
        this.edicion_secretaria = edicion_secretaria;
        this.creacion_cita = creacion_cita;
        this.edicion_cita = edicion_cita;
    }

    public PermisosEntidad() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCreacion_usuario() {
        return creacion_usuario;
    }

    public void setCreacion_usuario(boolean creacion_usuario) {
        this.creacion_usuario = creacion_usuario;
    }

    public boolean isEdicion_usuario() {
        return edicion_usuario;
    }

    public void setEdicion_usuario(boolean edicion_usuario) {
        this.edicion_usuario = edicion_usuario;
    }

    public boolean isCreacion_paciente() {
        return creacion_paciente;
    }

    public void setCreacion_paciente(boolean creacion_paciente) {
        this.creacion_paciente = creacion_paciente;
    }

    public boolean isEdicion_paciente() {
        return edicion_paciente;
    }

    public void setEdicion_paciente(boolean edicion_paciente) {
        this.edicion_paciente = edicion_paciente;
    }

    public boolean isCreacion_doctor() {
        return creacion_doctor;
    }

    public void setCreacion_doctor(boolean creacion_doctor) {
        this.creacion_doctor = creacion_doctor;
    }

    public boolean isEdicion_dcotor() {
        return edicion_dcotor;
    }

    public void setEdicion_dcotor(boolean edicion_dcotor) {
        this.edicion_dcotor = edicion_dcotor;
    }

    public boolean isCreacion_secretaria() {
        return creacion_secretaria;
    }

    public void setCreacion_secretaria(boolean creacion_secretaria) {
        this.creacion_secretaria = creacion_secretaria;
    }

    public boolean isEdicion_secretaria() {
        return edicion_secretaria;
    }

    public void setEdicion_secretaria(boolean edicion_secretaria) {
        this.edicion_secretaria = edicion_secretaria;
    }

    public boolean isCreacion_cita() {
        return creacion_cita;
    }

    public void setCreacion_cita(boolean creacion_cita) {
        this.creacion_cita = creacion_cita;
    }

    public boolean isEdicion_cita() {
        return edicion_cita;
    }

    public void setEdicion_cita(boolean edicion_cita) {
        this.edicion_cita = edicion_cita;
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
        if (!(object instanceof PermisosEntidad)) {
            return false;
        }
        PermisosEntidad other = (PermisosEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuarios.permisos.PermisosEntidad[ id=" + id + " ]";
    }
    
}
