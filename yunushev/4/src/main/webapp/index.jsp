<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lesson #4</title>
</head>
<body>
	<form action="index.jsp" method="GET">
		<jsp:useBean id="Book" class="kyunysh.Book"></jsp:useBean>
		<jsp:setProperty property="name" name="Book"/>
		<jsp:setProperty property="author" name="Book"/>
		<jsp:setProperty property="pageNumbers" name="Book"/>
		<jsp:setProperty property="description" name="Book"/>
		<p>
			Name: <input type="text" name="name">
		</p>
		<p>
			Author: <input type="text" name="author"> <br>
		</p>
		<p>
			Page number: <input type="text" name="pageNumbers"> <br>
		</p>
		<p>
			Description: <input type="text" name="description"> <br>
		</p>
		<p>
			<input type="submit" value="Save book">
		</p>
	</form>
	<jsp:useBean id="BookController" class="kyunysh.BookController" scope="application"></jsp:useBean>
</body>
</html>