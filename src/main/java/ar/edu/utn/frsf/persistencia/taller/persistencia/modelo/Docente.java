/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdominguez
 */
@Entity
@Table(name = "TALLER_DOCENTE")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Double salario;
    @Column(name="FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaContracion;
    @OneToMany(mappedBy = "docente")
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
