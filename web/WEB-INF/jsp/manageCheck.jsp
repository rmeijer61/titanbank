<%-- 
    Document   : manageCheck_Cust
    Created on : May 3, 2014, 3:55:30 PM
    Author     : Josh
--%>
<!DOCTYPE html>
<%
  String checkCanceled = "";
  
  if((Boolean)request.getAttribute("checkCanceled"))
  {
      checkCanceled = "Your request to stop payment on " +"" + "has been successful"; 
  }
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Titan Bank - Manage Checks</title>
        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Manage Checks</h1>
        <form action="/CheckInfo" method = "post">
            <table>
                <tr>
                    <td>
                        Check Number:
                    </td>
                    <td>
                        <input type="text" name="tbCheck" />
                    </td>
                </tr>
                <tr>
                    <td colspan = "2" style ="text-align: center;" ><input type="submit" value="Search" /></td>
                </tr>
                <tr>
                    <td><input type ="hidden" value="customer" name ="userType" /></td>
                </tr>               
            </table>
        </form>
        <form>
            <input type="submit" value ="Order Checks"/>
        </form>
        
        
    </body>
</html>
