<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
        <title>Product created</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
    </head>

	<body>
	    <h4>Product created.</h4>
	     	
	    <hr />
	    
		Your product <s:property value="productname"/> has been added to our database!<br>
		
		
	    <hr />
	    
	    <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	    
	</body> 
</html>