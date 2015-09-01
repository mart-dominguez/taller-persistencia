/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class Docente {
    private Integer id;
    private String nombre;
    private Double salario;
    private Date fechaContracion;
    private List<Curso> cursosDictados;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the fechaContracion
     */
    public Date getFechaContracion() {
        return fechaContracion;
    }

    /**
     * @param fechaContracion the fechaContracion to set
     */
    public void setFechaContracion(Date fechaContracion) {
        this.fechaContracion = fechaContracion;
    }

    /**
     * @return the cursosDictados
     */
    public List<Curso> getCursosDictados() {
        return cursosDictados;
    }

    /**
     * @param cursosDictados the cursosDictados to set
     */
    public void setCursosDictados(List<Curso> cursosDictados) {
        this.cursosDictados = cursosDictados;
    }

  
}
