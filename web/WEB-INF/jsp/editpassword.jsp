<%-- 
    Document   : editpassword
    Created on : May 4, 2014, 1:40:07 PM
    Author     : maxximilianseijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link rel="stylesheet" type="text/css" href="editInfo.css">
    </head>
    <body>
        <h1>Titan Banking</h1>
        <h3>Change Password</h3>
        <form action="editpasswordservlet" method="post">
            <p><label>Old Password: <input type="password" name="oldpassword" value="" /></label></p>
            <p><label>New Password: <input type="password" name="newpassword" value="" /></label></p>
            <p><label>Confirm New: <input type="password" name="newpasswordconfirm" value=""/></label></p>
            <p><label><input type="submit" value="Save" ID="saveButton" /></label></p>
        </form>
    </body>
</html>
