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
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Martin
 */
public class AlumnoDaoJPA implements AlumnoDao{

    @Override
    public void crear(Alumno a) {
        EntityManager em = MiEntityManager.get();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();
        em.close();
    }

    @Override
    public void actualizar(Alumno a) {
        EntityManager em = MiEntityManager.get();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(a);
        tx.commit();
        em.close();
    }

    @Override
    public void borrar(Alumno a) {
        EntityManager em = MiEntityManager.get();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Alumno aBorrar = em.find(Alumno.class, a.getId());
        em.remove(aBorrar);
        tx.commit();
        em.close();
    }

    @Override
    public Alumno buscarPorId(Integer id) {
        EntityManager em = MiEntityManager.get();
        Alumno alu = em.find(Alumno.class, id);
        em.close();
        return alu;
    }

    @Override
    public List<Alumno> buscarTodos() {
        EntityManager em = MiEntityManager.get();
        List<Alumno> result = em.createQuery("SELECT a FROM Alumno a").getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Alumno> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer cantidadCreditos(Integer idAlumno) {
        EntityManager em = MiEntityManager.get();
        Query q= em.createQuery("");
        q.setParameter("P_ID_ALUMNO", idAlumno);
        Integer cantidad = (Integer) q.getSingleResult();
        em.close();
        return cantidad;
    }
    
}
