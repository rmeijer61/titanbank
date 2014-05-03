/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
            //the person id will likely have to be retrieved as a session attribute
            int personID = 1;
            
            dbPersonInfo db = new dbPersonInfo(personID);
            ResultSet rs = null;
            rs = db.retrieveInfo();
            
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
                
            while (rs.next()) {
                    
            prefixTitle = rs.getString("prefixtitle");
            lastName = rs.getString("lastname");
            firstName = rs.getString("firstname");
            middleName = rs.getString("middlename");
            suffix = rs.getString("suffix");
            address1 = rs.getString("address1");
            city = rs.getString("city");
            country = rs.getString("country");
            address2 = rs.getString("address2");
            state = rs.getString("state");
            emailAddress = rs.getString("emailaddress");
            postalCode = rs.getString("postalcode");
            phone1 = rs.getString("phone1");
 
            }
                request.setAttribute("prefextitle", prefixTitle);
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
            
            String url = "/editinfo.jsp";
            
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
