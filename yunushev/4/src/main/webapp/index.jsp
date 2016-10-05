<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lesson #4</title>
</head>
<body>
	<jsp:useBean id="Book" class="kyunysh.Book" scope="request"></jsp:useBean>
	<jsp:useBean id="BookController" class="kyunysh.BookController"
		scope="application"></jsp:useBean>
	<form action="" method="POST">
		<jsp:setProperty property="name" name="Book" />
		<jsp:setProperty property="author" name="Book" />
		<jsp:setProperty property="pageNumbers" name="Book" />
		<jsp:setProperty property="description" name="Book" />
		<p>
			Name: <input type="text" name="name">
		</p>
		<p>
			Author: <input type="text" name="author">
		</p>
		<p>
			Page number: <input type="text" name="pageNumbers">
		</p>
		<p>
			Description: <input type="text" name="description">
		</p>
		<p>
			<input type="submit" value="Save book">
		</p>
		<%
			BookController.saveBook(Book);
		%>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Author</th>
				<th>Page numbers</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${BookController.savedBooks}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.author}</td>
					<td>${item.pageNumbers}</td>
					<td>${item.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>