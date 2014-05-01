<%-- 
    Document   : header2
    Created on : Apr 17, 2014, 3:50:15 PM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<div id="header01">
    
<div id="header01_r1">

<div id="header01_r1_c1">
    <div id="header01_r1_c1_r1">
        Titan Bank
    </div>
    <div id="header01_r1_c1_r2">
        <div>Your Money is Safe with Us</div>
    </div>
</div>

<div id="header01_r1_c2">
    <div id="header01_r1_c2_div">
        <div>
	    <span id="header01_r1_c2_div_author"></span>
	    <br />
	</div>
    </div>
</div>

<div id="header01_r1_c3">
    <div>
        <span id="header01_r1_c3_name"><strong>Rick Meijer</strong></span>
	<a id="header01_logout" href="logout">Logout</a>
    </div>
</div>
</div> <!-- End header01_r1 -->

<div id="header01_r2">
<!-- *** NAV SECTION *** -->
<div id="nav">
<div id="navContent">

<div id="navmenubar1" class="navmenubar">
    <ul class="level1">
        <li><a href="accountsummary" target="main_content_iframe">Home</a></li>
	<li><a>Manage Customer Accounts</a>
            <ul class="level2">
                <li class="navsubli"><a href="viewcustomerlist" target="main_content_iframe">View Customer List</a></li>
                <li class="navsubli"><a href="viewcustomer" target="main_content_iframe">View Customer</a></li>
	        <li class="navsubli"><a href="addcustomer" target="main_content_iframe">Add Customer</a></li>
		<li class="navsubli"><a href="viewcustomerlist" target="main_content_iframe">Cancel Customer</a></li>
                <li class="navsubli"><a href="account" target="main_content_iframe">Add Account</a></li>
                <li class="navsubli"><a href="adduser" target="main_content_iframe">Add User</a></li>
            </ul>
        </li>
        <li><a>Manage Customer Checks</a>
            <ul class="level2">
                <li class="navsubli"><a href="" target="main_content_iframe">Search Checks</a></li>
                <li class="navsubli"><a href="" target="main_content_iframe">Stop Payment</a></li>
            </ul>    
        </li>
        <li><a style="border-right:none">Contacts</a>
    </ul>
</div><!-- End of menubar -->

</div><!-- End of navContent -->
</div><!-- End of nav -->

</div><!-- End of header01_r2 -->
</div> <!-- End header01_r1 -->