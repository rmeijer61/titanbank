<%-- 
    Document   : initupdatecustomer
    Created on : Apr 19, 2014, 4:55:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String customerId = "";
    String personId = "";
    String prefixTitle = "";
    String lastName = "";
    String firstName = "";
    String middleName = "";
    String birthDate = "";
    String gender = "";
    String suffix = "";
    String address1 = "";
    String address2 = "";
    String city = "";
    String state = "";
    String country = "";
    String postalCode = "";
    String emailAddress = "";
    String phone1 = "";
    
 if (request.getAttribute("personId") != null) { 
    customerId = (String) request.getAttribute("customerId");
    personId = (String) request.getAttribute("personId");
    prefixTitle = (String) request.getAttribute("prefixTitle");
    lastName = (String) request.getAttribute("lastName");
    firstName = (String) request.getAttribute("firstName");
    middleName = (String) request.getAttribute("middleName");
    birthDate = (String) request.getAttribute("birthDate");
    gender = (String) request.getAttribute("gender");
    suffix = (String) request.getAttribute("suffix");
    address1 = (String) request.getAttribute("address1");
    address2 = (String) request.getAttribute("address2");
    city = (String) request.getAttribute("city");
    state = (String) request.getAttribute("state");
    country = (String) request.getAttribute("country");
    postalCode = (String) request.getAttribute("postalCode");
    emailAddress = (String) request.getAttribute("emailAddress");
    phone1 = (String) request.getAttribute("phone1");

 } 
%>
