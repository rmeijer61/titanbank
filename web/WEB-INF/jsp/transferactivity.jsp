<%-- 
    Document   : transferactivity
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
        <jsp:forward page="login.jsp" />
<%
    }
%>
<%! Date today = new Date(); %>
<jsp:useBean id="user" scope="session" class="edu.spcollege.titanbank.bll.User" />
<jsp:useBean id="transferrequest" scope="session" class="edu.spcollege.titanbank.bll.TransferRequest" />
<jsp:useBean id="transferservice" scope="session" class="edu.spcollege.titanbank.bll.TransferService" />

<!DOCTYPE html>
<html>
<jsp:include page="stdhead.jsp" />    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titan Bank - Transfer Activity</title>
</head>
<body class="contentBody">
<div>
    <span><jsp:getProperty name="user"
               property="firstName" />
    </span>
    <span><jsp:getProperty name="user"
               property="lastName" />
    </span>
    <span>&nbsp;&nbsp;Logged in at&nbsp <%= today %></span>
</div>
<div class="contentWrapper">
<div class="content_2col_heading">
    <h3>Transfer Activity</h3>
</div>
    
<div class="transferActivitySelectBox">
    <form action="transferservice" method="post">
        <div class="transferStatusSelect">
            <label class="transferActivitySelect" for="transferStatus">Select the transfer status:</label>
            <select id="transferStatus" name="transferStatus">
                <option value="PENDING" >Pending</option>
                <option value="COMPLETED">Completed</option>
                <option value="ALL">All</option>
            </select>
        </div>
        <input name="submit" value="Submit Request" type="submit" class="transferStatusSubmit"/>
    </form>
</div>
<br/>

<div class="transferActivityBox">
    <div class="transferActivityBoxTitle">
        <span>Current Transfer Activity</span>
    </div>
    <div class="transferActivityBoxHeading">
        <div class="transferActivityBox_c1">
            <span>Date</span>
        </div>
        <div class="transferActivityBox_c2">
            <span>From Account</span>
        </div>
        <div class="transferActivityBox_c3">
            <span>To Account</span>
        </div>
        <div class="transferActivityBox_c4">
            <span>Amount</span>
        </div>
        <div class="transferActivityBox_c5">
            <span>Status</span>
        </div>
        <div class="transferActivityBox_c6">
            <span>Enter Date</span>
        </div>
    </div>    
    <div class="transferActivityBoxDetail">
        <div class="transferActivityBoxDetail_r1">
            
            <!-- Format Example-->
            <!--div class="transferActivityBox_c1">
                <span>01-01-2014</span>
            </div>
            <div class="transferActivityBox_c2">
                <span>Account Name</span>
            </div>
            <div class="transferActivityBox_c3">
                <span>Account Name</span>
            </div>
            <div class="transferActivityBox_c4">
                <span>$0.00</span>
            </div>
            <div class="transferActivityBox_c5">
                <span>Pending</span>
            </div>
            <div class="transferActivityBox_c6">
                <span>01-01-2014</span>
            </div-->
            
            <%
                String transferStatus = request.getParameter("transferStatus");
                ArrayList<TransferRequest> transactions = (ArrayList) transferservice.getTransactions(transferStatus);
                for (int i=0; i < transactions.size(); i++) {
                    out.println(
                        // Column 1
                        "div class='transferActivityBox_c1'>" +
                           "<span>"+transactions.get(i).getTransferDateString()+"</span>" +
                        "</div>" + 
                        // Column 2
                        "div class='transferActivityBox_c2'>" +
                           "<span>"+transactions.get(i).getSourceType()+"</span>" +
                        "</div>" +        
                        // Column 3
                        "div class='transferActivityBox_c3'>" +
                           "<span>"+transactions.get(i).getDestinationType()+"</span>" +
                        "</div>" +
                        // Column 4
                        "div class='transferActivityBox_c4'>" +
                           "<span>"+transactions.get(i).getAmountString()+"</span>" +
                        "</div>" +
                        // Column 5
                        "div class='transferActivityBox_c5'>" +
                           "<span>"+transactions.get(i).getTransferStatus()+"</span>" +
                        "</div>" +
                        // Column 6
                        "div class='transferActivityBox_c6'>" +
                           "<span>"+transactions.get(i).getTransferEnterDateString()+"</span>" +
                        "</div>"       
                    );
                }
            %>
        </div>
    </div>    
</div>

</div> <!-- End wrapper -->
</body>
</html>
