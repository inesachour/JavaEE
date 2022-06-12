<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Login</td>
			<td>Email</td>
			<td>Ville</td>
		</tr>

		<%
		for (Utilisateur u : (Vector<Utilisateur>) request.getAttribute("users")) {
		%>
		<tr>
			<td><%=u.getLogin()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getVille()%></td>
			<td>
				<form method="GET" action="ServletDelete">
					<input type="hidden" value=<%=u.getLogin()%> name="login">
					<input type="hidden" value=<%=u.getPass()%> name="password">
					<input type="submit" value="delete">
				</form>
			</td>
			<td>
				<form method="GET" action="ServletModifier">
					<input type="hidden" name="id" value=<%=u.getIdUser()%>> <input
						type="submit" value="modifier">
				</form>
			</td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>