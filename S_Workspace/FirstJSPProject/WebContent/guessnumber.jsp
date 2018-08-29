<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guess the number</title>
<!-- You need to set a session attribute to a random number between 1 and 100,
when the user makes a guess you check that against the random number.  If the guess is 
too high then you display a suitable message like 'Too High', if it is too low then 'Too Low'.
When the number matches you display a message like 'Correct guess :)' 
 -->
</head>
<body>
<h2>Guess a number between 1 and 100</h2>
<%
	if(request.getParameter("guess") != null){
		out.println(String.format("<p>Your guess is %s </p>",request.getParameter("guess")));
	}
%>
<form action="guessnumber.jsp" method="get">
	<input type="text" name="guess" />&nbsp;<input type="submit" value="Guess the number" />
</form>
<br><br><a hrkef="index.html">Home</a>
</body>
</html>