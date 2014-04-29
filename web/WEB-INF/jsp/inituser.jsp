<%-- 
    Document   : inituser
    Created on : Apr 27, 2014, 3:12:33 PM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String personName = "";
    String customerId = "";
    String userName = "";
    String userType = "";
    String password = "";
    
 if (request.getAttribute("userName") != null) { 
    userName = (String) request.getAttribute("userName");
    userType = (String) request.getAttribute("userType");
    password = (String) request.getAttribute("password");
 } 
%>
