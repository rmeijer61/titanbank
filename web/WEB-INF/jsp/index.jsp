<!doctype html>
<%@ page import="java.util.Date, java.io.* ,javax.naming.*" %>
<% // Verify that the user is logged in
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || loggedIn.booleanValue() == false) {
%>
        <jsp:forward page="login.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>
<html>
<jsp:include page="stdhead.jsp" />

<body>
<div id="wrapper">
<!-- *** Header section *** -->
<jsp:include page="header.jsp" />

<!-- *** MAIN SECTION *** -->
<div id="main">

<div id="main_content">
    <script type="text/javascript">
        document.getElementById('main_content_iframe').setAttribute('src','/WEB-INF/jsp/accountsummary.jsp');
        document.getElementById('main_content_iframe').contentDocument.location.reload(true);
    </script>
    <!--script type="text/javascript">
        var iframe = document.getElementById('main_content_iframe');
        iframe.src='';
        document.getElementById('main_content_iframe').contentDocument.location.reload(true);
    </script-->
    <iframe id="main_content_iframe" name="main_content_iframe">
    </iframe>
</div>

</div><!-- End of main -->

<!-- *** Footer section *** -->
<jsp:include page="stdfoot.jsp" />

</div> <!-- End of wrapper -->
</body>
</html>