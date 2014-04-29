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
 * @author admin
 */
public class DBUser {
    private int userId = 0;
    private String userName = "";
    private String userType = "";
    private String password = "";
    private int customerId = 0;
    private boolean isAuthenticated = false;
    //
    private String sqlStatement = "";
    private Connection conn = null;
    private DBConnect dbconnect;
    private Statement stmt;
    private int returnCode = 0;
    // Query class from the textbook - I got lazy
    private QueryResult queryResult;
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/titanbank";
    private final String dbUserId = "root";
    private final String dbPassword = "sesame";
    private ResultSetMetaData md;
    private ResultSet rs;
    private int result = 0;
    
    public int insertUser(User user) throws SQLException {
        sqlStatement = 
            "insert into user(" 
            + "username,userType,password,customerId"
            + ")"
            + "values("
            + "'" + user.getUserName() + "'"
            + ",'" + user.getUserType() + "'"
            + ",'" + user.getPassword() + "'"
            + ",'" + user.getCustomerId() + "'"
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
                this.userId = getLastId();
                System.out.println("Last insert id: "+userName);
                conn.close();
            } catch (SQLException sqlex) {
                System.out.println("SQL Exception: "+sqlex);
                sqlex.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to connect to database");
        }
        return this.userId;
    }

    public void queryUser(String userName, String userType, String password) throws SQLException, ClassNotFoundException {
        System.out.println("queryUser: " + userName + ", " + userType + ", " + password);
        sqlStatement 
            = "select * from user"
            + " where"
            + " username = '" + userName + "'"
            + " and usertype = '" + userType + "'"
            + " and password = '" + password + "'"
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

                    // get field values
                    while (rs.next()) {
                        this.isAuthenticated = true;
                        this.userId = rs.getInt("userid");
                        System.out.println("userid: " + this.userId); 
                        this.userName = rs.getString("username");
                        System.out.println("username: " + this.userName); 
                        this.userType = rs.getString("usertype");
                        System.out.println("usertype: " + this.userType); 
                        this.password = "authenticated";
                        System.out.println("password: " + this.password); 
                        this.customerId = rs.getInt("customerid");
                        System.out.println("customerid: " + this.customerId); 
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
    public int getUserId() {
        return this.userId;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getUserType() {
        return this.userType;
    }
    public String getPassword() {
        return this.password;    
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public boolean getIsAuthenticated() {
        return this.isAuthenticated;
    }
}
