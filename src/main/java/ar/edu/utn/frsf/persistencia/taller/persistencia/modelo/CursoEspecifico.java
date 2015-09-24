/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.modelo;

import javax.persistence.DiscriminatorValue;

/**
 *
 * @author mdominguez
 */
@DiscriminatorValue(value = "E")
public class CursoEspecifico extends Curso {
    private int creditosRequeridos;

    /**
     * @return the creditosRequeridos
     */
    public int getCreditosRequeridos() {
        return creditosRequeridos;
    }

    /**
     * @param creditosRequeridos the creditosRequeridos to set
     */
    public void setCreditosRequeridos(int creditosRequeridos) {
        this.creditosRequeridos = creditosRequeridos;
    }

    @Override
    public String tipoCurso() {
        return "E";
    }
}
