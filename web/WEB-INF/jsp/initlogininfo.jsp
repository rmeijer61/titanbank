<%-- 
    Document   : initlogininfo
    Created on : Apr 27, 2014, 5:07:23 PM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String lastName = "";
    String firstName = "";
    String customerId = "";

    System.out.println("LAST NAME: " + request.getAttribute("lastName"));
    if ( (String) request.getAttribute("lastName") != null) { 
        lastName = (String) request.getAttribute("lastName");
        firstName = (String) request.getAttribute("firstName");
        customerId = (String) String.valueOf(request.getAttribute("customerId"));
    }
%>