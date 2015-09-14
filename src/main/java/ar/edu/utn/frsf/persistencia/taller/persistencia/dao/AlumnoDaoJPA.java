/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util.MiEntityManager;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class AlumnoDaoJPA implements AlumnoDao{

    @Override
    public void crear(Alumno a) {
        EntityManager em = MiEntityManager.get();
        EntityTransaction tx = em.getTransaction();
        //em.getTransaction().begin();
        tx.begin();
        em.persist(a);
        tx.commit();
        em.close();
    }

    @Override
    public void actualizar(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> buscarTodos() {
        EntityManager em = MiEntityManager.get();
        //em.getTransaction().begin();
        List<Alumno> result = em.createQuery("SELECT a FROM Alumno a").getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Alumno> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
