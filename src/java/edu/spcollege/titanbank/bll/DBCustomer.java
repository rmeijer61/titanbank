/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rmeijer
 */

public class DBCustomer {
    private int customerId = 0;
    private int personId = 0;
    private String userId = "";
    private String description = "";
    private String status = "";
    //
    private Connection conn = null;
    private DBConnect dbconnect;
    private Statement stmt;
    private int returnCode = 0;
    private String sqlStatement;
    private ResultSetMetaData md;
    private ResultSet rs;
    private int result = 0;
    private QueryResult queryResult;
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/titanbank";
    private final String dbUserId = "root";
    private final String dbPassword = "sesame";
    
    public int insertCustomer(Customer customer) throws SQLException {
        // Build the sql statement
        status = "ACTIVE";
        sqlStatement = "insert into customer (personid,description,status) values ("
                     + customer.getPersonId()
                     + ",'" + customer.getDescription() + "'"
                     + ",'" + customer.getStatus() + "'"
                     + ")";
        
        // Insert a new customer row, 
        dbconnect = new DBConnect();     
        if (dbconnect.getConn() != null) {
            try {
                conn = dbconnect.getConn();
                System.out.println(sqlStatement);
                stmt = conn.createStatement();
                returnCode = stmt.executeUpdate(sqlStatement);
                stmt.close();
                customerId = getLastId();
                System.out.println("Last insert id: "+customerId);
                conn.close();
            } catch (SQLException sqlex) {
                System.out.println("SQL Exception: "+sqlex);
                sqlex.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to connect to database");
        }
        return customerId;
    }
    
        
    public void updateCustomer(Customer customer) throws SQLException {
        // Build the sql statement
        // The status is the only thing to updte for this project
        // The customer can be cancelled
        
        if (customer.getStatus() != null) {
            sqlStatement = "update customer "
                         + " set status = '" + customer.getStatus() + "'"
                         + " where customerId = " + customer.getCustomerId()
                         ;
        
            dbconnect = new DBConnect();     
            if (dbconnect.getConn() != null) {
                try {
                    conn = dbconnect.getConn();
                    System.out.println(sqlStatement);
                    stmt = conn.createStatement();
                    returnCode = stmt.executeUpdate(sqlStatement);
                    stmt.close();
                    customerId = getLastId();
                    System.out.println("Last id: "+customerId);
                    conn.close();
                } catch (SQLException sqlex) {
                    System.out.println("SQL Exception: "+sqlex);
                    sqlex.printStackTrace();
                }
            }
            else {
                System.out.println("Failed to connect to database");
            }
        }
    }
    
    public void queryCustomer(int customerId) throws SQLException, ClassNotFoundException {
        System.out.println("queryCustomer: " + customerId);
        sqlStatement = "select * from customer where customerid = '" + customerId + "'";
        DBQuery dbquery = new DBQuery();
        queryResult = dbquery.doQuery(sqlStatement);
        
        Class.forName(driverClassName);
        try {
            conn = DriverManager.getConnection(dbUrl, dbUserId, dbPassword); 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlStatement);
            md = rs.getMetaData();
            while (rs.next()) {
                this.customerId = rs.getInt("customerid");
                this.personId = rs.getInt("personid");
                this.userId = rs.getString("userid");
                this.description = rs.getString("description");
                this.status = rs.getString("status");
                System.out.println("customerId: "+this.customerId);
                System.out.println("personId: "+this.personId);
                System.out.println("userId: "+this.userId);
                System.out.println("description: "+this.description);
                System.out.println("status: "+this.status);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private int getLastId() throws SQLException {
        stmt = conn.createStatement();
        System.out.println("last_insert_id...");
        ResultSet rs = stmt.executeQuery("select last_insert_id() as lastid");
        System.out.println("Execute done");
        int lastId = 0;
        if (rs.next()) {
            lastId = rs.getInt(1);
        } else {
            System.out.println("Error getting lastId");
        }
        System.out.println("last_insert_id: "+lastId);
        stmt.close();
        rs.close();
        return lastId;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    public int getPersonId() {
        return this.personId;
    }
    public String getUserId() {
        return this.userId;
    }
    public String getDescription() {
        return this.description;
    }
    public String getStatus() {
        return this.status;
    }
    
}
