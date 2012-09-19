<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>List of auctions</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Auctionlist.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>title</th>
			    <th>name</th>
			    <th>description</th>
			    <th>startdate</th>
			    <th>enddate</th>
			    <th>startprice</th>
			    <th>buyoutprice</th>
			    
		    </tr>
		    <s:iterator value="auctions">
			    <tr class="tdcolor">
				    <td><s:property value="title" />
					<td><s:property value="productName" />
		     		<td><s:property value="description" />
		     		<td><s:property value="startDate" />
		     		<td><s:property value="endDate" />
					<td><s:property value="startPrice" />
		     		<td><s:property value="buyoutPrice" />
		        </tr>
 		    </s:iterator>
	    </table>
  		
	    <hr /> 
	    
		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body> 
</html> 