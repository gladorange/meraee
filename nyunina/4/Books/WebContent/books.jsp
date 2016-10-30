<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Books storage</title>
</head>
<body>
<jsp:useBean id="bookController" class="books.BookController" scope="session"/>

<form action="
<jsp:useBean id="book" class="books.Book" scope="page"/> 
<jsp:setProperty name="book" property="*"/> 
<% if(book.getTitle()!= null && !book.getTitle().isEmpty()) {
bookController.saveBook(book);
}
%> 
" method="GET"> 

Author: <input type="text" name="author"><br> 
Title: <input type="text" name="title"><br> 
Number of pages: <input type="text" name="numberOfPages"><br> 
Description: <input type="text" name="description"><br> 
<input type="submit" value="Add book"> 
</form> 

<label><b>List of saved books</b></label><br>

<c:forEach var="book" items="${bookController.savedBooks}" varStatus="loopCounter"> 
           
<p>
<i><b><c:out value="Book #: ${loopCounter.count}"/></b></i><br>
Author: 
   <c:out value="${book.author}"/><br>
Title: 
   <c:out value="${book.title}"/><br>
Number of pages: 
  <c:out value="${book.numberOfPages}"/><br>
Description: 
   <c:out value="${book.description}"/><br>
</p>
</c:forEach>


</body>
</html>