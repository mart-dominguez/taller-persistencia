/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface AlumnoDao {
    public void crear(Alumno a);
    public void actualizar(Alumno a);
    public void borrar(Alumno a);
    public Alumno buscarPorId(Integer id);
    public List<Alumno> buscarTodos();
    public List<Alumno> buscarPorNombre(String nombre);
    public Integer cantidadCreditos(Integer idAlumno);
    
}
