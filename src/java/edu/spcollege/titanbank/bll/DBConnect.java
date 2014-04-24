/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rmeijer
 */
public class DBConnect {
    private String dbUrl = "jdbc:mysql://localhost/titanbank";
    String dbUserId = "root";
    String dbPassword = "sesame";
    String driverClassName = "com.mysql.jdbc.Driver";
    Connection conn;
    
    public DBConnect() throws SQLException {
        this.conn = doConnect();
    }
    
    private Connection doConnect() throws SQLException {
        conn = null;
        
        try {
            Class.forName(driverClassName);
            this.conn = DriverManager.getConnection(dbUrl , dbUserId , dbPassword);
            Statement stmt = null ;
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.out.println("Class not found");
        } catch (SQLException sqe) {
            System.out.println("SQL Exception");
            sqe.printStackTrace();
        }
        return conn;
    }
    
    public Connection getConn() {
        return this.conn;
    }
}
