/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;

/**
 *
 * @author mdominguez
 */
public interface CursoService {
    
    public void nuevoCurso(Curso curso);
    public void inscribirAlumno(Curso curso,Alumno alumno);
    public void cargarInscriptos(Curso curso);
}
