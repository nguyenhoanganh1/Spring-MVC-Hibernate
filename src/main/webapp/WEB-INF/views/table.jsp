<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h1>Contact List</h1>
		<h3>
			<a href="/SpringMVC/newContact">New Contact</a>
		</h3>
		<table border="1">
			<th>No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th></th>

			<c:forEach var="contact" items="${contacts}">
				<tr>
					
					<td>${contact.contact_id}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.telephone}</td>
					<td><a href="edit/${contact.contact_id}">Edit</a> <a
						href="delete/${contact.contact_id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>