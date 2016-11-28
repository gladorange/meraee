<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Books</title>
</head>
<body>

<jsp:useBean id="bookContr" class="books.BookController" scope="application"/>
<jsp:useBean id="book" class="books.Book" scope="request">
    <jsp:setProperty name="book" property="*"/>
</jsp:useBean>

<form action="books.jsp" method="POST">
    <h3>Author</h3>
    <input type="text" name="author"/>
    <h3>Title</h3>
    <input type="text" name="title"/>
    <h3>Summary</h3>
    <input type="text" name="summary"/>
    <h3>Number of pages</h3>
    <input type="text" name="pagesNum"/>
    <p>
        <input type="submit" value="Submit">
    </p>
</form>

<h3>Previously saved books:</h3>
<c:forEach var="book" items="${bookContr.savedBooks}">
    <c:out value="${book.author}"/> <c:out value="${book.title}"/> <c:out value="${book.summary}"/> <c:out
        value="${book.pagesNum}"/> <p/>
    <hr>
</c:forEach>

<% if (book.getAuthor() != null && book.getTitle() != null && book.getSummary() != null && book.getPagesNum() > 0) {
    bookContr.saveBook(book);
}
%>

</body>
</html>