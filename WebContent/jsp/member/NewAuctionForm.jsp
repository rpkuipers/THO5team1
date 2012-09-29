<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
         <title>Create a new account</title>
         <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
	    <h4>Create a new auction</h4> 	
	    
	    <hr />
	    
		<s:form action="CreateAuction">
    	  <s:textfield name="title" label="Title"/>
    	  <s:textfield name="productname" label="Product name"/>
    	  <s:textfield name="description" label="Description"/>
    	  <s:label label="please use the dd-mm-yyyy format"/>
    	  <s:textfield name="startdate" label="Start date"/>
    	  <s:textfield name="enddate" label="End date"/>
    	  <s:textfield name="startprice" label="Start price"/>
    	  <s:textfield name="buyoutprice" label="Buy out price"/>
    	  
    	  
    	  <s:submit value="Create"/>
		</s:form>
			
	    <hr />
	    
		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body> 
</html>