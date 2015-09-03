/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.AlumnoDao;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.CursoDao;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.CursoDaoJDBC;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;

/**
 *
 * @author mdominguez
 */
public class CursoServiceImpl implements CursoService{

    private AlumnoService serviceAlumno = new AlumnoServiceImpl();

    private CursoDao dao = new CursoDaoJDBC();

    @Override
    public void nuevoCurso(Curso curso) {
        dao.crear(curso);
    }

    @Override
    public void inscribirAlumno(Curso curso, Alumno alumno) {
        // ver si el curso es especifico o general
        //  a - si el curso es especifico entonces revisar la cantidad de creditos que tiene el alumno
        //  b - si el curso es general entonces revisar la cantidad de inscriptos.
        // si se cumple la condición que corresponde (a o b) persisitir.
    }

    @Override
    public void cargarInscriptos(Curso curso) {
        //recibe un curso como parametro, carga en la lista de alumnos los alumnos desde la db y lo asigna.|
    }

}
