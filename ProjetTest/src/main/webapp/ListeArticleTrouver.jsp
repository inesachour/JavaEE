<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Article"%>
<%@ page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="border:1px solid black; ">
<tr style="border:1px solid black;"> 
	<td>Code </td>
	<td>Nom </td>
	<td>Description </td>
	<td>Prix </td>
	<td>Quantite </td>
</tr>

	<%for(Article a : (Vector<Article>) request.getAttribute("article")){ %>
	<tr style="border:1px solid red;">
	<td style="border:1px solid black;"><%=a.getCode()%> </td>
	<td style="border:1px solid black;"><%=a.getNom()%> </td>
	<td style="border:1px solid black;"><%=a.getDescription()%> </td>
	<td style="border:1px solid black;"><%=a.getPrix()%> </td>
	<td style="border:1px solid black;"><%=a.getQuantite()%> </td>
	</tr>
	<%} %>

</table>
	
</body>
</html>