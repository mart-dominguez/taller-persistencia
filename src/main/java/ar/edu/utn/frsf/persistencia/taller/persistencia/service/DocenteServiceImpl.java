/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.DocenteDao;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.DocenteDaoJPA;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class DocenteServiceImpl implements DocenteService{
    
    DocenteDao dao = new DocenteDaoJPA();

    @Override
    public void nuevoDocente(Docente doc) {
        dao.set(doc);
        dao.crear();
    }

    @Override
    public List<Curso> listaCursosConCupo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
