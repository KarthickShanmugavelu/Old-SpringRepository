<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<title>CustomerForm</title>

<style>
.error {
	color: red
}
</style>

</head>

<body>
	<h1>Form to get Cutomer form.</h1>
	<i>Please fill out the below form.Asterisk(*) means mandatory to
		fill</i>
	<br><br>	
	<form:form action="processForm" modelAttribute="customer">
First Name(*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		
<br><br>

Last Name(*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>

Age: <form:input path="age"/>
<form:errors path="age" cssClass="error"/>

<br><br>

Email id: <form:input path="emailid"/>
<form:errors path="emailid" cssClass="error"/>

<br><br>
		
Please select required products:
	<form:checkbox path="product" value="Core_JAVA_Book"/>Core JAVA Book
	<form:checkbox path="product" value="Spring_MVC_Book"/>Spring MVC Book
	<form:checkbox path="product" value="Spring_Boot_Book"/>Spring Boot Book
	<form:checkbox path="product" value="Spring_WebFlux_Book"/>Spring WebFlux Book

<br><br>	

Enter Course Code:<form:input path="theCourseCode"/>
<form:errors path="theCourseCode" cssClass="error"/>

<br><br>	

Enter Product Code:<form:input path="uniproductCode"/>
<form:errors path="uniproductCode" cssClass="error"/>

<br><br>
		<input type="Submit" value="Submit"/>
	</form:form>
</body>
</html>