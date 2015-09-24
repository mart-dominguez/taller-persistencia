/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author mdominguez
 */
@Entity
@Table(name = "TALLER_ALUMNO")
public class Alumno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    @Column(name = "NRO_LEGAJO")
    private int nroLegajo;
    @ManyToMany
    @JoinTable(name = "TALLER_ALUMNO_CURSO",
            joinColumns = @JoinColumn(name = "ID_ALUMNO"),
            inverseJoinColumns = @JoinColumn(name = "ID_CURSO"))
    private List<Curso> cursos;

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
     * @return the nroLegajo
     */
    public int getNroLegajo() {
        return nroLegajo;
    }

    /**
     * @param nroLegajo the nroLegajo to set
     */
    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
