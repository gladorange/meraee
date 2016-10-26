<%--
  Created by IntelliJ IDEA.
  User: svildan
  Date: 23.10.2016
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lab4</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <section id="content">
        <div class="row">
            <div class="col-md-7">
                <form
                      action=""  method="POST">
                    <div class="form-group">
                        <label for="numberPages">Input number of pages</label>
                        <input type="number" class="form-control" id="numberPages" placeholder="Number of pages" name="numberPages" required>
                    </div>
                    <div class="form-group">
                        <label for="author">Author</label>
                        <input type="text" class="form-control" id="author" placeholder="Author" name="author" required>
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" placeholder="Name of book" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" class="form-control" id="price" placeholder="Price" name="price" required>
                    </div>
                    <input type="submit" class="btn btn-default" value="Save" name="save"/>
                </form>
                <jsp:useBean id="bookCtrl" class="logic.BookController" scope="session"/>
                <jsp:useBean id="book" class="logic.Book" scope="request"/>
                <jsp:setProperty name="book" property="*"></jsp:setProperty>
                <%
                    if (request.getParameter("save") != null){
                        if (null!=book.getName())
                        bookCtrl.saveBook(book);
                    }
                %>
            </div>
            <div class="col-md-5">
                <table class="table-collapse">
                    <caption>Books list</caption>
                    <th>Name</th><th>Author</th><th>Price</th><th>Number of pages</th>
                    <c:forEach items="<%=bookCtrl.getBooksList()%>" var="b">
                        <tr><td><c:out value="${b.name}"/></td><td><c:out value="${b.author}"/></td><td><c:out value="${b.price}"/></td><td><c:out value="${b.numberPages}"/></td></tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </section>
</div>
</body>
</html>
