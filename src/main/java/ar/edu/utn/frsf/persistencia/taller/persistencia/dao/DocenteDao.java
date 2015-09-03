/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface DocenteDao {
    public void set(Docente doc);
    public Docente get();
    public void crear();
    public void crear(Docente doc);
    public void actualizar();
    public void actualizar(Docente doc);
    public void borrar();
    public void borrar(Docente doc);
    public Docente buscarPorId(Integer id);
    public List<Docente > buscarTodos();
    public List<Docente > buscarPorNombre(String nombre);
}
