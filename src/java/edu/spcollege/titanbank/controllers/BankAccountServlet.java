/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.spcollege.titanbank.bll.*;
/**
 *
 * @author admin
 */
@WebServlet(name = "BankAccountServlet", urlPatterns = {"/BankAccountServlet"})
public class BankAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     private String userid;
    private String customerId;
    private UserLoginStatus userLoginStatus;
    private Customer customer;
    private BankAccount bankAccount;
    private double startingBalance;
    private String message;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Note: simulation
        customerId = "1234";
        customer = new Customer(customerId);
        startingBalance = 200.0;
        
        // Verify login
        userid = "cop2806";
        userLoginStatus = new UserLoginStatus(userid);
        if (userLoginStatus.isLoggedIn(userid)) {
            
            // Open the account
            bankAccount = new BankAccount(customer, startingBalance, BankAccount.AccountType.SAVINGS );
           
            message = "Opened a " + bankAccount.getAccountType() + " account with " + bankAccount.getBalance() + " dollars.";     
        
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet BankAccountServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet BankAccountServlet at " + request.getContextPath() + "</h1>");
                out.println("<h4>" + message + "</h4>");
                out.println("</body>");
                out.println("</html>");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
