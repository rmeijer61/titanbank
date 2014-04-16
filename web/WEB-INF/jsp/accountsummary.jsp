<%-- 
    Document   : accountsummary
    Created on : Apr 12, 2014, 3:06:39 PM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" 
        import="edu.spcollege.titanbank.bll.*, java.util.Date, java.util.ArrayList" 
        errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<% // Verify that the user is logged in
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || loggedIn.booleanValue() == false) {
%>
        <jsp:forward page="/WEB-INF/jsp/login.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>
<jsp:useBean id="user" scope="session" class="edu.spcollege.titanbank.bll.User" />

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/stdhead.jsp" />    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Summary of Accounts</title>
</head>
<body class="contentBody">
<div>
    <span><jsp:getProperty name="user"
               property="firstName" />
    </span>
    <span><jsp:getProperty name="user"
               property="lastName" />
    </span>
    <span>&nbsp;&nbsp;Logged in at&nbsp <%= today %></span>
</div>
<div class="contentWrapper">
<div class="content_2col_heading">
    <h3>Summary of Accounts</h3>
</div>   

<div class="summaryBox">
    <div class="summaryBoxTitle">
        <span>Savings Account Summary</span>
    </div>
    <div class="summaryBoxHeading">
        <div class="summaryBox_c1">
            <span>Activity</span>
        </div>
        <div class="summaryBox_c2">
            <span>Amount</span>
        </div>
    </div>    

    <div class="summaryBoxTotal">
        <div class="summaryBoxDetail_r1">        
            <div class="summaryBox_c1">
                <span>Balance</span>
            </div>
            <div id="summaryBoxDetail_savingsTotal" class="summaryBox_c2">
                <span>$0.00</span>
            </div>
        </div>
    </div>
    
</div>

<div class="summaryBox">
    <div class="summaryBoxTitle">
        <span>Checking Account Summary</span>
    </div>
    <div class="summaryBoxHeading">
        <div class="summaryBox_c1">
            <span>Activity</span>
        </div>
        <div class="summaryBox_c2">
            <span>Amount</span>
        </div>
    </div>    

    <div class="summaryBoxTotal">
        <div class="summaryBoxDetail_r1">        
            <div class="summaryBox_c1">
                <span>Balance</span>
            </div>
            <div id="summaryBoxDetail_checkingTotal" class="summaryBox_c2">
                <span>$0.00</span>
            </div>
        </div>
    </div>
    
</div>    
    
</div> <!-- End wrapper -->
</body>
