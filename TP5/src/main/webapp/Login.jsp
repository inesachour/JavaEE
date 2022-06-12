<P>Please fill out this form with your name. Thanks!
<FORM METHOD="GET" action="ServletLogin">
	<P>Please enter your login and password:
	<P>
		login: <INPUT NAME="login" TYPE="TEXT" SIZE=" 12" MAXLENGTH=" 20">
	<P>
		password: <INPUT NAME="password" TYPE="TEXT" SIZE=" 12"
			MAXLENGTH=" 20">
	<P>
		Thank you! <INPUT TYPE="SUBMIT">
		<%
		if (request.getAttribute("erreur") != null) {
		%>
		<%=request.getAttribute("erreur")%>
		<%
		}
		%>	
</FORM>