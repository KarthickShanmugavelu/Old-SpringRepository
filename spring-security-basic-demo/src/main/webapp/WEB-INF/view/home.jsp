<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Demo</title>
</head>
<body>
	<h1>Welcome to Spring Security Demo</h1>
	<hr>
	<br>
	<h2>
	<!-- Display username and user role -->
	<p>User: <security:authentication property="principal.username"/></p>
	<br><br>
	Role(s): <security:authentication property="principal.authorities"/></p>
	</h2>
	<hr>
	<br><br>
	<p>You are looking at the home page</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<hr>
	<!-- Add a link to /leaders... this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		(Only for Managers)
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<hr>
	<!-- Add a link to Managers -->
	<p>
		<a href ="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>(Only for Admins)
	</p>
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>