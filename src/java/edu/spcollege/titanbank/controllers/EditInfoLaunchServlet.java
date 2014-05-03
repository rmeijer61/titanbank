/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.spcollege.titanbank.bll.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author maxximilianseijo
 */
public class EditInfoLaunchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private HttpSession session;
    Customer customer;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
            // Get the customer object from the session
            System.out.println("Get session...");
            session = request.getSession();
            System.out.println("Get customerId from session...");
            int customerId = (int) session.getAttribute("customerId");
            System.out.println("customerId: " + customerId);
            System.out.println("Get a customer object...");
            Customer customer = new Customer(customerId);
            //the person id will likely have to be retrieved as a session attribute
            //int personID = 1;
            int personID = customer.getPersonId();
            System.out.println("personId: " + personID);           

           
            System.out.println("Execute dbPersonInfo...");
            dbPersonInfo db = new dbPersonInfo(personID);
            System.out.println("dbPersonInfo done");
            
            ResultSet rs = null;
            rs = db.retrieveInfo();
            String prefixTitle = db.getPrefixTitle();
            String lastName = db.getLastName();
            String firstName = db.getFirstName();
            String middleName = db.getMiddleName();
            String suffix = db.getSuffix();
            String address1 = db.getAddress1();
            String address2 = db.getAddress2();
            String city = db.getCity();
            String country = db.getCountry();
            String state = db.getState();
            String emailAddress = db.getEmailAddress();
            String postalCode = db.getPostalCode();
            String phone1 = db.getPhone1();
            
            request.setAttribute("prefixtitle", prefixTitle);
            request.setAttribute("lastname", lastName);
            request.setAttribute("firstname", firstName);
            request.setAttribute("middlename", middleName);
            request.setAttribute("suffix", suffix);
            request.setAttribute("address1", address1);
            request.setAttribute("city", city);
            request.setAttribute("country", country);
            request.setAttribute("address2", address2);
            request.setAttribute("state", state);
            request.setAttribute("emailaddress", emailAddress);
            request.setAttribute("postalcode", postalCode);
            request.setAttribute("phone1", phone1);
        
        try {
            
            String url = "/WEB-INF/jsp/editinfo.jsp";
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(EditInfoLaunchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditInfoLaunchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(EditInfoLaunchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditInfoLaunchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
