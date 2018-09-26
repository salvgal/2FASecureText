<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<center>Your Username: ${loggedInUser}</center>
		<center>Your salt: ${salt}</center>
		<font color="red">${message}</font>
		<form:form id="loginForm" method="post" action="login2" modelAttribute="loginBean">
			<form:label path="otp">Enter the OTP</form:label>
			<form:input id="otp" name="otp" path="" /><br>
			<input type="hidden" name="salt" value="${salt}" />
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>