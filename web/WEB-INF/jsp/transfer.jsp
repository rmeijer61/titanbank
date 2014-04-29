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
<%@include file="inittransfer.jsp" %>
<%! Date today = new Date(); %>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />    
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Schedule Transfer</title>
</head>
<body class="contentBody">
<div id="contentWrapper">
 
<div class="content_2col_heading">
    <h3>Schedule Transfer</h3>
</div>  
<div id="transferBoxes">
<form action="transfer" method="post">
<div class="transferBox">
    <div class="transferBoxTitle">
        <span>Transfer From</span>
    </div>
    <div class="transferBoxDetail">
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">
                <label class="content_form_label" for="transferFromAccountNum">Account: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <!--select id="transferFromAccountNum" name="transferFromAccountNum" required>
                    <option value="">Please select</option>
                    <option value="101">Savings</option>
                    <option value="201">Checking</option>
                </select-->
                <input type="text" size="10" name="fromAccountNum" id="fromAccountNum" />
            </div>
        </div>
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="amount">Amount: </label>
            </div>
            <div class="content_form_2col_r1_c2" >
                <input type="text" size="10" name="amount" id="amount" />
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
                <label class="content_form_label" for="transferToAccountNum">Account: </label>
            </div>
            <div class="content_form_2col_r1_c2">
                <!--select id="transferToAccountNum" name="transferToAccountNum" required>
                    <option value="">Please select</option>
                    <option value="101">Savings</option>
                    <option value="201">Checking</option>
                </select-->
                <input type="text" size="10" name="toAccountNum" id="toAccountNum" />
            </div>
        </div>
    </div>
</div>
    
<div class="transferBox">
    <div class="transferBoxTitle">
        <span>Transfer Date</span>
    </div>
    <div class="transferBoxDetail">
        <div>
            <input type="checkbox" name="transferImmediately" value="true">Transfer Immediately 
        </div>
        <br />
        <div class="content_form_2col_r1">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="scheduleDate">Date: </label>
            </div>
            <div class="content_form_2col_r1_c2">
                <input type="text" size="10" name="scheduleDate" id="scheduleDate">
            </div>
        </div>
    </div>
</div>

<!-- Message area -->
<div class="content_form_message">
    <% 
        if (request.getAttribute("message") != null) {
            out.println(request.getAttribute("message"));
        } 
    %>
</div> 

<div>
<input name="transfer" value="Transfer" type="submit" class="content_2col_submit">
</div>

</form>       
</div>


</div>
</body>
</html>
