<%-- 
    Document   : initaccount
    Created on : Apr 28, 2014, 8:05:30 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    int accountNum = 0;
    String accountType = "";
    int customerId = 0;
    double balance = 0.0;
       
    System.out.println("init account...");
    if (request.getAttribute("accountNum") != null){
        accountNum = (Integer)request.getAttribute("accountNum");
        System.out.println("Got account number: "+accountNum);  
       
        if ( accountNum != 0) {
            System.out.println("get values for "+accountNum+"...");
            accountNum = (Integer) request.getAttribute("accountNum");
            System.out.println("accountnum: "+ accountNum);
            accountType = (String) request.getAttribute("accountType");
            System.out.println("accounttype: "+ accountType);
            customerId = (Integer) request.getAttribute("customerId");
            System.out.println("customerId: "+ customerId);
            balance = (Double) request.getAttribute("balance");
            System.out.println("balance: "+ balance);
       }
    }
%>
