<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<body>

<jsp:useBean id="bc" class="com.aryabin.lesson4.BookController" scope="application"/>
<jsp:useBean id="b" class="com.aryabin.lesson4.Book" scope="request"/>
<jsp:setProperty name="b" property="*"/>
<h2>Books</h2>

<%
	if (b.getName() != null && b.getAuthor() != null && b.getPageCount() > 0 && b.getDescription() != null) {
		bc.saveBook(b);
	}
%>

<form method="POST">
	<input type="text" name="name" placeholder="Enter book name"/>
	<input type="text" name="author" placeholder="Enter author"/>
	<input type="text" name="pageCount" placeholder="Enter page Count"/>
	<input type="text" name="description" placeholder="Enter description"/>
	<input type="submit" name="btnSubmit" value="Save book"/>
</form>

<table>
<c:forEach var="book" items="${bc.getSavedBooks()}" >
	${book.name} ${book.author} ${book.pageCount} ${book.description} <br>
</c:forEach>
</table>

</body>
</html>