/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String message = "";
    String errorMessage = "";
    String nextView = "";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        String userName = request.getParameter("userName");
        String userType = request.getParameter("userType");
        String password = request.getParameter("password");
 
        AuthenticationService auth = new AuthenticationService(userName, userType, password);
        if (auth.isAuthenticated()) {
                        
            // Store the User object in the session
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn",true);
            session.setAttribute("userName",userName);
            User user = auth.getUser();
            session.setAttribute("user",user);
            System.out.println("Update session with customer id: "+user.getCustomerId());
            session.setAttribute("customerId",user.getCustomerId());
            
            Customer customer = new Customer(user.getCustomerId());
            Person person = new Person(customer.getPersonId());
            // TODO - The next view is the index
            request.setAttribute("lastName",person.getLastName());
            request.setAttribute("firstName",person.getFirstName());
            request.setAttribute("customerId",user.getCustomerId());
            
            message = "You are logged in.";
            request.setAttribute("message",message);
            request.setAttribute("errorMessage","");
             
            // What type of user?
            switch (userType) {
                case "E":
                    nextView = "/WEB-INF/jsp/index2.jsp" ;
                    break;
                case "C":
                    nextView = "/WEB-INF/jsp/index.jsp" ;
                    break;
                default:
                    errorMessage = "Invalid user type.";
                    request.setAttribute("errorMessage",errorMessage);
                    nextView = "/WEB-INF/jsp/welcome.jsp";
                    break;
            }
            
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request ,response);
            // customer = new Customer(auth.getCustomerId());
        }
        else {
            message = "Sorry, Incorrect Password, Try Again";
            request.setAttribute("errorMessage",message);
            nextView = "/WEB-INF/jsp/welcome.jsp" ;
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request ,response);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
