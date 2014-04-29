<%-- 
    Document   : viewaccount
    Created on : Apr 28, 2014, 11:52:29 AM
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
<%@include file="initaccount.jsp" %>

<%! Date today = new Date(); %>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - View Account</title>
</head>
<body class="contentBody">
<div class="contentWrapper">
<div class="content_2col_detail">
        <!-- Account Info -->
        <div class="groupBox">
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="accountType">Account Type: </label>
                </div>
                <div class="content_form_2col_r1_c2">
                    <span id="accountType"><%= accountType %></span>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="balance">Balance: </label>
                </div>
                <div class="content_form_2col_r1_c2">
                    <span id="balance"><%= Double.toString(balance) %></span>
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
        <!-- Submit -->
        <div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">&nbsp;</div>
                <div class="content_form_2col_r1_c2">
                    <div class="submitBox10">
                        <button onclick="window.close()"/>Exit</button>
                    </div>
	        </div>
            </div>
        </div>
                   
</div> <!-- End of detail -->
</div> <!-- End of wrapper -->
</body>
</html>
