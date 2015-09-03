/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface AlumnoService {
 
    /**
     * Graba un alumno en la base de datos.
     * @param alu 
     */
    public void nuevoAlumno(Alumno alu);
    
    /**
     * Retorna la cantidad de creditos que tiene un alumno de acuerdo a los cursos donde esta inscripto.
     * @param alu
     * @return 
     */
    public Integer creditosObtenidos(Alumno alu);
    
    public List<Alumno> listaAlumnos();
}
