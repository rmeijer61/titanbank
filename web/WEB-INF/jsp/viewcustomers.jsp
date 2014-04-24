<%-- 
    Document   : viewcustomers
    Created on : Apr 17, 2014, 6:36:55 PM
    Author     : rmeijer
--%>

<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="edu.spcollege.titanbank.bll.*, java.util.Date" 
        errorPage="errorPage.jsp" %>
<jsp:useBean id="qbean" scope="session" 
             class="edu.spcollege.titanbank.bll.DBQuery" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Titan Bank - Query</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>View Customers:</h3>
<%
    String sqlStatement = "select * from person";
    int columnCount = 0;
    QueryResult result = qbean.doQuery(sqlStatement);
    if (result != null) {
        Iterator it = result.columnNamesIterator();
        out.println("<table border=\"1\"><tbody>") ;
        out.println("<tr>") ;
        while (it.hasNext()) {
            columnCount++;
            out.println("<td>" +it.next() +"</td>") ;
        }
        out.println("</tr>") ;
        it = result.fieldValuesIterator();
        int columnNr = 0 ;
        while (it.hasNext()) {
            columnNr++ ;
            if (columnNr == 1) {
                out.println("<tr>"+"HEY");
            }
           out.println("<td>" +it.next() +"</td>") ;
           if (columnNr == columnCount) {
               out.println("</tr>") ;
               columnNr = 0 ;
           }
       }
      out.println("</tbody></table>") ;
    }
    else {
        out.println("<p>No rows found!</p>");
    }
%>

</html>
