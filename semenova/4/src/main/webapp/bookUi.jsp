<%--
  Created by IntelliJ IDEA.
  User: ansemen
  Date: 03.10.2016
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New book</title>
</head>
<body>
<p><b>Input info about new book</b></p><br>
<jsp:useBean id="controller" class="logic.BookController" scope="session"></jsp:useBean>
<form action="
    <jsp:useBean id="book" class="logic.Book" scope="page"></jsp:useBean>
    <jsp:setProperty name="book" property="*"></jsp:setProperty>
    <%
        if(book.getName()!= null && !book.getName().isEmpty()) {
            controller.saveBook(book);
        }
    %>

" method="POST">
<label>Name        </label><input name="name" TYPE = text><br>
<label>Description </label><input name="description" TYPE = text><br>
<label>Pages       </label><input name="pages" TYPE = number><br>
<label>Author      </label><input name="author" TYPE = text><br>
    <input type="submit" value="Save book">
</form>

<label>List of books</label></p>

NAME DESCRIPTION PAGES AUTHOR</p>
<c:forEach var="book" items="<%=controller.getSavedBooks()%>">
    <c:out value="${book.name}"/> <c:out value="${book.description}"/> <c:out value="${book.pages}"/> <c:out value="${book.author}"/></p>
    </c:forEach>

<label>End list of books</label>
</body>
</html>
