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
			<p style="display:inline-block;"><%=etudiant %></p>
			<!-- <form method="POST" action="SupprimerEtudiant" style="display: inline-block;">
				<input type="hidden" value="" name="cin" />
				<button type="submit" >Supprimer Etudiant</button>
			</form> -->
			<a href="SupprimerEtudiant?cin=<%= GestionEtudiants.etudiants.get(i).cin %>">Supprimer Etudiant</a>
			</li>
		</ol>	
	<%}
%>
</body>
</html>