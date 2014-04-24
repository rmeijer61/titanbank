/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rmeijer
 */
public class DBUpdate implements Serializable  {
    private String dbUrl = "jdbc:mysql://localhost/titanbank";
    String dbUserId = "root";
    String dbPassword = "sesame";
    String driverClassName = "com.mysql.jdbc.Driver";
    
    public int doUpdate(String sqlStatement) throws SQLException {
        int result = 0;
        Connection con = null;
        
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(dbUrl , dbUserId , dbPassword);
            Statement stmt = null ;
            stmt = con.createStatement();
            result = stmt.executeUpdate(sqlStatement);
            stmt.close();
            con.close();
            System.out.println(sqlStatement);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.out.println("Class not found");
        } catch (SQLException sqe) {
            System.out.println("SQL Exception");
            sqe.printStackTrace();
        }
        return result;
    }

}
