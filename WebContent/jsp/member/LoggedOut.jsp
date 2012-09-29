<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
        <title>Logout</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
	    <h4>Logout.</h4> 	
	    
	    <hr />
	    
		Goodbye <s:property value="user.username"/>.<br>
		You have successfully logged out. 
		
	    <hr />
	    
	    <a href=" <s:url value="/"/> ">Start Menu</a>
	</body> 
</html>