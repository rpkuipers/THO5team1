<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	
	<head>
         <title>Create a new account</title>
         <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
	    <h4>Create a new account</h4> 	
	    
	    <hr />
	    
		<s:form action="CreateAccount">
		  <s:fielderror></s:fielderror>	
    	  <s:textfield name="username" label="Username"/>
    	  <s:password name="password" label="Password"/>
    	  <s:password name="repeatpassword" label="Repeat Password"/>
    	  <hr />
    	  <s:textfield name="name" label="Name"/>
    	  <s:textfield name="address" label="Addresss"/>
    	  <s:textfield name="email" label="E-mail"/>
    	  <s:textfield name="repeatemail" label="Repeat E-mail"/>
    	  <s:textfield name="phonenumber" label="Phonenumber"/>
    	  
    	  <s:submit value="Create"/>
		</s:form>
			
	    <hr />
	    
	    <a href=" <s:url value="/"/> ">Back to the start menu</a>
	</body> 
</html>