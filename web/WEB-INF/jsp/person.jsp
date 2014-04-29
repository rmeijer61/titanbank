<%-- 
    Document   : customer
    Created on : Apr 18, 2014, 7:39:17 AM
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
<%@include file="initperson.jsp" %>

<%! Date today = new Date(); %>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Customer</title>
    <script type="text/javascript" src="js/stateCountry.js"></script>
</head>
<body class="contentBody">
<div class="contentWrapper">
<div class="content_2col_detail">
    <div>
        <span>Customer Id: <%= customerId %></span>
        <span>, &nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>Person Id: <%= personId %></span>
    </div>
    <form action="addcustomer" method="post">
        <!-- Personal -->
        <div class="groupBox">
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="prefixTitle">Prefix/Title: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <select id="prefixTitle" name="prefixTitle" value="<%= prefixTitle %>" >
                        <option><%= prefixTitle %></option>
                        <option value="Dr">Doctor</option>
                        <option value="M">M.</option>
                        <option value="Miss">Miss</option>
                        <option value="Mr">Mr.</option>
                        <option value="Mrs">Mrs.</option>
                        <option value="Ms">Ms.</option>
                    </select>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="lastName">Last Name: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="lastName" id="lastName" value="<%= lastName %>" required />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="firstName">First Name: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="firstName" id="firstName" value="<%= firstName %>" />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="middleName">Middle Name: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="middleName" id="middleName" value="<%= middleName %>" />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="birthDate">Birth Date:</label>
                </div>
                <div class="content_form_2col_r1_c2">
                    <input type="text" size="10" name="birthDate" id="birthDate" value="<%= birthDate %>" required />
                </div>
            </div>            
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">
                    <label class="content_form_label" for="gender">Gender:</label>
                </div>
                <div class="content_form_2col_r1_c2">    
                    <select required id="gender" name="gender" value="<%= gender %>">
                        <option><%= gender %></option>
                        <option value="M">M</option>
                        <option value="F">F</option>
                    </select>
                </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="suffix">Suffix: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="10" name="suffix" id="suffix" value="<%= suffix %>" />
	        </div>
            </div>              
        </div>
        <!-- Residence -->
        <div class="groupBox">
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="address1">Address1: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="address1" id="address1" value="<%= address1 %>" required />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="address2">Address2: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="address2" id="address2" value="<%= address2 %>"/>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="City">City: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="city" id="city" value="<%= city %>" required />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="country">Country: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <select required id="country" name="country" onchange="populateState()"> 
                        <option><%= country %></option>
                    </select>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="state">State: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <select id="state" name="state">
		        <option><%= state %></option>
                    </select>
		    <script type="text/javascript">initCountry(); </script>
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="postalCode">Postal Code: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="10" name="postalCode" id="postalCode" value="<%= postalCode %>"/>
	        </div>
            </div>
        </div>
        <!-- Contact -->
        <div class="groupBox">
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="emailAddress">Email Address: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="email" size="30" name="emailAddress" id="emailAddress" value="<%= emailAddress %>" required />
	        </div>
            </div>
            <div class="content_form_2col_r1_300">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="phone1">Primary phone: </label>
                </div>
                <div class="content_form_2col_r1_c2">
	            <input type="text" size="30" name="phone1" id="phone1" value="<%= phone1 %>" required />
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
                        <button type="submit">Add Customer</button>
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
