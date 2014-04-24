<!doctype html>
<%@ page import="java.util.Date, java.io.* ,javax.naming.*" 
         errorPage="/WEB-INF/jsp/stdhead.jsp" %>
<%! Date today = new Date(); %>
<html>
<jsp:include page="/WEB-INF/jsp/stdhead.jsp" />

<body>
<div id="wrapper">
<!-- *** Header section *** -->
    <jsp:include page="/WEB-INF/jsp/loginheader.jsp" />

<!-- *** MAIN SECTION *** -->
<div id="main">

<div id="main_content">
    <jsp:include page="/WEB-INF/jsp/login.jsp" />
</div>

</div><!-- End of main -->

<!-- *** Footer section *** -->
<jsp:include page="/WEB-INF/jsp/stdfoot.jsp" />

</div> <!-- End of wrapper -->
</body>
</html>