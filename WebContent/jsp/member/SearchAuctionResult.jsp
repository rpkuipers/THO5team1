<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>List of all auctions</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Result.</h4>
	    
	    <hr />

<s:form action="AuctionDetails">
    	  
		
	    <table>
		    <tr class="thcolor">
			    <th>title</th>
			    <th>name</th>
			    <th>description</th>
			    <th>entrydate</th>
			    <th>startprice</th>
			    <th>buyoutprice</th>
			    <th></th>
			    
		    </tr>
		    <s:iterator value="searchResult">
			    <tr class="tdcolor">
				    <td><s:property value="title" />
					<td><s:property value="productName" />
		     		<td><s:property value="description" />
		     		<td><s:property value="entryDate" />
					<td><s:property value="startPrice" />
		     		<td><s:property value="buyoutPrice" />
		     		<s:hidden name="title"/>
		     		<td><s:submit value="Bid now!"/>
		        </tr>
 		    </s:iterator>
	    </table>
	    </s:form>

		<a href=" <s:url action="MemberMenu" namespace="/member" /> ">Back to the menu.</a>
	</body> 
</html> 