/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util.MiEntityManager;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mdominguez
 */
public class CursoDaoJPA implements CursoDao{

    Curso curso;
    
    @Override
    public void set(Curso c) {
       this.curso = c;
    }

    @Override
    public Curso get() {
        return this.curso;
    }

    @Override
    public void crear() {
        EntityManager em = MiEntityManager.get();
        try{
            em.getTransaction().begin();
            em.persist(this.curso);
            em.flush();
            em.refresh(this.curso);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }      
    }

    @Override
    public void crear(Curso c) {
        this.curso = c;
        EntityManager em = MiEntityManager.get();
        try{
            em.getTransaction().begin();
            em.persist(this.curso);
            em.flush();
            em.refresh(this.curso);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }      
    }

    @Override
    public void actualizar() {
        EntityManager entityManager = MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(this.curso);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }  
    }

    @Override
    public void actualizar(Curso c) {
        this.curso = c;
        EntityManager entityManager = MiEntityManager.get();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(this.curso);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Curso a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso buscarPorId(Integer id) {
        EntityManager em = MiEntityManager.get();
        Curso cur = em.find(Curso.class, id);
        em.close();
        return cur;   
    }

    @Override
    public List<Curso> buscarTodos() {
        EntityManager em = MiEntityManager.get();
        List<Curso> result = em.createQuery("SELECT c FROM Curso c").getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso registrarDocente(Curso c, Docente d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso inscribirAlumno(Curso c, Alumno d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer cantidadInscriptos(Curso c) {
        EntityManager em = MiEntityManager.get();
        Query q= em.createQuery("");
        q.setParameter("PARAMENTRO", c);
        Integer cantidad = (Integer) q.getSingleResult();
        em.close();
        return cantidad;
    }
    
}
