/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.AlumnoDao;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.AlumnoDaoJDBC;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class AlumnoServiceImpl implements AlumnoService {
    private AlumnoDao dao = new AlumnoDaoJDBC();

    @Override
    public void nuevoAlumno(Alumno alu) {
        dao.set(alu);
        dao.crear();
    }

    @Override
    public Integer creditosObtenidos(Alumno alu) {
        // TODO
        return 0;
    }

    @Override
    public List<Alumno> listaAlumnos() {
        return dao.buscarTodos();
    }
        

}