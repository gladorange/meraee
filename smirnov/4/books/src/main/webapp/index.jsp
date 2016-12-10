<%--
  Created by IntelliJ IDEA.
  User: sersmir
  Date: 09.12.2016
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books App</title>
</head>
<body>
<jsp:useBean id="bookCtrl" class="com.sersmir.books.BookController" scope="application"></jsp:useBean>
<jsp:useBean id="book" class="com.sersmir.books.Book" scope="request"></jsp:useBean>
<jsp:setProperty name="book" property="*"></jsp:setProperty>

<form action="index.jsp" method="post">
  <br><input type="text" name="name" placeholder="Book name"/></br>
  <br><input type="text" name="description" placeholder="Book description"/></br>
  <br><input type="text" name="author" placeholder="Book author"/></br>
  <br><input type="text" name="pages" placeholder="Book number of pages"/></br>
  <br><input type="submit" name="save" value="Save Book"></br>
</form>
<%
  if((book.getName()!= null) && (book.getDescription()!= null) && (book.getAuthor()!= null)) {
    bookCtrl.saveBook(book);
  }
%>

<h3>List of books</h3>
<table>
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>Author</th>
    <th>Pages</th>
  </tr>
  <c:forEach var="book" items="${bookCtrl.savedBooks}">
  <tr>
    <td> <c:out value="${book.name}"/> </td>
    <td> <c:out value="${book.description}"/> </td>
    <td> <c:out value="${book.author}"/> </td>
    <td> <c:out value="${book.pages}"/> </td>
  </tr>
</c:forEach>
</body>
</html>
