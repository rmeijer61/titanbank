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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rmeijer
 */
public class DBTransfer {
    private int transferId = 0;
    private int customerId = 0;
    private String transferStatus = "";
    private int fromAccountNum = 0;
    private int toAccountNum = 0;
    private double amount = 0.0;
    private boolean transferImmediately = false;
    private java.util.Date scheduleDate;
    private boolean isFound = false;
    private List<Transfer> transferList;
    //
    String jspPattern = "MM/dd/yyyy";
    SimpleDateFormat jspDateFormat = new SimpleDateFormat(jspPattern);
    String mysqlPattern = "yyyy-MM-dd";
    SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
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
    //
    Transfer transfer;
    
    public int insertTransfer(Transfer transfer) throws SQLException {
        System.out.println("DBTransfer.insertTransfer()...");
        String mysqlPattern = "yyyy-MM-dd";
        SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
        
        sqlStatement = 
            "insert into transfer(" 
            + "customerid,transferstatus,fromaccountnum,toaccountnum,amount,transferimmediately,scheduledate"
            + ")"
            + "values("
            + transfer.getCustomerId()
            + ",'" + transfer.getTransferStatus() +"'"
            + "," + transfer.getFromAccountNum()
            + "," + transfer.getToAccountNum()
            + "," + transfer.getAmount()
            + "," + transfer.getTransferImmediately()   
            + ",'" + mysqlDateFormat.format(transfer.getScheduleDate())+"'"
            + ")";
        System.out.println("Created SQL: "+sqlStatement);
        
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
                this.transferId = getLastId();
                System.out.println("Last insert id: "+transferId);
                conn.close();
            } catch (SQLException sqlex) {
                System.out.println("SQL Exception: "+sqlex);
                sqlex.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to connect to database");
        }
        return this.transferId;
    }

    public void queryTransfer(int customerId, String transferStatus) throws SQLException, ClassNotFoundException {
        System.out.println("queryTransfer: " + customerId + ", " + transferStatus);
        sqlStatement 
            = "select * from transfer"
            + " where"
            + " customerId = " + customerId
            + " and transferStatus = '" + transferStatus + "'"
            ;
        
        try {
            dbconnect = new DBConnect();
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
                        this.transferId = rs.getInt("transferid");
                        System.out.println("transferid: " + this.transferId); 
                        this.customerId = rs.getInt("customerid");
                        System.out.println("customerid: " + this.customerId);
                        this.fromAccountNum = rs.getInt("fromaccountnum");
                        System.out.println("fromaccoutnum: " + this.fromAccountNum);
                        this.toAccountNum = rs.getInt("toaccountnum");
                        System.out.println("toaccoutnum: " + this.toAccountNum);
                        this.amount = rs.getDouble("amount");
                        System.out.println("amount: " + this.amount);
                        this.transferImmediately = rs.getBoolean("transferimmediately");
                        System.out.println("transferimmediately: " + this.transferImmediately);
                        this.scheduleDate = rs.getDate("scheduledate");
                        System.out.println("schedultdate: " + this.scheduleDate); 
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
    
    public boolean queryTransferList(int customerId, String transferStatus) throws SQLException, ClassNotFoundException {
        System.out.println("DBTransfer.queryTransferList()...("+ customerId + "," +transferStatus + ")");
        String transferStatusClause = "";
        if ("P".equals(transferStatus) || "C".equals(transferStatus)) {
            transferStatusClause = " and transferstatus = '" + transferStatus + "'";     
        }
        else {
             transferStatusClause = " ";
        }
        sqlStatement = "select * from transfer"
                     + " where customerid = "
                     + customerId
                     + transferStatusClause
                     ;
        System.out.println("DBTransfer.queryTransferList() SQL: " + sqlStatement);
        
        // Note: Diamond operator is new and may not be available in all JSP source
        this.transferList = new ArrayList<>();
        
        try {
            dbconnect = new DBConnect();
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
                    Transfer transferRow;
                    while (rs.next()) {
                        this.isFound = true;
                        transferRow = new Transfer();
                        transferRow.setTransferId(rs.getInt("transferid"));
                        System.out.println("transferid: " + transferRow.getTransferId()); 
                        transferRow.setCustomerId(rs.getInt("customerid"));
                        System.out.println("customerid: " + transferRow.getCustomerId());
                        transferRow.setTransferStatus(rs.getString("transferstatus"));
                        System.out.println("transferstatus: " + transferRow.getTransferStatus());
                        transferRow.setFromAccountNum(rs.getInt("fromaccountnum"));
                        System.out.println("fromaccoutnum: " + transferRow.getFromAccountNum());
                        transferRow.setToAccountNum(rs.getInt("toaccountnum"));
                        System.out.println("toaccoutnum: " + transferRow.getToAccountNum());
                        transferRow.setAmount(rs.getDouble("amount"));
                        System.out.println("amount: " + transferRow.getAmount());
                        transferRow.setTransferImmediately(rs.getBoolean("transferimmediately"));
                        System.out.println("transferimmediately: " + transferRow.getTransferImmediately());
                        transferRow.setScheduleDate(rs.getDate("scheduledate"));
                        System.out.println("schedultdate: " + transferRow.getScheduleDate());
                        this.transferList.add(transferRow);
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
                
        // For testing
        for (Transfer temp : transferList) {
	    System.out.println("Verify list: " + temp.getTransferId());
            System.out.println("Verify list: " + jspDateFormat.format(temp.getScheduleDate()));
            System.out.println("Verify list: " + temp.getTransferStatus());
            System.out.println("Verify list: " + temp.getFromAccountNum());
            System.out.println("Verify list: " + temp.getToAccountNum());
            System.out.println("Verify list: " + temp.getAmount());
        }
            
        return this.isFound;
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
    //
    public int getTransferId() {
        return this.transferId;
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public String getTransferStatus() {
        return transferStatus;
    }
    public int getFromAccountNum() {
        return this.fromAccountNum;
    }
    public int getToAccountNum() {
        return this.toAccountNum;
    }
    public double getAmount() {
        return this.amount;
    }
    public boolean getTransferImmediately(){
        return this.transferImmediately;
    }
    public java.util.Date getScheduleDate() {
        return this.scheduleDate;
    }
    public List getTransferList() {
        return this.transferList;
    }
    public boolean getIsFound() {
        return this.isFound;
    }
}
