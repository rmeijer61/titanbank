<%-- 
    Document   : inittransfer
    Created on : Apr 28, 2014, 6:02:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    int transferId = 0;
    int customerId = 0;
    int fromAccountNum = 0;
    int toAccountNum = 0;
    boolean transferImmediately = false;
    double amount = 0.0;
    java.util.Date scheduleDate = null;
       
    System.out.println("init transfer...");
    if (request.getAttribute("transferId") != null){
        transferId = (Integer)request.getAttribute("transferId");
        System.out.println("Got transfer Id: "+transferId);  
       
        if ( transferId != 0) {
            System.out.println("get values for "+transferId+"...");
            transferId = (Integer) request.getAttribute("transferId");
            System.out.println("transferid: "+ transferId);
            customerId = (Integer) request.getAttribute("customerId");
            System.out.println("customerId: "+ customerId);
            fromAccountNum = (Integer) request.getAttribute("fromAccountNum");
            System.out.println("fromAccountNum: "+ fromAccountNum);
            toAccountNum = (Integer) request.getAttribute("toAccountNum");
            System.out.println("toAccountNum: "+ toAccountNum);
            amount = (Double) request.getAttribute("amount");
            System.out.println("amount: "+ amount);
            scheduleDate = (java.util.Date) request.getAttribute("scheduleDate");
            System.out.println("scheduleDate: "+ scheduleDate);
       }
    }
%>
