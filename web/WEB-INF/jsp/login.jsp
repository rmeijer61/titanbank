<%-- 
    Document   : login
    Created on : Apr 11, 2014, 6:37:00 AM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" 
        import="edu.spcollege.titanbank.bll.*, java.util.Date" 
        errorPage="errorPage.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Titan Bank - Login</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body class="contentBody">
<div class="contentWrapper">

<div class="loginCol1">
<div class="loginBoxOutline">
<div class="loginBox">

<div class="content_2col_heading">
    <h3>Login</h3>
</div>

<span>The user id and password hard-coded into the into classes are "cop2806" and "password" respectively.</span>
<br /><br />

<div class="content_2col_detail"> 
    <form action="login" method="post">
        <div>
            <div class="content_form_2col_r1">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="userid">Userid: </label>
                </div>
                <div class="content_form_2col_r1_c2" >
	            <input type="text" size="30" name="userid" id="userid" />
	        </div>
            </div>
            <div class="content_form_2col_r1">
                <div class="content_form_2col_r1_c1">		
                    <label class="content_form_label" for="password">Password: </label>
                </div>
                <div class="content_form_2col_r1_c2" >
	            <input type="text" size="30" name="password" id="password" />
	        </div>
            </div>
            <div class="content_form_2col_r1">
                <div class="content_form_2col_r1_c1">&nbsp</div>
                <div class="content_form_2col_r1_c2" >
	            <input name="login" value="Login" type="submit" class="content_2col_submit"/>
	        </div>
            </div>
            <div class="content_form_2col_r1">
                <div class="content_form_2col_r1_c1">&nbsp</div>
                <div class="content_form_2col_r1_c2" >
                    <div id="loginMessage">
                        <% 
                            if (request.getAttribute("errorMessage") != null) {
                                out.println(request.getAttribute("errorMessage"));
                            } 
                        %>
	            </div>
                </div>
            </div>
        </div>
        

    </form>

</div> <!-- End of detail -->
     
<div class="loginLinkBox">
    <hr />
    <div>
        <span>Forgot your User ID or Password?</span>
    </div>
    <hr />
    <div>
        <span>Register to View Your Account Online</span>
    </div>
</div>

</div> <!-- End of loginBox -->
</div> <!-- End of outline -->
<br/>

<!-- Login Box 2 -->
<div class="loginBox2Outline">
<div class="loginBox2">
    <div class="loginBox2LinkBox">
        <div>
            <span>Need Help With Your Account?</span>
        </div>
        <br />
        <div>
            <span>Interested in All Titan Bank Can Do for You?</span>
        </div>
        <br />
        <div>
            <span>Want to Take a Tour?</span>
        </div>
</div>
</div> <!-- End loginBox2 -->
</div> <!-- End loginBox2Outline-->

</div> <!-- End of loginCol1 -->

<div class="loginCol2">
<!-- Login Box 2 -->
<div class="loginBox3Outline">
<div class="loginBox3">
    <div class="loginBox3LinkBox">
        <div>
            <span><strong>Help with logging in</strong></span>
        </div>
        <br />
        <div>
            <span>How do I log in to the Titan Bank website?</span>
        </div>
        <br />
        <div>
            <span>What do I do if I forget my User ID?</span>
        </div>
        <br />
        <div>
            <span>What if my Password is not working?</span>
        </div>
        <br />
        <div>
            <span>Need help logging in?</span>
        </div>
    </div>
</div> <!-- End loginBox3 -->
</div> <!-- End loginBox3Outline-->

<div class="loginBox4">
    <div>
        <!--img src="images/greenandbluegraphs.jpg" alt="graphs" /-->
        <div id="loginBox4_image" class="loginBox_image">
            <div id="loginBox4_text">
                <span>Where you can find opportunities in the year ahead - and beyond</span>
            </div>
        </div> 
    </div>
</div> <!-- End loginBox4 -->
</div> <!-- End loginCol2 -->

</div> <!-- End of contentWrapper-->
</body>
</html>
