/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rmeijer
 */
public class DBAccount {
    private int accountNum = 0;
    private String accountType = "";
    private int customerId = 0;
    private double balance = 0;
    private boolean isFound = false;
    //
    private String sqlStatement = "";
    private Connection conn = null;
    private DBConnect dbconnect;
    private Statement stmt;
    private int returnCode = 0;
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/titanbank";
    private final String dbUserId = "root";
    private final String dbPassword = "sesame";
    private ResultSetMetaData md;
    private ResultSet rs;
    private int result = 0;
    
    public int insertAccount(Account account) throws SQLException {
        sqlStatement = 
            "insert into account(" 
            + "accountType,customerId,balance"
            + ")"
            + "values("
            + "'" + account.getAccountType() + "'"
            + "," + account.getCustomerId()
            + "," + account.getBalance()
            + ")";
        
        // Insert a new row, 
        dbconnect = new DBConnect();     
        if (dbconnect.getConn() != null) {
            try {
                conn = dbconnect.getConn();
                System.out.println("Connected");
                stmt = conn.createStatement();
                System.out.println("Execute: "+sqlStatement);
                
                returnCode = stmt.executeUpdate(sqlStatement);
                System.out.println("statement return code: " + returnCode);

                System.out.println("statement close()");
                stmt.close();
                System.out.println("Get last id");
                this.accountNum = getLastId();
                System.out.println("Last insert id: "+accountNum);
                conn.close();
            } catch (SQLException sqlex) {
                System.out.println("SQL Exception: "+sqlex);
                sqlex.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to connect to database");
        }
        return this.accountNum;
    }

    public void queryAccount(String accountType, int customerId ) throws SQLException, ClassNotFoundException {
        System.out.println("queryAccount: " + customerId + ", " + accountType);
        sqlStatement 
            = "select * from account"
            + " where"
            + " customerId = " + customerId
            + " and accounttype = '" + accountType + "'"
            ;
        
        try {
            DBConnect dbconnect = new DBConnect();
            if (dbconnect.getConn() != null) {
                conn = dbconnect.getConn();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlStatement);
                System.out.println("RS: " + rs.wasNull());
                if (!rs.wasNull()) {
                    // Testing 
                    // get column names
                    md = rs.getMetaData();
                    for (int i = 1 ; i <= md.getColumnCount() ; i++) {
                        System.out.println("ResultSet: " + md.getColumnName(i));
                    }

                    // get column values
                    while (rs.next()) {
                        this.isFound = true;
                        this.accountNum = rs.getInt("accountnum");
                        System.out.println("accountnum: " + this.accountNum); 
                        this.accountType = rs.getString("accounttype");
                        System.out.println("accounttype: " + this.accountType); 
                        this.customerId = rs.getInt("customerid");
                        System.out.println("customerid: " + this.customerId);  
                        this.balance = rs.getDouble("balance");
                        System.out.println("balance: " + this.balance); 
                    }
                }
                else {
                    System.out.println("SQL error");
                }
            }
            else {
                System.out.println("Failed to connect to database");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            rs.close();
            stmt.close();
            conn.close();
        }
    }

    private int getLastId() throws SQLException {
        stmt = conn.createStatement();
        System.out.println("last_insert_id...");
        rs = stmt.executeQuery("select last_insert_id() as lastid");
        System.out.println("Execute done");
        //String lastId = rs.getString(1);
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
    
    // Getters and Setters
    public int getAccountNum() {
        return this.accountNum;
    }
    public String getAccountType() {
        return this.accountType;
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public double getBalance() {
        return this.balance;    
    }
    public boolean getIsFound() {
        return this.isFound;
    }
}
