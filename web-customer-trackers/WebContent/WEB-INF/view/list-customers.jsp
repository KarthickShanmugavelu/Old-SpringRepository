<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<title>WebCustomerTracker</title>

<link type = "text/css"
	  rel = "stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- create add customerbutton -->
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
			<!-- add our table -->
			<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- construct an update link embedded with customer id  -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a></td>
				</c:forEach>



			</table>

		</div>
	</div>
	
	<div style="clear;both;"></div>
		
		<p>
		
			<a href="${pageContext.request.contextPath}/customer/home">Back to list</a>
		
		</p>
	

</body>

</html>