<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
	    <h4>Login.</h4> 	
	    
	    <hr />
	   
		<s:form action="Login">
    	  <s:textfield name="username" label="Name"/>
    	  <s:password name="password" label="Password"/>
    	  <s:submit value="log in"/>
		</s:form>
			
	    <hr />
	    
	    <a href="<s:url value="/"/>">Terug naar het startmenu</a>
	</body> 
</html>