<%--
    Document   : accountsummary
    Created on : Apr 12, 2014, 3:06:39 PM
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
 
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/stdhead.jsp" />   

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Summary of Accounts</title>
</head>
<body class="contentBody">

<div class="contentWrapper">
<div class="content_2col_heading">
    <h3>About Your Accounts</h3>
</div>   

<div class="summaryBox">
    <div class="summaryBoxTitle">
        <span>Savings Account</span>
    </div>
    <div>
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. 
        </div>
</div>

<div class="summaryBox">
    <div class="summaryBoxTitle">
        <span>Checking Account</span>
    </div>
    <div>
        Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. 
    </div>
    
</div>    
    
</div> <!-- End wrapper -->
</body>
</html>
