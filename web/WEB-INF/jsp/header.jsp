<%-- 
    Document   : header
    Created on : Apr 11, 2014, 12:06:33 PM
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
        
	<li><a>Accounts</a>
            <ul class="level2">
	        <li class="navsubli"><a href="savings" target="main_content_iframe">Savings</a></li>
		<li class="navsubli"><a href="checking" target="main_content_iframe">Checking</a></li>
            </ul>
        </li>
        <li><a>Transfers</a>
            <ul class="level2">
		<li class="navsubli"><a href="transfer" target="main_content_iframe">Schedule Transfer</a></li>
                <li class="navsubli"><a href="transferlist" target="main_content_iframe">Transfer Activity</a></li>
	    </ul>
        </li>      
        <li><a>Manage Checking</a>
            <ul class="level2">
                <li class="navsubli"><a href="checkinfoservlet" target="main_content_iframe">Search Checks</a></li>
                <li class="navsubli"><a href="cancelcheckservlet" target="main_content_iframe">Stop Payment</a></li>
                <li class="navsubli"><a href="checkinfoservlet" target="main_content_iframe">Order Checks</a></li>
            </ul>    
        </li>
        <li><a>Personal Information</a>
            <ul class="level2">
		<li class="navsubli"><a href="editinfolaunchservlet" target="main_content_iframe">Change Personal Info</a></li>
            </ul>
        </li>
        <li><a>Password/Settings</a>
            <ul class="level2">
		<li class="navsubli"><a href="editpasswordlaunchservlet" target="main_content_iframe">Change Password</a></li>
            </ul>
        </li>
        <li><a style="border-right:none">Contact Us</a>
    </ul>
</div><!-- End of menubar -->

</div><!-- End of navContent -->
</div><!-- End of nav -->

</div><!-- End of header01_r2 -->
</div> <!-- End header01_r1 -->