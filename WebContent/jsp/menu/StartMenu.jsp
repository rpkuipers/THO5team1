<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
        <title>BuyBuy: Menu</title>
        <link rel="stylesheet" type="text/css" href="css/bieb.css" />
	</head>

	<body>
		<h4>BuyBuy.com</h4> 
			
        <hr />
        
        <ul>
            <li><a href="<s:url action='CreateAccountForm' namespace="/visitor"/>">Create an Account</a></li>
            <li><a href="<s:url action='LoginForm' namespace="/visitor"/>">Login</a></li>
        </ul>
        
	</body>
</html>
