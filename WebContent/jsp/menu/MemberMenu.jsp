<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
        <title>BuyBuy: Member Menu</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
		<h4>BuyBuy.com</h4> 
			
        <hr />
        
        <ul>
			<li><a href="<s:url action='AuctionList' namespace="/member"/>">Show all auctions</a></li>     
			<li><a href="<s:url action='NewAuctionForm' namespace="/member"/>">Enter new auction</a></li>
			<li><a href="<s:url action='MyAuctionList' namespace="/member"/>">Show own auctions</a></li>            	
            <li><a href="<s:url action='Account' namespace="/member"/>">My Account</a></li>
            <li><a href="<s:url action='Logout' namespace="/member"/>">Logout</a></li>
        </ul>
        
	</body>
</html>
