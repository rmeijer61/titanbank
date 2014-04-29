<%-- 
    Document   : transferlist
    Created on : Apr 12, 2014, 9:45:51 AM
    Author     : rmeijer
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" 
        import="edu.spcollege.titanbank.bll.*, java.util.Date, java.util.ArrayList" 
        errorPage="errorPage.jsp" %>
<% // Verify that the user is logged in
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || loggedIn.booleanValue() == false) {
%>
        <jsp:forward page="welcome.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Transfer Activity</title>
</head>
<body class="contentBody">

<div class="contentWrapper">
<div class="content_2col_heading">
    <h3>Transfer Activity</h3>
</div>

<% 
    String selectedTransferStatus = (String) request.getAttribute("selectedTransferStatus");
%>
<div class="transferActivitySelectBox">
    <form action="transferlist" method="post">
        <div class="transferStatusSelect">
            <label class="transferStatusSelect" for="transferStatus">Select the transfer status:</label>
            <select id="transferStatus" name="transferStatus">
                <option value="">Please select</option>
                <option value="P">Pending</option>
                <option value="C">Completed</option>
                <option value="A">All</option>
            </select>
        </div>
        <input name="submit" value="Get Transfers" type="submit" class="transferStatusSubmit"/>
    </form>
</div>
<br/>
<div>
 
</div>

<div class="transferActivityBox">
    <div class="transferActivityBoxTitle">
        <span>Current Transfer Activity</span>
    </div>
    <div class="transferActivityBoxHeading">
        <div class="transferActivityBox_scheduleDate">
            <span>Date</span>
        </div>
        <div class="transferActivityBox_transferStatus">
            <span>Status</span>
        </div>
        <div class="transferActivityBox_fromAccountNum">
            <span>From Account</span>
        </div>
        <div class="transferActivityBox_toAccountNum">
            <span>To Account</span>
        </div>
        <div class="transferActivityBox_amount">
            <span>Amount</span>
        </div>
    </div>    
    <div class="transferActivityBoxDetail">
            <%
                System.out.println("transferlist.jsp: Get transfer list...");
                ArrayList<Transfer> transactions = (ArrayList) request.getAttribute("transferList");
                for (int i=0; i < transactions.size(); i++) {
                    out.println(
                          "<div class='transferActivityBoxDetail_r1'>"
                        // Column 1
                        +  "<div class='transferActivityBox_scheduleDate'>"
                        +   "<span>"+transactions.get(i).getScheduleDateFormatted()+"</span>"
                        + "</div>"
                        // Column 2
                        + "<div class='transferActivityBox_transferStatus'>" +
                           "<span>"+transactions.get(i).getTransferStatus()+"</span>"
                        + "</div>"                                
                        // Column 3
                        + "<div class='transferActivityBox_fromAccountNum'>"
                        +   "<span>"+transactions.get(i).getFromAccountNum()+"</span>"
                        + "</div>"        
                        // Column 4
                        + "<div class='transferActivityBox_toAccountNum'>"
                        +   "<span>"+transactions.get(i).getToAccountNum()+"</span>"
                        + "</div>"
                        // Column 5
                        + "<div class='transferActivityBox_amount'>"
                        +    transactions.get(i).getAmountFormatted()
                        + "</div>"
                        + "</div>"
                        + "<br />"
                    );
                }
            %>
    </div>    
</div>

</div> <!-- End wrapper -->
</body>
</html>
