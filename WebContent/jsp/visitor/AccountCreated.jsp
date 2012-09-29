<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
        <title>Account created</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
    </head>

	<body>
	    <h4>Account created.</h4>
	     	
	    <hr />
	    
		Welcome <s:property value="username"/>!<br>
		Your account has been created.
		
	    <hr />
	    
	    <a href=" <s:url value="/"/> ">Back to the start menu.</a><br/>
	    <a href="<s:url action='LoginForm' namespace="/visitor"/>">Login</a>
	</body> 
</html>