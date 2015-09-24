/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util.MiEntityManager;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mdominguez
 */
public class DocenteDaoJPA implements DocenteDao{

    private Docente docente;
    
    @Override
    public void set(Docente doc) {
        this.docente = doc;
    }

    @Override
    public Docente get() {
        return this.docente;
    }

    @Override
    public void crear() {
        EntityManager em = MiEntityManager.get();
        try{
            em.getTransaction().begin();
            em.persist(this.docente);
            em.flush();
            em.refresh(this.docente);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }      
}

    @Override
    public void crear(Docente doc) {
        EntityManager entityManager = MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(this.docente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }     
}

    @Override
    public void actualizar() {
        EntityManager entityManager = MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            this.docente  = entityManager.merge(this.docente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }            
    }

    @Override
    public void actualizar(Docente doc) {
        EntityManager entityManager = MiEntityManager.get();
        try{       
            entityManager.getTransaction().begin();
            entityManager.merge(doc);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }
    }

    @Override
    public void borrar() {
        EntityManager entityManager =  MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            entityManager.refresh(this.docente);
            entityManager.remove(this.docente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }
        
    }

    @Override
    public void borrar(Docente doc) {
        EntityManager entityManager =  MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            Docente docBorrar = entityManager.find(Docente.class,doc.getId());
            entityManager.remove(docBorrar);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }
    }

    @Override
    public Docente buscarPorId(Integer id) {
        EntityManager em = MiEntityManager.get();
        Docente doc = em.find(Docente.class, id);
        em.close();
        return doc;
    }

    @Override
    public List<Docente> buscarTodos() {
        EntityManager em = MiEntityManager.get();
        List<Docente> result = em.createQuery("SELECT d FROM Docente d").getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Docente> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
