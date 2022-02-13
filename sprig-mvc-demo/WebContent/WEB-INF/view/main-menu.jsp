<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
    
<title>SpringDemo</title>

</head>

<body>

<h1>Spring MVC Demo Home Page</h1>

<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />

<form action="hello/showForm" method = "GET">

<input type ="Submit" value="StartDemo"/>

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>

<br><br>

<a href="student/showForm">If you are a student. Click Here!!!!</a>

<br><br>

<a href="customer/showForm">To buy our product. Click Here!!!!</a>

</form>

</body>

</html>