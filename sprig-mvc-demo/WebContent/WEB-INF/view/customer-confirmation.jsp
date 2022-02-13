<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<title>CustomerConfirmation</title>

</head>

<body>

<h1>Your order is confirmed!. PFB the details</h1>

First Name: ${customer.firstName}

<br><br>

Last Name: ${customer.lastName}

<br><br>

Age:${customer.age}

<br><br>

Email id:${customer.emailid}

<br><br>

Products ordered:
<ul>
<c:forEach var="temp" items="${customer.product}">
<li>${temp}</li></c:forEach>
</ul>

<br><br>
Course Code: ${customer.theCourseCode}

<br><br>

Product Code: ${customer.uniproductCode}

<br><br>

</body>



</html>