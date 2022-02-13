<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<title>StudentconfirmationPage</title>

</head>

<body>

	<h1>Registration successful!. You are confirmed!. PFB the updated
		details.</h1>

	Student Name: ${student.firstName} ${student.lastName }
	<br>
	<br> Gender: ${student.gender }
	<br>
	<br> Student Country: ${student.country }
	<br>
	<br> Course selected: ${student.course}
	<br>
	<br> Timezone Preferred:${student.timezone }
	<br>
	<br> Social networks in which we can reach you:
	<ul>
		<c:forEach var="temp" items="${student.source}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>

</html>