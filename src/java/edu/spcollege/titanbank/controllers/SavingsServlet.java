/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.AuthenticationService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.spcollege.titanbank.bll.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author admin
 */
@WebServlet(name = "SavingsServlet", urlPatterns = {"/SavingsServlet"})
public class SavingsServlet extends HttpServlet {

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
    private HttpServletRequest request = null;
    private Boolean loggedIn = false;
    //
    private Customer customer;
    private User user;
    private int customerId = 0;
    //
    private int accountNum = 0;
    private String accountType = "S";
    private double balance;
    private Account savingsaccount;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        // Verify that the user is logged in
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        System.out.println("Check if the user entered values");
        accountType = (String)request.getParameter("accountType");
        System.out.println("Account Type: "+accountType);
        
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        else {
            user = (User) session.getAttribute("user");
            customerId = user.getCustomerId();
            System.out.println("Customer Id from User object: "+customerId);
            
            // Get the account data
            savingsaccount = new Account(customerId, "S");
            if (savingsaccount.getIsFound()) {
                balance = savingsaccount.getBalance();
                System.out.println("Customer Id: "+customerId+", " + "Balance: "+balance);
            }
            else {
                message = "Account not found";
                request.setAttribute("message", message);
            }
            
            setAccount(request, savingsaccount);
            
            // Display the page
            nextView = "/WEB-INF/jsp/viewaccount.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);
        }

    }
    
    private void setAccount(HttpServletRequest request, Account account) {
        request.setAttribute("accountNum", account.getAccountNum());
        System.out.println("Set AccountNum: "+account.getAccountNum());
        System.out.println("Set AccountNum 2: "+ (Integer)request.getAttribute("accountNum"));
        request.setAttribute("accountType", account.getAccountType());
        request.setAttribute("customerId", account.getCustomerId());
        request.setAttribute("balance", account.getBalance());
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
            Logger.getLogger(SavingsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SavingsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SavingsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SavingsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
