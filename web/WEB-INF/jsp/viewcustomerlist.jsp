<%-- 
    Document   : viewcustomerlist
    Created on : Apr 18, 2014, 5:18:09 PM
    Author     : rmeijer
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Customer List (For Testing)</title>
</head>
<body class="contentBody">
<div id="contentWrapper">
<h3>View Customers</h3>

<div class="groupBox">
    <form action="viewcustomer" method="post">
        <div class="content_form_2col_r1_300">
            <div class="content_form_2col_r1_c1">		
                <label class="content_form_label" for="customerSelect">Select a Customer:</label>
            </div>
            <div class="content_form_2col_r1_c2">
                <%
                List<PersonName> personList; // = new ArrayList<PersonName>();
                personList = (ArrayList) request.getAttribute("personList");
                out.println("<select id='customerSelect' name='customerSelect'>");
                out.println("<option value=''><div class='selectOptionLine'>Select</div></option>");
                for (PersonName temp : personList) {
                    out.println("<option value='" +temp.getCustomerId()+ "'>");
                    out.println("<div class='selectOptionLine'>");
                    out.println("<span>"+temp.getCustomerId()+"</span>");
                    out.println("<span>"+temp.getPersonId()+"</span>");
                    out.println("<span>"+temp.getFullName()+"</span>");
                    out.println("<span>"+temp.getBirthDate()+"</span>");
                    out.println("<span>"+temp.getGender()+"</span>");
                    out.println("</div>");
                    out.println("</option>");
                }
                out.println("</select>"); 
                %>
	    </div>
        </div>
        <!-- Submit -->
        <div class="content_form_2col_r1_300">
            <div class="content_form_2col_r1_c1">&nbsp;</div>
            <div class="content_form_2col_r1_c2">
                <div class="submitBox10">
                    
                    <input name="viewCustomer" value="Get Customer" type="submit" class="content_2col_submit"/>
                </div>
	    </div>
        </div>
        <div class="content_form_2col_r1_300">
            <div class="content_form_2col_r1_c1">&nbsp;</div>
            <div class="content_form_2col_r1_c2">
                <div id="loginMessage">
                    <% 
                        if (request.getAttribute("message") != null) {
                            out.println(request.getAttribute("message"));
                        } 
                    %>
                </div>
            </div>
        </div>
    </form>
    
    <div>
        <!-- Display customer -->    
    </div>

</div>
    
</div> <!-- End of wrapper -->
</body>
</html>
