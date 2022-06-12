<%@page import="javax.websocket.Session"%>
<%@page import="metier.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Utilisateur u = (Utilisateur) session.getAttribute("user");
	%>
	Id User :
	<%=u.getIdUser()%>
	<br> Login :
	<%=u.getLogin()%>
	<br> Pass :
	<%=u.getPass()%>
	<br> Email :
	<%=u.getEmail()%>
	<br> Ville :
	<%=u.getVille()%>
	
	<form method="POST" action="ServletAffichage"><input type="submit" value="liste des utilisateurs"></form>
	<a href="Register.jsp"><input type="submit" value="Ajouter un utilisateur"></a>
</body>
</html>