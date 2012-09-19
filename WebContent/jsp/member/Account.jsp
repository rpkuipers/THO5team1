<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/bieb.css" />
<title>Account</title>
</head>
	<body>
		<h4><s:property value="user.username"/>'s Account</h4>
		
			<p>Name: <s:property value="user.name" /></p>
			<p>Address: <s:property value="user.address" /></p>
			<p>E-mail: <s:property value="user.email" /></p>
			<p>Phonenumber: <s:property value="user.phoneNumber" /></p>
		
		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body>
</html>