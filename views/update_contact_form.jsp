<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact Form</title>
</head>
<body>
	<div align="center">
		<h1>Update Contact</h1>
		<form:form action="updateContact" method="post" modelAttribute="contact">
			<table>
				<form:hidden path="contact_id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>