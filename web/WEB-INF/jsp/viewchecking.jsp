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
        <jsp:forward page="login.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>
<jsp:useBean id="user" scope="session" class="edu.spcollege.titanbank.bll.User" />
<% // CheckingAccount extends BankAccount %>
<jsp:useBean id="checkingaccount" scope="session" class="edu.spcollege.titanbank.bll.CheckingAccount" />

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
    <span><jsp:getProperty name="user"
               property="firstName" />
    </span>
    <span><jsp:getProperty name="user"
               property="lastName" />
    </span>
    <span>&nbsp;&nbsp;Logged in at&nbsp <%= today %></span>
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
                    <jsp:getProperty name="checkingaccount"
                     property="beginBalanceFormatted" />
                </span>
            </div>
        </div>
        <div class="summaryBoxDetail_r1">
            <div class="summaryBox_c1">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Total Deposits</span>
            </div>
            <div id="summaryBoxDetail_depositTotal" class="summaryBox_c2"> 
                <span>
                    <jsp:getProperty name="checkingaccount"
                     property="depositTotalFormatted" />
                </span>
            </div>
        </div>
        <div class="summaryBoxDetail_r1">
            <div class="summaryBox_c1">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Total Withdrawals</span>
            </div>
            <div id="summaryBoxDetail_withdrawalTotal" class="summaryBox_c2"> 
                <span>
                    <jsp:getProperty name="checkingaccount"
                     property="withdrawalTotalFormatted" />
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
                    <jsp:getProperty name="checkingaccount"
                     property="balanceFormatted" />
                </span>
            </div>
        </div>
    </div>
    
</div>

</div> <!-- End wrapper -->
</body>
</html>
