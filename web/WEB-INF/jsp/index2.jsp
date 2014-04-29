<%-- 
    Document   : index2
    Created on : Apr 17, 2014, 3:25:08 PM
    Author     : rmeijer
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"
         import="java.util.Date, java.io.* ,javax.naming.*, 
                 edu.spcollege.titanbank.bll.*" 
%>

<% // Verify that the user is logged in
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || loggedIn.booleanValue() == false) {
%>
        <jsp:forward page="welcome.jsp" />
<%
    }
%>
<%@include file="initlogininfo.jsp" %> 
<%! Date today = new Date(); %>

<!doctype html>
<html>
<jsp:include page="stdhead.jsp" />

<body>
<div id="wrapper">
<!-- *** Header section *** -->
<jsp:include page="header2.jsp" />

<!-- *** MAIN SECTION *** -->
<div id="main">
<div>
    <span><%= firstName %>&nbsp;</span>
    <span><%= lastName %>&nbsp;</span>
</div>
<div id="main_content">
    <iframe id="main_content_iframe" name="main_content_iframe" src="">
    </iframe> 
</div>

</div><!-- End of main -->

<!-- *** Footer section *** -->
<jsp:include page="stdfoot.jsp" />

</div> <!-- End of wrapper -->
</body>
</html>