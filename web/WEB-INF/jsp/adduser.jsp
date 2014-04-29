<%-- 
    Document   : adduser
    Created on : Apr 27, 2014, 3:04:14 PM
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<%@include file="inituser.jsp" %>

<%! Date today = new Date(); %>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - User</title>
</head>
<body class="contentBody">
<div class="contentWrapper">
<div class="content_2col_detail">
    <form action="adduser" method="post">
        <!-- Select a customer -->
        <div class="groupBox">
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
                        //out.println("<span>"+temp.getPersonId()+"</span>");
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
        </div>
        <!-- User Info -->
        <div class="groupBox">
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="userName">User Name: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="userName" id="userName" value="<%= userName %>" required />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="userType">User Type: </label>
                </div>
                <div class="content_form_2col_r1_c2">
                    <select id="userType" name="userType" required>
                        <option value="C">Customer</option>
                        <option value="E">Employee</option>
                    </select>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="password">Password: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="password" id="password" value="<%= password %>" required />
	        </div>
            </div>
        </div>
        <!-- Submit -->
        <div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">&nbsp;</div>
                <div class="content_form_2col_r1_c2">
                    <div id="message">
                    <% 
                        if (request.getAttribute("message") != null) {
                            out.println(request.getAttribute("message"));
                        } 
                    %>
                    </div> 
	        </div>
            </div>            
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">&nbsp;</div>
                <div class="content_form_2col_r1_c2">
                    <div class="submitBox10">
                        <button type="submit">Add User</button>
                        <button onclick="javascript:document.location.reload(true);">Reset</button>
                        <button onclick="index2"/>Exit</button>
                    </div>
	        </div>
            </div>
        </div>
    </form>
                   
</div> <!-- End of detail -->
</div> <!-- End of wrapper -->
</body>
</html>
