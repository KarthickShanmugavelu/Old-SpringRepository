<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<title>StudentRegistrationform</title>

</head>

<body>

	<h1>Student Registration Page</h1>

	<form:form action="processForm" modelAttribute="student">

FirstName: <form:input placeholder="Enter First Name" path="firstName" />

		<br>
		<br>

LastName: <form:input placeholder="Enter Last Name" path="lastName" />

		<br>
		<br>

Gender:
<form:radiobutton path="gender" value="Male" />Male
<form:radiobutton path="gender" value="Female" />Female
<form:radiobutton path="gender" value="Others" />Others

<br>
		<br>

Timezone Preferred:<form:radiobuttons path="timezone"
			items="${student.timezoneOptions}" />

		<br>
		<br>

Select Country: 

<form:select path="country">

			<!--- Hardcoding values in form
<form:option value="Brazil" label="Brazil"/>
<form:option value="India" label="India"/>
<form:option value="Germany" label="Germany"/>
<form:option value="Australia" label="Australia"/>
<form:option value="Japan" label="Japan"/> --->


			<form:options items="${student.countryOptions}" />
		</form:select>

		<br>
		<br>
Select Course: 
<form:select path="course">
			<form:options items="${theCourseList}" />
		</form:select>
		<br>
		<br>

In which social network we can reach you?
		<form:checkbox path="source" value="Facebook" />Facebook
		<form:checkbox path="source" value="Instagram" />Instagram
		<form:checkbox path="source" value="LinkedIn" />LinkedIn
		<form:checkbox path="source" value="Pinterest" />Pinterest

		<br>
		<br>

		<input type="Submit" value="Register" />

	</form:form>

	<br>
	<br>
</body>
</html>