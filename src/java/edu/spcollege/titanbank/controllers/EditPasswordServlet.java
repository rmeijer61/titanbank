/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.titanbank.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.spcollege.titanbank.bll.*;
/**
 *
 * @author maxximilianseijo
 */
public class EditPasswordServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String password = "";
        String oldPassword = "";
        String newPassword = "";
        String newPasswordConfirm = "";
        
        //userID will need to be retrieved from the HTTPSession
        int userID = 1;
        
        dbPasswordChange db = new dbPasswordChange(userID);
        
        password = db.retrievePassword();
        
        oldPassword = (String) request.getAttribute("oldpassword");
        newPassword = (String) request.getAttribute("newpassword");
        newPasswordConfirm = (String) request.getAttribute("newpasswordconfirm");
        
        if (oldPassword.equals(password) && newPassword.equals(newPasswordConfirm)) {
            db.updatePassword(newPassword);
        }
        else {
            //We will need a way to handle the incorrect input.
            //I'm not sure if you have a class for this or not, so I'll leave this up to you.
        }
        
        try {
            //take user to home page
            String url = "/home.jsp";
            
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
            Logger.getLogger(EditPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
