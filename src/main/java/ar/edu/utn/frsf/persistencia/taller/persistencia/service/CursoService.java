/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;

/**
 *
 * @author mdominguez
 */
public interface CursoService {
    
    public void nuevoCurso(Curso curso);
    public void inscribirAlumno(Curso curso,Alumno alumno);
    public void cargarInscriptos(Curso curso);
    public void actualizarCurso(Curso curso);
    public void asignarDocente(Curso curso,Docente doc);


}
