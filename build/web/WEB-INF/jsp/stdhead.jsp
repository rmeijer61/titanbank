<%-- 
    Document   : stdhead
    Created on : Apr 11, 2014, 7:52:47 AM
    Author     : rmeijer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<head>
<title>JSP - Rick Meijer - Titan Bank</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta name="author" content="Richard (Rick) Meijer" />

<!-- Main CSS -->
<link href="css/main.css" rel="stylesheet" type="text/css" />

<!-- jQuery -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<!--link href="css/jquery.ui.accordion.css" rel="stylesheet" type="text/css" /-->
<script type="text/javascript" src="js/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/jquery.ui.position.js"></script>
<script type="text/javascript" src="js/jquery.ui.tooltip.js"></script>
<link rel="stylesheet" href="css/jquery.ui.all.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<!-- Navigation menubar -->
<link rel="stylesheet" type="text/css" href="css/navmenubar-h.css" />
<script type="text/javascript" src="js/navmenubar-h.js"></script>
<script type="text/javascript" src="js/utilities.js"></script>
<script type="text/javascript">
navmenubar.init( {
	//rsm - This is the setting object
    //Note: A javascript object is delimited by curly braces. Inside the braces the object's properties 
	//      are defined as name and value pairs (name : value). The properties are separated by commas:	
	mainmenuid: "navmenubar1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'navmenubar', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
} )
</script>

</head>
