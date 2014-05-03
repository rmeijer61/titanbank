/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.titanbank.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class EditInfoServlet extends HttpServlet {

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
        
        //will need to grab the personID from the HTTPSession
        int personID = 1;
        
        dbPersonInfo db = new dbPersonInfo(personID);
        
            String prefixTitle = "";
            String lastName = "";
            String firstName = "";
            String middleName = "";
            String suffix = "";
            String address1 = "";
            String address2 = "";
            String city = "";
            String country = "";
            String state = "";
            String emailAddress = "";
            String postalCode = "";
            String phone1 = "";
            
            prefixTitle = (String) request.getAttribute("prefixtitle");
            lastName = (String) request.getAttribute("lastname");
            firstName = (String) request.getAttribute("firstname");
            middleName = (String) request.getAttribute("middlename");
            suffix = (String) request.getAttribute("suffix");
            address1 = (String) request.getAttribute("address1");
            address2 = (String) request.getAttribute("address2");
            city = (String) request.getAttribute("city");
            country = (String) request.getAttribute("country");
            state = (String) request.getAttribute("state");
            emailAddress = (String) request.getAttribute("emailaddress");
            postalCode = (String) request.getAttribute("postalcode");
            phone1 = (String) request.getAttribute("phone1");
            
            ArrayList<String> stringList = new ArrayList<String>();
            
            boolean added;
            
            added = stringList.add(prefixTitle);
            added = stringList.add(firstName);
            added = stringList.add(middleName);
            added = stringList.add(lastName);
            added = stringList.add(suffix);
            added = stringList.add(address1);
            added = stringList.add(address2);
            added = stringList.add(city);
            added = stringList.add(state);
            added = stringList.add(postalCode);
            added = stringList.add(country);
            added = stringList.add(emailAddress);
            added = stringList.add(phone1);
            
            db.updatePersonInfo(stringList);
        
        try {

            String path = "/home.jsp"; //should return user back to screen where he first clicked on "Edit Info"
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
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
            Logger.getLogger(EditInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
