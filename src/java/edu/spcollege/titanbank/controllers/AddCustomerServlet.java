/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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

@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/AddCustomerServlet"})
public class AddCustomerServlet extends HttpServlet {

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
    private Person person;
    private Customer customer;
    private int customerId;
    private QueryResult queryResult;
    
    private int personId = 0;
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private java.util.Date birthDate = null;
    private String gender = "";
    private String prefixTitle = "";
    private String suffix = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String country = "";
    private String state = "";
    private String postalCode = "";
    private String emailAddress = "";
    private String phone1 = "";
    
    String jspPattern = "MM/dd/yyyy";
    SimpleDateFormat jspDateFormat = new SimpleDateFormat(jspPattern);
    String mysqlPattern = "yyyy-mm-dd";
    SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
 
        // Verify that the user is logged in
        session = request.getSession();
        loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        //System.out.println("Process the person"+request.getParameter("personSelect"));
        if (loggedIn == null || loggedIn == false) {
            nextView = "/WEB-INF/jsp/welcome.jsp" ;
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request ,response);        
        }
        else if (request.getParameter("personSelect") != null) {
            // UPDATE - Customer selected from the drop down list
            personId = Integer.parseInt(request.getParameter("personSelect"));
            this.person = new Person(personId);
            setValues(request);
            // 
            nextView = "/WEB-INF/jsp/person.jsp" ;
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);
        }
        else if (request.getParameter("lastName") != null) {
            // INSERT - new person
            System.out.println("Process person insert");
            if (validateInput(request)) {
                System.out.println("Process person insert 2");
                person = buildPerson();
                if (updatePerson(person, "INSERT")) {
                    System.out.println("Process person insert 3");
                    
                    // Insert customer row
                    customer = new Customer();
                    // Supply a person id
                    this.customerId = customer.insertCustomer("personId",personId);
                    
                    message = "Customer has been added: "+customerId ;
                }
                else {
                    message = "Error adding person";
                }
                request.setAttribute("message",message);
                nextView = "/WEB-INF/jsp/person.jsp" ;
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
                dispatcher.forward(request,response);
            }
            else {
                nextView = "/WEB-INF/jsp/person.jsp" ;
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
                dispatcher.forward(request,response);
            }
        }
        else {
            nextView = "/WEB-INF/jsp/person.jsp" ;
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(nextView);
            dispatcher.forward(request,response);        
        }
        
    }
    private boolean validateInput(HttpServletRequest request) {
        boolean validInput = false;
        System.out.println("Validate");
        this.prefixTitle = (String) request.getParameter("prefixTitle");
        this.lastName = (String) request.getParameter("lastName");
        this.firstName = (String) request.getParameter("firstName");
        this.middleName = (String) request.getParameter("middleName");
        
        String birthDateString = (String) request.getParameter("birthDate");
       
        try {
            this.birthDate = (java.util.Date)jspDateFormat.parse(String.valueOf(birthDateString));
        } 
        catch (ParseException ex) {
            java.util.logging.Logger.getLogger(AddCustomerServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (RuntimeException ex) {
            java.util.logging.Logger.getLogger(AddCustomerServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        this.gender = (String) request.getParameter("gender");
        this.suffix = (String) request.getParameter("suffix");
        this.address1 = (String) request.getParameter("address1");
        this.address2 = (String) request.getParameter("address2");
        this.city = (String) request.getParameter("city");
        this.country = (String) request.getParameter("country");
        this.state = (String) request.getParameter("state");
        this.postalCode = (String) request.getParameter("postalCode");
        this.emailAddress = (String) request.getParameter("emailAddress");
        this.phone1 = (String) request.getParameter("phone1");
        // TODO
        validInput = true;
        return validInput;
    }
    
    private Person buildPerson() {
        // Create a person object from JSP values
        System.out.println("Build person from JSP");
        Person person = new Person();
        person.setPrefixTitle(this.prefixTitle);
        person.setLastName(this.lastName);
        person.setFirstName(this.firstName);
        person.setMiddleName(this.middleName);
        person.setBirthDate(this.birthDate);
        person.setGender(this.gender);
        person.setSuffix(this.suffix);
        person.setAddress1(this.address1);
        person.setAddress2(this.address2);
        person.setCity(this.city);
        person.setCountry(this.country);
        person.setState(this.state);
        person.setPostalCode(this.postalCode);
        person.setEmailAddress(this.emailAddress);
        person.setPhone1(this.phone1);
        return person;
    }
    
    private boolean updatePerson(Person person, String DMLType) throws SQLException {
        switch (DMLType) {
            case "INSERT":
                personId = person.insertPerson();
                break;
            case "UPDATE":
                break;
            case "DELETE":
                break;
            default:
                System.out.println("Unknown DML operation");
                break;
        }
        
        return true;
    }
    
    private boolean setValues(HttpServletRequest request) {
        
        request.setAttribute("personId",String.valueOf(person.getPersonId()));
        request.setAttribute("prefixTitle",person.getPrefixTitle());
        request.setAttribute("lastName",person.getLastName());
        request.setAttribute("firstName",person.getFirstName());
        request.setAttribute("middleName",person.getMiddleName());
        request.setAttribute("birthDate",jspDateFormat.format(person.getBirthDate()));
        request.setAttribute("gender",person.getGender());
        request.setAttribute("suffix",person.getSuffix());
        request.setAttribute("address1",person.getAddress1());
        request.setAttribute("address2",person.getAddress2());
        request.setAttribute("city",person.getCity());
        request.setAttribute("state",person.getState());
        request.setAttribute("country",person.getCountry());
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
            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
