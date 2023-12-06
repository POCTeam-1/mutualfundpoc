<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required="required">
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="number" name="age" required="required">
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required="required">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Register">
				</td>
			</tr>
		</table>
	</form>
	<h5 style="color: red;">${message}</h5>
	<%-- <c:if test="${not empty message}">
        <p style="color: red;">${message}</p>
    </c:if> --%>
</body>
</html>