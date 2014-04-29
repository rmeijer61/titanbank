/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.spcollege.titanbank.bll.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author admin
 */
@WebServlet(name = "TransferServlet", urlPatterns = {"/TransferServlet"})
public class TransferServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String message = "";
    private String nextView = "";
    private HttpSession session = null;
    private Boolean loggedIn = false;
    //
    private User user;
    private Customer customer;
    private Transfer transfer;
     //
    private int transferId = 0;
    private int customerId = 0;
    private String transferStatus = "";
    private int fromAccountNum = 0;
    private int toAccountNum = 0;
    private double amount = 0.0;
    private String amountString = "";
    private boolean transferImmediately = false;
    private java.util.Date scheduleDate = null;
    private String scheduleDateString = "";
    private String transferFromAccountType = "";
    private String transferToAccountType = "";
    private boolean isFound = false;
    //
    String jspPattern = "MM/dd/yyyy";
    SimpleDateFormat jspDateFormat = new SimpleDateFormat(jspPattern);
    String mysqlPattern = "yyyy-MM-dd";
    SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Verify that the user is logged in
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        System.out.println("Get the customer id from the session...");
        //customerId  = (Integer)session.getAttribute("customerId");
        user = (User)session.getAttribute("user");
        customerId = user.getCustomerId();
        System.out.println("Customer id: "+customerId);
        
        System.out.println("Check if the user entered values");
        //String fromAccountNum_String = String.valueOf(request.getParameter("fromAccountNum"));
        //System.out.println("fromAccountNum: "+fromAccountNum_String);
        //String toAccountNum_String = String.valueOf(request.getParameter("toAccountNum"));
        //System.out.println("toAccountNum: "+toAccountNum_String);
        
        if (request.getParameter("fromAccountNum") == null || request.getParameter("toAccountNum") == null ) {
            System.out.println("Null parameters");
        }
        else {
            System.out.println("Check account numbers...");
            fromAccountNum = Integer.parseInt(request.getParameter("fromAccountNum"));
            System.out.println("fromAccountNum: "+fromAccountNum);
            toAccountNum = Integer.parseInt(request.getParameter("toAccountNum"));
            System.out.println("toAccountNum: "+toAccountNum);
        }
        System.out.println("Check login...");
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        else if (fromAccountNum > 0 && toAccountNum > 0) {
            System.out.println("Add new transfer");
            this.transferStatus = (String)request.getParameter("transferStatus");
            this.fromAccountNum = Integer.parseInt(request.getParameter("fromAccountNum")); 
            this.toAccountNum = Integer.parseInt(request.getParameter("toAccountNum"));
            this.amount = Double.parseDouble(request.getParameter("amount"));
            
            String transferImmediatelyString = (String) request.getParameter("transferImmediately");
            this.transferImmediately = Boolean.parseBoolean(transferImmediatelyString);
            System.out.println("transferImmediately: "+transferImmediately);
            
            System.out.println("Process date...");
            if (this.transferImmediately) {
                this.scheduleDate = new java.util.Date();
                System.out.println("Transfer immediately on: " + jspDateFormat.format(scheduleDate));
            }
            else {
                scheduleDateString = (String)request.getParameter("scheduleDate");
                if (scheduleDateString != null) {
                    try {
                        this.scheduleDate = (java.util.Date)jspDateFormat.parse(String.valueOf(scheduleDateString));
                    } 
                    catch (ParseException ex) {
                        java.util.logging.Logger.getLogger(TransferServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    catch (RuntimeException ex) {
                        java.util.logging.Logger.getLogger(TransferServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                else {
                    this.scheduleDate = new java.util.Date();
                    System.out.println("Schedule date deafaults to :" + jspDateFormat.format(scheduleDate));
                }
            }
            
            System.out.println("Create transfer object");
            transfer = new Transfer();
            System.out.println("Call insertTransfer");
            transferId = transfer.insertTransfer(customerId, "P", fromAccountNum, toAccountNum, amount, transferImmediately, scheduleDate);
            System.out.println("Insert returned transfer id number: "+transferId);
            
            if (transferId > 0) {
                message = "Created"  
                        + " transfer request: " + transfer.getTransferId()  
                        + ", customer: " + transfer.getCustomerId()
                        + ", status: " + transfer.getTransferStatus()
                        + ", amount: " + transfer.getAmount()
                        + ", immediate: " + transfer.getTransferImmediately()
                        + ", date: " + jspDateFormat.format(transfer.getScheduleDate());
                        ;
            }
            else {
                message = "Error, transfer not added";
            }
            request.setAttribute("message", message);
            // Display the page again
            nextView = "/WEB-INF/jsp/transfer.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);     
        }
        else {
            // Verify cleanup
             // Display the page
            System.out.println("Display the page...");
            nextView = "/WEB-INF/jsp/transfer.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TransferServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TransferServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
