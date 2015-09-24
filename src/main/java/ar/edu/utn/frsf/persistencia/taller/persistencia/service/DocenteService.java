/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.service;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface DocenteService {
 
    /**
     * Graba un alumno en la base de datos.
     * @param alu 
     */
    public void nuevoDocente(Docente doc);
    
    
    /**
     * Lista todos los cursos que el docente dicta y que tienen cupo disponible
     * @return 
     */
    public List<Curso> listaCursosConCupo();
}
