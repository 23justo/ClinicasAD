/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacientesJpa;

import controladoresjpa.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.persistence.internal.xr.SQLQueryHandler;


/**
 *
 * @author Mr josh
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PacienteObjeto paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PacienteObjeto paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            paciente = em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PacienteObjeto paciente;
            try {
                paciente = em.getReference(PacienteObjeto.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PacienteObjeto> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<PacienteObjeto> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<PacienteObjeto> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PacienteObjeto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PacienteObjeto findPaciente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PacienteObjeto.class, id);
        } finally {
            em.close();
        }
    }
 /////////////////////////////////////////////////////////////////////////////// Funciones especiales para obtener datos de las tablas   
    public List<String> NombresDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT nombre FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> ApellidosDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT apellido FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> EdadesDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT edad FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> DireccionesDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT direccion FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> OcupacionesDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT ocupacion FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> ReligionesDePacientes(){
        EntityManager em = getEntityManager();
        String consulta = "SELECT religion FROM pacienteobjeto";

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery(consulta);
            List<String> resultado = q.getResultList();
            System.out.println(resultado);
            em.getTransaction().commit();
            em.close();
            return resultado;
        } finally{
            
        }
    }
    public List<String> TraerPaciente(int id){
        EntityManager em = getEntityManager();
        String consultanombre = "SELECT nombre FROM pacienteobjeto where id = "+ id;
        String consultaapellido = "SELECT apellido FROM pacienteobjeto where id = "+ id;
        String consultaedad = "SELECT edad FROM pacienteobjeto where id = "+ id;
        String consultaocupacion = "SELECT ocupacion FROM pacienteobjeto where id = "+ id;
        String consultareligion = "SELECT religion FROM pacienteobjeto where id = "+ id;
        String consultadireccion = "SELECT direccion FROM pacienteobjeto where id = "+ id;
        List<String>datosPaciente = new ArrayList<String>();
        
        System.out.println(consultanombre);
        
        
            em.getTransaction().begin();
            // Query nombre = em.createNativeQuery(consultanombre);
            // String n = (String) nombre.getSingleResult();
            
            Query qnombre = em.createNativeQuery(consultanombre);
            String nombre = (String) qnombre.getSingleResult();
            
            Query qapellido = em.createNativeQuery(consultaapellido);
            String apellido = (String) qapellido.getSingleResult();
            
            Query qedad = em.createNativeQuery(consultaedad);
            int edad = (int) qedad.getSingleResult();
            
            Query qdireccion = em.createNativeQuery(consultadireccion);
            String direccion = (String) qdireccion.getSingleResult();
            
            Query qocupacion = em.createNativeQuery(consultaocupacion);
            String ocupacion = (String) qocupacion.getSingleResult();
            
            Query qreligion = em.createNativeQuery(consultareligion);
            String religion = (String) qreligion.getSingleResult();
            
            
            
            //datosPaciente.add(n);
            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(edad);
            System.out.println(direccion);
            System.out.println(ocupacion);
            System.out.println(religion);
            
            em.getTransaction().commit();
            em.close();
            datosPaciente.add(0, apellido);
            datosPaciente.add(1,nombre);
            datosPaciente.add(2,Integer.toString(edad));
            datosPaciente.add(3,direccion);
            datosPaciente.add(4,ocupacion);
            datosPaciente.add(5,religion);
           return datosPaciente;
       
       
    }
    public void EditarPaciente(int id,String apellidonuevo, String nombrenuevo, String edadnueva, String direccionnueva,String ocupacionnueva,String religionnueva){
        EntityManager em = getEntityManager();//cambiar el "pacienteobjeto" por la tabla que se desee
        String nombretabla= "pacienteobjeto";
        String consultanombre = "UPDATE "+nombretabla+" SET nombre = '"+nombrenuevo+"' where id ="+id;
        String consultaapellido = "UPDATE "+nombretabla+" SET apellido = '"+apellidonuevo+"' where id ="+id;
        String consultaedad = "UPDATE "+nombretabla+" SET edad = '"+edadnueva+"' where id ="+id;
        String consultaocupacion = "UPDATE "+nombretabla+" SET ocupacion = '"+ocupacionnueva+"' where id ="+id;
        String consultareligion = "UPDATE "+nombretabla+" SET religion = '"+religionnueva+"' where id ="+id;
        String consultadireccion = "UPDATE "+nombretabla+" SET direccion = '"+direccionnueva+"' where id ="+id;
        em.getTransaction().begin();
            // Query nombre = em.createNativeQuery(consultanombre);
            // String n = (String) nombre.getSingleResult();
            
            Query qnombre = em.createNativeQuery(consultanombre);
            qnombre.executeUpdate();
            
            Query qapellido = em.createNativeQuery(consultaapellido);
            qapellido.executeUpdate();
            
            Query qedad = em.createNativeQuery(consultaedad);
            qedad.executeUpdate();
            
            Query qdireccion = em.createNativeQuery(consultadireccion);
            qdireccion.executeUpdate();
            
            Query qocupacion = em.createNativeQuery(consultaocupacion);
            qocupacion.executeUpdate();
            
            Query qreligion = em.createNativeQuery(consultareligion);
            qreligion.executeUpdate();
            
            
            
            //datosPaciente.add(n);
            System.out.println("----------------------nuevos datos-------------------");
  
 
            em.getTransaction().commit();
            em.close();
    }
    
////////////////////////////////////////////////////////////////////////////////
    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PacienteObjeto> rt = cq.from(PacienteObjeto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
