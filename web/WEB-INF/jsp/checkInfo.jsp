<%-- 
    Document   : checkInfo
    Created on : May 3, 2014, 7:10:04 PM
    Author     : Josh
--%>
<%
  String checkNo = (String)request.getAttribute("checkNo");
  String amount = (String)request.getAttribute("amount");
  String status = (String)request.getAttribute("status");
  String checkID = (String)request.getAttribute("checkID");
  String custID = (String)request.getAttribute("custID");
  String cancel ="";
  if((Boolean)request.getAttribute("invalidStatus"))
  {
      cancel = "You can only stop payment on unpaid checks";
  }  
  
  
 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Titan Bank - Manage Checks</title>
    </head>
    <body>
        <form action="/CancelCheck" method = "post">
            <table>
                <tr>
                    <td>
                        Check Number:
                    </td>
                    <td>
                        <%=checkNo %>
                    </td>
                </tr>
                <tr>
                    <td>Check Amount:</td>
                    <td><%= amount%>
                    </td>
                </tr>
                <tr>
                    <td>Check Status:</td>
                    <td><%=status%></td>
                </tr>
                <tr>
                    <td colspan = "2" style ="text-align: center;" ><input type="submit" value="Stop Payment" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="color: red;"><%=cancel %></td>
                    
                </tr>  
                <tr>
                    <td>
                        <input type="hidden" name = "checkID" value = <%= checkID%>
                        <input type="hidden" name = "checkNo" value = <%= checkNo%>
                        <input type="hidden" name = "custID" value = <%= custID%>
                    </td>                    
                </tr>                 
            </table>
        </form>
    </body>
</html>
