/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "QueryCustomerServlet", urlPatterns = {"/QueryCustomerServlet"})
public class QueryCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String message;
    private String nextView;
    private HttpSession session;
    private Boolean loggedIn;
    private int customerId;
    private Customer customer;
    private int personId;
    private Person person;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
       
        // Verify that the user is logged in
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        else if (request.getParameter("personId") != null) {
            person = new Person(personId);
            
            if (setValues(request, person)) {
                nextView = "/WEB-INF/jsp/customer.jsp";
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
                dispatcher.forward(request,response);
            }
            else {
                nextView = "/WEB-INF/jsp/customer.jsp";
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
                dispatcher.forward(request,response);
            }
        }
        else {
            nextView = "/WEB-INF/jsp/customer.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        
    }
    private boolean setValues(HttpServletRequest request, Person person) {
        request.setAttribute("prefixTitle",person.getPrefixTitle());
        request.setAttribute("lastName",person.getLastName());
        request.setAttribute("firstName",person.getFirstName());
        request.setAttribute("middleName",person.getMiddleName());
        
        String jspPattern = "mm/dd/yyyy";
        SimpleDateFormat jspDateFormat = new SimpleDateFormat(jspPattern);
       
        request.setAttribute("birthDate",jspDateFormat.format(person.getBirthDate()));
        request.setAttribute("gender",person.getGender());
        request.setAttribute("suffix",person.getSuffix());
        request.setAttribute("address1",person.getAddress1());
        request.setAttribute("address2",person.getAddress2());
        request.setAttribute("city",person.getCity());
        request.setAttribute("country",person.getCountry());
        request.setAttribute("state",person.getState());
        request.setAttribute("postalCode",person.getPostalCode());
        request.setAttribute("emailAddress",person.getEmailAddress());
        request.setAttribute("phone1",person.getPhone1());
        return true;
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
            Logger.getLogger(QueryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(QueryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
