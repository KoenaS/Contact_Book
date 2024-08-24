<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<h3>
			<a href="new">New Contact</a>
		</h3>
		<table border="1">
			<th>No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="contact" items="${contactList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.phone}</td>
					<td><a href="editContact?id=${contact.contact_id}">Edit</a> <a
						href="deleteContact?id=${contact.contact_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>