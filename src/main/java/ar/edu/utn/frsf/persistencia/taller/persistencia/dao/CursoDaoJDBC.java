/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao;

import ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util.DBConnection;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Curso;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.CursoEspecifico;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.CursoGeneral;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public class CursoDaoJDBC implements CursoDao{
     private Curso cursoActual;
    
    /* sentencias sql para reuso */
    private static final String _TABLE_NAME = "CURSO"; 
    private static final String _SQL_INSERT_CURSO = "INSERT INTO "+_TABLE_NAME+" (NOMBRE,CREDITOS,CREDITOS_REQUERIDOS,CUPO_MAXIMO,TIPO_CURSO) VALUES(?,?,?,?,?)";
    private static final String _SQL_DELETE_CURSO = "DELETE FROM "+_TABLE_NAME+" WHERE ID = ?";
    private static final String _SQL_UPDATE_CURSO = "UPDATE "+_TABLE_NAME+" set NOMBRE=?,CREDITOS=?,CREDITOS_REQUERIDOS=?,CUPO_MAXIMO=?,TIPO_CURSO=? WHERE ID =?";
    private static final String _SQL_FIND_BY_ID_CURSO = "SELECT * FROM "+_TABLE_NAME+" WHERE ID = ?";
    private static final String _SQL_FIND_ALL_CURSO = "SELECT * FROM "+_TABLE_NAME;

    @Override
    public void set(Curso a) {
        this.cursoActual = a;
    }

    @Override
    public Curso get() {
        return this.cursoActual;
    }

    @Override
    public void crear() {
        this.crear(this.cursoActual);
    }

    @Override
    public void crear(Curso a) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_INSERT_CURSO);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getCreditos());            
            if(a.tipoCurso().equalsIgnoreCase("E")){
                ps.setInt(3,((CursoEspecifico) a).getCreditosRequeridos() );
                ps.setNull(4, java.sql.Types.INTEGER);  
            }else{
                ps.setNull(3, java.sql.Types.INTEGER);  
                ps.setInt(4,((CursoGeneral) a).getCupoMaximo() );
            }
            ps.setString(5, a.tipoCurso());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Curso a) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_UPDATE_CURSO);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getCreditos());            
            if(a.tipoCurso().equals("E")){
                ps.setInt(3,((CursoEspecifico) a).getCreditosRequeridos() );
                ps.setNull(4, java.sql.Types.INTEGER);  
            }else{
                ps.setNull(3, java.sql.Types.INTEGER);  
                ps.setInt(4,((CursoGeneral) a).getCupoMaximo() );
            }
            ps.setString(5, a.tipoCurso());
            ps.setInt(6, a.getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys() ;          
            if (generatedKeys.next()) {
                a.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("No se pudo obtener un ID.");
            }
            generatedKeys.close();
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
    public void borrar() {
        this.borrar(this.cursoActual);
    }

    @Override
    public void borrar(Curso a) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(_SQL_DELETE_CURSO);
            ps.setInt(1, a.getId());
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
    public Curso buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso registrarDocente(Curso c, Docente d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso inscribirAlumno(Curso c, Alumno d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer cantidadInscriptos(Curso c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
