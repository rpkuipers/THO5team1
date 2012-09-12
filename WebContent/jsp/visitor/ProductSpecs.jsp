<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Boek Info</title>
<link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<body>
	<h4>Boek Info.</h4>

	<hr />

	<table>
		<tr class="thcolor">
			<th>attribuut</th>
			<th>waarde</th>
		</tr>
			<tr><td>id</td><td><s:property value="id"/></td></tr>           <%-- Gegevens ophalen uit ValueStack --%>
			<tr><td>titel</td><td><s:property value="titel"/></td></tr>
			<tr><td>auteur</td><td><s:property value="auteur"/></td></tr>
			<tr><td>isbn</td><td><s:property value="isbn"/></td></tr>
			<tr><td>pages</td><td><s:property value="pages"/></td></tr>
	</table>
	<hr />

	<a href=" <s:url value="/"/> ">Terug naar het startmenu</a>
</body>
</html>
