<%--
  Created by IntelliJ IDEA.
  User: artem-ostrovsky
  Date: 10.10.2016
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, org.arvios.books.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ArViOs Books 1.0</title>
</head>
<body>

<form action="books.jsp" method="post">
    <label for="txtAuthor">Author:</label>
    <input type="text" id="txtAuthor" name="txtAuthor" size="30" maxlength="50">
    <br>
    <br>
    <label for="txtNumberOfPages">Number of pages:</label>
    <input type="text" id="txtNumberOfPages" name="txtNumberOfPages" size="4" maxlength="4"
           onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
    <br>
    <br>
    <label for="txtName">Name:</label>
    <input type="text" id="txtName" name="txtName" size="50" maxlength="100">
    <br>
    <br>
    <label for="txtDescription">Description:</label>
    <input type="text" id="txtDescription" name="txtDescription" size="50" maxlength="100">
    <br>
    <br>
    <br>
    <input type="submit" id="btnSave" name="btnSave" value="Save">
    <jsp:useBean id="bookController" class="org.arvios.books.BookController" scope="application">
        <%
            if (request.getParameter("btnSave") != null) {
                Book book = new Book();
                book.setAuthor(request.getParameter("txtAuthor"));
                book.setNumberOfPages(Integer.parseInt(request.getParameter("txtNumberOfPages")));
                book.setName(request.getParameter("txtName"));
                book.setDescription(request.getParameter("txtDescription"));
                bookController.saveBook(book);
            }
        %>
    </jsp:useBean>
    <br>
    <br>
    <br>
    <br>
    <table>
        <tr>
            <th>Author</th>
            <th>Number of Pages</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <%
            for (Book book : bookController.getSavedBooks()) {
        %>
        <tr>
            <td><%= book.getAuthor() %></td>
            <td><%= Integer.toString(book.getNumberOfPages()) %></td>
            <td><%= book.getName() %></td>
            <td><%= book.getDescription() %></td>
        </tr>
        <%
            }
        %>
    </table>
</form>

</body>
</html>
