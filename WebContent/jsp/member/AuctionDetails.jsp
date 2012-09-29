<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Auction</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Auction.</h4>
	    
	    <hr />
		<s:iterator value="detailedAuction">
		
    	<h4><s:property value="title" /></h4> 
		
	    <table>
		    <tr class="thcolor">
			    <th>Product Name</th>
			    <th>Description</th>
			    <th>Entrydate</th>
			    <th>Startdate</th>
			    <th>Enddate</th>
			    <th>Current prize</th>
			    <th>Buyout prize</th>
			    
		    </tr>
			    <tr class="tdcolor">
					<td><s:property value="productName" />
		     		<td><s:property value="description" />
		     		<td><s:property value="entryDate" />
		     		<td><s:property value="startDate" />
		     		<td><s:property value="endDate" />
					<td><s:property value="startPrice" />
		     		<td><s:property value="buyoutPrice" />
		        </tr>
	    </table>
	    </s:iterator>
	    		
    	<h4>Bids</h4> 
	    
	    <table>
		    <tr class="thcolor">
			    <th>Username</th>
			    <th>Bid</th>
		    </tr>
		    <s:iterator value="bids">
			    <tr class="tdcolor">
					<td><s:property value="username" />
		     		<td><s:property value="amount" />
		        </tr>
		    </s:iterator>
	    </table>
	    
	    <hr />
	   
		<s:form action="Bid">
		<s:fielderror></s:fielderror>
		  <s:iterator value="detailedAuction">
		  	<s:hidden name="title"/>
	      </s:iterator>
	      
    	  <s:textfield name="amount" label="Amount"/>
    	  <s:submit value="Bid!"/>
		</s:form>
			
	    <hr />
	    
	    <s:iterator value="auctionUser">
		<h5><s:property value="name" /></h5> 
		
	    <table>
		    <tr class="thcolor">
			    <th>Username</th>
			    <th>Name</th>
			    <th>Address</th>
			    <th>E-mail</th>
			    <th>Phone Number</th>
			    
		    </tr>
			    <tr class="tdcolor">
					<td><s:property value="username" />
		     		<td><s:property value="name" />
		     		<td><s:property value="address" />
		     		<td><s:property value="email" />
		     		<td><s:property value="phoneNumber" />
		        </tr>
	    </table>
	    </s:iterator>

		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body> 
</html> 