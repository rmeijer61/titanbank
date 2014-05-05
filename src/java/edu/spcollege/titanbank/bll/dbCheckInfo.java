/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.*;


/**
 * @author Josh
 **/
public class dbCheckInfo {
    private int checkNo;
    private int custID;
    DBConnect db;
    Connection connect;
           
    
    public dbCheckInfo (int checkNo, int custID) throws SQLException
    {      
        this.db = new DBConnect();
        this.checkNo = checkNo;
        this.custID = custID;
    }
    
    public ResultSet GetCheckInfo() throws SQLException
    {
        ResultSet rs = null;
        connect = null;
              
        try
        {

            
           connect = db.getConn();
           String query = "SELECT ch.checkID,ch.checkNo,ch.amount,ch.status "
                        + "FROM titianbank.check as ch "
                        + "inner join account as ac on ch.accountID = ac.accountnum "
                        + "inner join customer as cu on ac.customerid = cu.customerid "
                        + "WHERE cu.customerid ="
                        + custID
                        + " and ch.checkNo ="
                        + checkNo;
           PreparedStatement  ps = connect.prepareStatement(query);
           rs = ps.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            connect.close();
            return rs;
        }
                
     }
    
    public void UpdateStatus(String status, int checkID) throws SQLException
    {
        try
        {
           connect = db.getConn();
            
           connect = db.getConn();
           String query = "Update titianbank.check "
                        + "Set status ="
                        + status
                        + " WHERE checkID =" 
                        + checkID;
           PreparedStatement  ps = connect.prepareStatement(query);
           ps.executeUpdate(query);
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());               
        }
        finally
        {
           connect.close();
        }
    }
}
