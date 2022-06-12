<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<%
	int nbl =  Integer.parseInt(request.getParameter("nbLignes"));
	int nbc = Integer.parseInt(request.getParameter("nbCols"));
%>
</h1>
<table>
	<%	for(int i= 0;i<nbl;i++) {	%>
	<tr style="border:1px solid red; ">
		<%	for(int j =0;j<nbc;j++) {	%>
		<td style="border:1px solid red; ">
		 <%=i %>, <%=j %>
		</td>
		<%	}	%>
	</tr>
	<%	}	%>
</table>
</body>
</html>



