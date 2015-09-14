/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class MiEntityManager {
    private static EntityManagerFactory _entityManagerFactory = null;
    
    private static void inicializar(){
        if(_entityManagerFactory==null)
        _entityManagerFactory = Persistence.createEntityManagerFactory("taller");
    }

    public static EntityManager get(){
        inicializar();
        return _entityManagerFactory.createEntityManager();
    }
    
}