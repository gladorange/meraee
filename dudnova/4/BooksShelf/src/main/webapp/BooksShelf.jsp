<%@ page import="com.mera.bookshelf.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Books Shelf</title>
<link rel="stylesheet" type="text/css" href="look.css">
</head>
<body>

<h3>Add a new Book:</h3>
<form action="BooksShelf.jsp" method="POST">
Author:          <input type="text" name="author">
<br>
<br>
Number of Pages: <input type="text" name="quantity">
<br>
<br>
Book title:      <input type="text" name="name">
<br>
<br>
<textarea rows="4" cols="50" name="description">
Enter description here...</textarea>
<br>
<input type="submit" name="submit" value="Save" />
<br>
<br>
<jsp:useBean id="BookController" class="com.mera.bookshelf.BookController" scope="application"/>
<jsp:useBean id="entity" class="com.mera.bookshelf.Book" scope="request"/>
<jsp:setProperty name="entity" property="*"/>
<% 
if (request.getParameter("submit") != null) {
	BookController.saveBook(entity);
}%>
<table>
  <tr>
    <th>Author</th>
    <th>Number of Pages</th>
    <th>Book title</th>
    <th>Description</th>
  </tr>
<%
int i=1;
for (Book item: BookController.getSavedBooks()) {
%>	<tr>
    	<td><%=item.getAuthor()%></td>
    	<td><%=item.getQuantity()%></td>
    	<td><%=item.getName()%></td>
    	<td><%=item.getDescription()%></td>
  	</tr>
<%
i++;
}%>
</table>
</form>
</body>
</html>