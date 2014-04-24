<%-- 
    Document   : viewchecking
    Created on : Apr 11, 2014, 4:46:40 PM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" 
        import="edu.spcollege.titanbank.bll.*, java.util.Date" 
        errorPage="errorPage.jsp" %>
<% // Verify that the user is logged in
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || loggedIn.booleanValue() == false) {
%>
        <jsp:forward page="welcome.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>

<% 
    String firstName;
    String lastName;
    firstName = (String) request.getAttribute("fistName");
    lastName = (String) request.getAttribute("lastName");
    String checkingBeginBalance = "";
    String checkingDepositTotal = "";
    String checkingWithdrawTotal = "";
    String checkingBalance = "";
    checkingBeginBalance = (String) request.getAttribute("checkingBeginBalance");
    checkingDepositTotal = (String) request.getAttribute("checkingDepositTotal");
    checkingWithdrawTotal = (String) request.getAttribute("checkingWithdrawTotal");      
    checkingBalance  = (String) request.getAttribute("checkingBalance");      
%>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Checking Account</title>
</head>
<body class="contentBody">
<div id="contentWrapper">
<div>
    <span><%= firstName + " " + lastName %>&nbsp;&nbsp;Logged in at&nbsp <%= today %></span>
</div>
<div class="content_2col_heading">
    <h3>Checking Account Summary</h3>
</div>   

<div class="summaryBox">
    <div class="summaryBoxTitle">
        <span>Current Month Summary</span>
    </div>
    <div class="summaryBoxHeading">
        <div class="summaryBox_c1">
            <span>Activity</span>
        </div>
        <div class="summaryBox_c2">
            <span>Amount</span>
        </div>
    </div>    
    <div class="summaryBoxDetail">
        <div class="summaryBoxDetail_r1">
            <div class="summaryBox_c1">
                <span>Beginning Balance</span>
            </div>
            <div id="summaryBoxDetail_beginBalance" class="summaryBox_c2"> 
                <span>
                    <%= checkingBeginBalance %>
                </span>
            </div>
        </div>
        <div class="summaryBoxDetail_r1">
            <div class="summaryBox_c1">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Total Deposits</span>
            </div>
            <div id="summaryBoxDetail_depositTotal" class="summaryBox_c2"> 
                <span>
                    <%= checkingDepositTotal %>
                </span>
            </div>
        </div>
        <div class="summaryBoxDetail_r1">
            <div class="summaryBox_c1">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Total Withdrawals</span>
            </div>
            <div id="summaryBoxDetail_withdrawalTotal" class="summaryBox_c2"> 
                <span>
                    <%= checkingWithdrawTotal %>
                </span>
            </div>
        </div>
    </div>
    <div class="summaryBoxTotal">
        <div class="summaryBoxDetail_r1">        
            <div class="summaryBox_c1">
                <span>Total</span>
            </div>
            <div id="summaryBoxDetail_monthTotal" class="summaryBox_c2">
                <span>
                    <%= checkingBalance %>
                </span>
            </div>
        </div>
    </div>
    
</div>

</div> <!-- End wrapper -->
</body>
</html>
