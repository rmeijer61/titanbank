<%-- 
    Document   : scheduletransfer
    Created on : Apr 11, 2014, 7:02:41 PM
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
    String savingsBalance = "";
    String checkingBalance = "";
    savingsBalance = (String) request.getAttribute("savingsBalance");
    checkingBalance = (String) request.getAttribute("checkingBalance");
%>
<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Schedule Transfer</title>
</head>
<body class="contentBody">
<div id="contentWrapper">
<div>
    <span><%= firstName + " " + lastName %>&nbsp;&nbsp;Logged in at&nbsp <%= today %></span>
</div>    
<div class="content_2col_heading">
    <h3>Schedule Transfer</h3>
</div>   


<div id="transferBoxes">

<form action="updatetransfer" method=post">
    
<div class="transferBox">
    <div class="transferBoxTitle">
        <span>Transfer From</span>
    </div>
    <div class="transferBoxDetail">
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">
                &nbsp;
            </div>
            <div class="content_form_2col_r1_c2" >
                <div id="transferAvailableBalanceBox">
                    <span>
                        Available balance<br />
                        Savings:&nbsp; <%= savingsBalance %><br />
                        Checking:&nbsp; <%= checkingBalance %>
                    </span>
                </div>
            </div>
            <div class="content_form_2col_r1_c1">
                <label class="content_form_label" for="transferFromAccount">Account: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <select id="transferFromAccountType" name="transferFromAccountType">
                    <option value="savings">Savings</option>
                    <option value="checking">Checking</option>
                </select>                
            </div>
        </div>
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="amount">Amount: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <input type="number" size="10" name="transferAmount" id="transferAmount" />
            </div>
        </div>
    </div>
</div>

<div class="transferBox">
    <div class="transferBoxTitle">
        <span>Transfer To</span>
    </div>
    <div class="transferBoxDetail">
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="transferToAccount">Account: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <select id="transferToAccountType" name="transferToAccountType">
                    <option value="savings">Savings</option>
                    <option value="checking">Checking</option>
                </select>    
            </div>
        </div>
    </div>
</div>

</div> <!-- End transferBoxes --> 

<div class="transferBox">
    <div class="transferBoxTitle">
        <span>Transfer Date</span>
    </div>
    <div class="transferBoxDetail">
        <div>
            <input type="checkbox" name="transferimmediately" value="transferimmediately">Transfer Immediately 
        </div>
        <br />
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="userid">Date: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <input type="text" size="10" name="transferDate" id="datepicker" />
            </div>
        </div>
    </div>
</div>
<input name="transfer" value="Transfer" type="submit" class="content_2col_submit"/>

</form>
                   
</div> <!-- End wrapper -->
</body>
</html>
