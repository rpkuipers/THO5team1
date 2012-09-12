<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
        <title>Menu voor leden</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
		<h4>Ingelogd: <s:property value="user.username"/>.</h4> 	
		
        <hr />   
        
        <ul>
            <li><a href="<s:url action='ProductList' namespace="/member"/>">Alle boeken</a></li>	
            <li><a href="<s:url action='ProductInfoForm' namespace="/member"/>">Boekinformatie (nyi)</a></li>
            <li><a href="<s:url action='ProductReservationForm' namespace="/member"/>">Reserveer boek (nyi)</a></li>               	
            <li><a href="<s:url action='CancelReservationForm' namespace="/member"/>">Annuleer reservering (nyi)</a></li>               	
            <li><a href="<s:url action='MyProductList' namespace="/member"/>">Alle gereserveerde en geleende boeken (nyi)</a></li>	
            <li><a href="<s:url action='ChangePasswordForm' namespace="/member"/>">Wijzig wachtwoord (nyi)</a></li>
            <li><a href="<s:url action='Logout' namespace="/member"/>">Log uit</a></li>	
        </ul>
        
	</body>
</html>
