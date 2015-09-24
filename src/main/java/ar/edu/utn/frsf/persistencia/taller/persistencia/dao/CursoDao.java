/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface CursoDao {
    public void set(Curso a);
    public Curso get();
    public void crear();
    public void crear(Curso a);
    public void actualizar();
    public void actualizar(Curso a);
    public void borrar();
    public void borrar(Curso a);
    public Curso buscarPorId(Integer id);
    public List<Curso > buscarTodos();
    public List<Curso > buscarPorNombre(String nombre);
    public Curso registrarDocente(Curso c, Docente d);
    public Curso inscribirAlumno(Curso c, Alumno d);
    public Integer cantidadInscriptos(Curso c);

}
