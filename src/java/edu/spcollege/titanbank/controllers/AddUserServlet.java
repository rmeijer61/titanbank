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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {

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
    private int userId = 0;
    private String userName = "";
    private String userType = "";
    private String password = "";
    private int customerId = 0;
    private User user;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        // Verify that the user is logged in
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        System.out.println("Check if the user entered values");
        userName = (String)request.getParameter("userName");
        System.out.println("userName: "+userName);
        
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        else if (userName != null) {
            System.out.println("Add new user");
            this.userName = request.getParameter("userName");
            this.userType = request.getParameter("userType");
            this.password = request.getParameter("password");
            this.customerId  = Integer.parseInt(request.getParameter("customerSelect"));
            
            System.out.println("Create user object");
            user = new User();
            System.out.println("Call insertUser");
            userId = user.insertUser(userName, userType, password, customerId);
            
            if (this.userId > 0) {
                message = "User " + this.userId + " has been succesfully added.";
            }
            else {
                message = "Error, user not added";
            }
            request.setAttribute("message", message);
            // Display the page again
            CustomerList customerList = new CustomerList();
            List<PersonName> personList = null;
            personList = customerList.queryCustomerList();
            request.setAttribute("personList", personList);
            
            nextView = "/WEB-INF/jsp/adduser.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);     
        }
        else{
            CustomerList customerList = new CustomerList();
            List<PersonName> personList = null;
            personList = customerList.queryCustomerList();
            request.setAttribute("personList", personList);
            
            nextView = "/WEB-INF/jsp/adduser.jsp";
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
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
