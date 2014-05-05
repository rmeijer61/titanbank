/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.*;
import java.io.IOException;
import java.sql.*;
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
 * @author Josh
 */
public class CheckInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private HttpSession session = null;
    private Boolean loggedIn = false;
    private String url = "";
    
    private Customer cust;
    private User user;
    private int custID;
    private String userType = "";
    private int checkNo;
    private dbCheckInfo dbCheck;
    private ResultSet rs;


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        if (loggedIn == null || loggedIn == false) {
            url = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(url);
            dispatcher.forward(request,response);        
        }
        else
        {
            userType = (String)request.getAttribute("userType");
            if(userType.equals("admin"))
            {
               checkNo = (int)request.getAttribute("tbCheck");
               custID = (int)request.getAttribute("tbCustID");
            }
            else
            {
                checkNo = (int)request.getAttribute("tbCheck");
                user = (User) session.getAttribute("user");
                custID = user.getCustomerId();            
            }
            
            try {
                dbCheck = new dbCheckInfo(checkNo,custID);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                rs = dbCheck.GetCheckInfo();
            } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            }
            
            
            String checkNo = "";
            String amount = "";
            String status = "";
            String checkID = "";
                
            try {
                while (rs.next()) {
                    
                    checkNo = rs.getString("checkNo");
                    amount = rs.getString("amount");
                    status = rs.getString("status");
                    checkID = rs.getString("checkID");
                    
                }
            } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            }
            
            request.setAttribute("checkNo", checkNo);
            request.setAttribute("amount", amount);
            request.setAttribute("status", status);
            request.setAttribute("checkID", checkID);
            request.setAttribute("custID",custID);
            
            String url = "/checkInfo.jsp";
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
                 
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
