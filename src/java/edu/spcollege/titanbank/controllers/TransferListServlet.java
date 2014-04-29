/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;


import edu.spcollege.titanbank.bll.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
 * @author rmeijer
 */
@WebServlet(name = "TansferListServlet", urlPatterns = {"/TansferListServlet"})
public class TransferListServlet extends HttpServlet {

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
    private User user = null;
    private Customer customer = null;
    private int customerId = 0;
    private Transfer transfer = null;
    private String transferStatus = "";
    private String selectedTransferStatus = "";
    private List<Transfer> transferList = null;
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
        System.out.println("Transfer list customer id: "+customerId);
        
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp";
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        else {
            System.out.println("Get transfer status...");
            if (request.getParameter("transferStatus") == null) {
                System.out.println("No transfer status selected, default to all.");
            }
            else {
                transferStatus = request.getParameter("transferStatus");
                request.setAttribute("selectedTransferStatus", transferStatus);
                System.out.println("Got transfer status: "+transferStatus);
            }
                
            System.out.println("Create transfer object: "+customerId);
            Transfer transfer = new Transfer();
            isFound = transfer.queryTransferList(customerId, transferStatus);
            
            if (isFound) {
                System.out.println("Get transfer list...");
                transferList = transfer.getTransferList();
                System.out.println("Transfer list customerId: "+transferList.get(1).getCustomerId());
                request.setAttribute("transferList", transferList);
            }
            else {
                message = "No transfers found";
            }
            request.setAttribute("message", message);
            
            nextView = "/WEB-INF/jsp/transferlist.jsp";
            System.out.println("Display page: "+nextView);
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
            Logger.getLogger(TransferListServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferListServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransferListServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferListServlet.class.getName()).log(Level.SEVERE, null, ex);
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
