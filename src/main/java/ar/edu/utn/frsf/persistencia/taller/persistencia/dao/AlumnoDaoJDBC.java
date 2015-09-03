/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util.DBConnection;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public class AlumnoDaoJDBC implements AlumnoDao{

    private Alumno alumnoActual;
    
    /* sentencias sql para reuso */
    private static final String _TABLE_NAME = "ALUMNO"; 
    private static final String _SQL_INSERT_ALUMNO = "INSERT INTO "+_TABLE_NAME+" (NOMBRE,NRO_LEGAJO) VALUES(?,?)";
    private static final String _SQL_DELETE_ALUMNO = "DELETE FROM "+_TABLE_NAME+" WHERE ID = ?";
    private static final String _SQL_UPDATE_ALUMNO = "UPDATE "+_TABLE_NAME+" set NOMBRE =?,NRO_LEGAJO=? WHERE ID =?";
    private static final String _SQL_FIND_BY_ID_ALUMNO = "SELECT * FROM "+_TABLE_NAME+" WHERE ID = ?";
    private static final String _SQL_FIND_ALL_ALUMNO = "SELECT * FROM "+_TABLE_NAME;

    @Override
    public void set(Alumno a) {
        this.alumnoActual=a;
    }

    @Override
    public Alumno get() {
        return this.alumnoActual;                
    }

    @Override
    public void crear() {
        this.crear(this.alumnoActual);
    }

    @Override
    public void crear(Alumno a) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_INSERT_ALUMNO);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getNroLegajo());
            ps.executeUpdate();
            //no olvidar nunca cerrar todo!!!
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void actualizar() {
        this.actualizar(alumnoActual);
    }

    @Override
    public void actualizar(Alumno a) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_UPDATE_ALUMNO);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getNroLegajo());
            ps.setInt(3, a.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void borrar() {
        this.borrar(alumnoActual);
    }

    @Override
    public void borrar(Alumno a) {
        Connection conn = null;        
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_DELETE_ALUMNO);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Alumno buscarPorId(Integer id) {
        Connection conn = null;        
        Alumno resultado = new Alumno();
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_FIND_BY_ID_ALUMNO);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                resultado.setId(rs.getInt("ID"));
                resultado.setNombre(rs.getString("NOMBRE"));
                resultado.setNroLegajo(rs.getInt("NRO_LEGAJO"));
                // PENDIENTE a RESOLVER 
                // ¿Como retornar la lista de cursos a los que se anotó?????
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        return resultado;
    }

    @Override
    public List<Alumno> buscarTodos() {
        Connection conn = null;        
        List<Alumno> resultado = new ArrayList<Alumno>();
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_FIND_ALL_ALUMNO);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno tmp = new Alumno();
                tmp.setId(rs.getInt("ID"));
                tmp.setNombre(rs.getString("NOMBRE"));
                tmp.setNroLegajo(rs.getInt("NRO_LEGAJO"));
                // PENDIENTE a RESOLVER 
                // ¿Como retornar la lista de cursos a los que se anotó?????
                resultado.add(alumnoActual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        return resultado;
    }

    @Override
    public List<Alumno> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
