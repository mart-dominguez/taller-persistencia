/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public class DBConnection {
        //String url = "jdbc:h2:" + "db/h2test.db";
    private static final String url ="jdbc:h2:~/taller;AUTO_SERVER=TRUE;FILE_LOCK=SOCKET";
    //private static final String url ="jdbc:h2:mem:taller";
    //tcp://localhost/server~/dbname
    private static final String user="taller";
    private static final String pass="taller";
    
    private DBConnection(){
        // no se pueden crear instancias de esta clase
    }
    
    public static Connection get(){
        Connection conn=null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
