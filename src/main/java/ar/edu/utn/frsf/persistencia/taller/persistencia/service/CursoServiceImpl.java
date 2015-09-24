/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.CursoDao;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.CursoDaoJDBC;
import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.CursoDaoJPA;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.ArrayList;

/**
 *
 * @author mdominguez
 */
public class CursoServiceImpl implements CursoService{

    private AlumnoService serviceAlumno = new AlumnoServiceImpl();

//    private CursoDao dao = new CursoDaoJDBC();
    private CursoDao dao = new CursoDaoJPA();

    @Override
    public void nuevoCurso(Curso curso) {
        dao.crear(curso);
    }

    @Override
    public void actualizarCurso(Curso curso) {
        dao.actualizar(curso);
    }
    
    @Override
    public void asignarDocente(Curso curso,Docente doc) {
        curso.setDocente(doc);
        dao.actualizar(curso);
    }
    
    @Override
    public void inscribirAlumno(Curso curso, Alumno alumno) {
        if(curso.getAlumnos()==null){
            curso.setAlumnos(new ArrayList<>());
        }
        curso.getAlumnos().add(alumno);
        dao.actualizar(curso);
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
