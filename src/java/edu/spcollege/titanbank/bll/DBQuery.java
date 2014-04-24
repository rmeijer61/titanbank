/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class DBQuery implements Serializable {
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost/titanbank";
    private String dbUserId = "root";
    private String dbPassword = "sesame";
    public QueryResult doQuery(String sqlStatement) throws SQLException {
        QueryResult result = new QueryResult();
        try {
            Class.forName(driverClassName);
            try (Connection con = DriverManager.getConnection(
                    dbUrl , dbUserId , dbPassword)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sqlStatement);
                ResultSetMetaData md = rs.getMetaData();
                // get column names
                for (int i = 1 ; i <= md.getColumnCount() ; i++) {
                    result.addColumnName(md.getColumnName(i));
                }
                // get field values
                while (rs.next()) {
                    for (int i = 1 ; i<=md.getColumnCount() ; i++) {
                        result.addFieldValue(rs.getString(i));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null ;
        } catch (SQLException s) {
            s.printStackTrace();
            return null;
        }
        return result;
    }

}
