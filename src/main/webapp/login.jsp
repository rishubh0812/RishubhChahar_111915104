<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<label for="usernamelbl">Enter employeeID</label>
		<input type="text" name="ID" required><br>
		<label for="passlbl">Enter password</label>
		<input type="password" name="Pwd" required><br>
		<input type="submit" value="login">
		<input type="reset">
		<a href="SignUp.jsp">SignUp</a>
	</form>
</body>
</html>