<%-- 
    Document   : editinfo
    Created on : Apr 24, 2014, 3:14:37 PM
    Author     : maxximilianseijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Personal Info</title>
        <link rel="stylesheet" type="text/css" href="editInfo.css">
    </head>
    <body>
        <h1>Titan Banking</h1>
        <h3>Edit Personal Info</h3>
        <form action="EditInfoServlet" method="post">
            <p><label>Prefix: <input type="text" name="prefixtitle" value="<%=request.getAttribute("prefixtitle")%>" /></label></p>
            <p><label>First Name: <input type="text" name="fisrtname" value="<%=request.getAttribute("firstname")%>" /></label></p>
            <p><label>Middle Name: <input type="text" name="middlename" value="<%=request.getAttribute("middlename")%>"/></label></p>
            <p><label>Last Name: <input type="text" name="lastname" value="<%=request.getAttribute("lastname")%>"/></label></p>
            <p><label>Suffix: <input type="text" name="suffix" value="<%=request.getAttribute("suffix")%>"/></label></p>
            <p><label>Address1: <input type="text" name="address1" value="<%=request.getAttribute("address1")%>"/></label></p>
            <p><label>Address2: <input type="text" name="address2" value="<%=request.getAttribute("address2")%>"/></label></p>
            <p><label>City: <input type="text" name="city" value="<%=request.getAttribute("city")%>"/></label></p>
            <p><label>State: <input type="text" name="state" value="<%=request.getAttribute("state")%>"/></label></p>
            <p><label>Postal Code: <input type="text" name="postalcode" value="<%=request.getAttribute("postalcode")%>"/></label></p>
            <p><label>Country: <input type="text" name="country" value="<%=request.getAttribute("country")%>"/></label></p>
            <p><label>Email Address: <input type="text" name="emailaddress" value="<%=request.getAttribute("emailaddress")%>"/></label></p>
            <p><label>Phone: <input type="text" name="phone" value="<%=request.getAttribute("phone")%>"/></label></p>
            <p><label><input type="submit" value="Save" ID="saveButton" /></label></p>
        </form>
    </body>
</html>
