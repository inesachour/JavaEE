<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pkg.GestionEtudiants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 	
	for(int i=0;i<GestionEtudiants.etudiants.size();i++)
	{
		String etudiant = GestionEtudiants.etudiants.get(i).nom + " "+ GestionEtudiants.etudiants.get(i).prenom + "      "; 
		%>
		<ol>
			<li>
			<%=etudiant %>
			</li>
		</ol>	
	<%}
%>
</body>
</html>