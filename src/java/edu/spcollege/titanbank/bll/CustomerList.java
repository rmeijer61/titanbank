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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rmeijer
 */
public class CustomerList implements Serializable {
    private String sqlStatement = "";
    private PersonName personName;
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/titanbank";
    private final String dbUserId = "root";
    private final String dbPassword = "sesame";
    private Connection conn;
    private Statement st;
    private ResultSetMetaData md; 
    private final String mysqlPattern = "yyyy-mm-dd";
    private final SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
    // This method populates two types of result sets
    private ResultSet rs;
    private QueryResult queryResult;
    
    public List queryCustomerList() throws SQLException, ClassNotFoundException {
        sqlStatement = "select a.customerid, b.personId, b.lastname, b.firstname, b.middlename"
                     + ", b.suffix, b.birthdate, b.gender"
                     + " from customer a, person b"
                     + " where a.personid = b.personid";
        
        // Note: Diamond operator is new and may not be available in all JSP source
        List<PersonName> list = new ArrayList<>();
        
        // This method populates two types of result sets
        queryResult = new QueryResult();
 
        Class.forName(driverClassName);
        try {
            conn = DriverManager.getConnection(dbUrl, dbUserId, dbPassword); 
            st = conn.createStatement();
            rs = st.executeQuery(sqlStatement);
            md = rs.getMetaData();
            // get column names
            for (int i = 1 ; i <= md.getColumnCount() ; i++) {
                queryResult.addColumnName(md.getColumnName(i));
            }
            // get field values
            while (rs.next()) {
                for (int i = 1 ; i<=md.getColumnCount() ; i++) {
                    queryResult.addFieldValue(rs.getString(i));
                }
                // Create a person object and store values from the result set in it
                // Sdd th person object to a list
                personName = new PersonName(
                    rs.getInt(1)
                    ,rs.getInt(2)        
                    ,rs.getString(3)
                    ,rs.getString(4)
                    ,rs.getString(5)
                    ,rs.getString(6)
                    ,rs.getDate(7)
                    ,rs.getString(8)
                );
                list.add(personName);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        // For testing
        //for (PersonName temp : list) {
	//    System.out.println("Verify list: " + temp.getFullName());
        //}
            
        return list;
    }
}
