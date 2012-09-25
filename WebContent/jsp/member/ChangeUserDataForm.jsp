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
		
		 <hr />

	<s:form action="ChangeUserData">
	<s:fielderror></s:fielderror>
	    <table>
		    <tr class="thcolor">
			    <th>Name</th> <td><s:property value="user.name" /><td>
			    <s:textfield name="name" label="New Name"/>
			    <th>Adress</th><td><s:property value="user.address" />
			    <s:textfield name="address" label="New Address"/>
			    <th>Email</th><td><s:property value="user.email" />
			    <s:textfield name="email" label="New Email"/>
			    <th>Phonenumber</th><td><s:property value="user.phoneNumber" />
			   	<s:textfield name="phoneNumber" label="New PhoneNumber"/>
			   	<th>Change Password</th><td><s:hidden />
			   	<s:password name="newPassword" label="New Password"/>
			   	<s:password name="newPasswordRepeat" label="Repeat New Password"/>
			    
		    </tr>
	    </table>
	    
	    <hr />
	    <s:textfield name="username" label="Username*"/></br>
    	<s:password name="password" label="Password*" tooltip="Password before change."/>
	    <s:submit value="Submit"/>
	
    	</s:form>
  		
	    <hr /> 
	    <p>*Required fields.</p>
		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body>
</html>