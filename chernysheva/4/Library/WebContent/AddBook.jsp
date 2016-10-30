<%@page import="com.library.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a book</title>
</head>
<body>
<h3>Add a new book:</h3>
<!-- <form action="SaveBook.jsp" method="POST"> -->
<form action="AddBook.jsp" method="POST">
Author: <input type="text" name="author" size="50">
<br />
Title: <input type="text" name="title" size="52">
<br/>
Description: <input type="text" name="description" size="46">
<br />
Pages count: <input type="text" name="pagesCount" size="5">
<br />
<br>
<input type="submit" name="submit" value="Submit" />
<br/>
<br/>
<jsp:useBean id="bookController" class="com.library.BookController" scope="application"/>
<jsp:useBean id="book" class="com.library.Book" scope="request"/>
<jsp:setProperty name="book" property="*"/> 
<font color=red>
<% 
if (request.getParameter("submit") != null) {
    int pagesNumber = 0;
	try {
		pagesNumber = Integer.parseUnsignedInt(book.getPagesCount());
	}
	catch (NumberFormatException e)
	{
	}
	
	if (book.getAuthor() == null) { %>
        The book cannot be added: please enter the Author <br>
 <% }
	else if (book.getTitle() == null) { %>
 	    The book cannot be added: please enter the Title <br>
 <% }
    else if (pagesNumber == 0) { %>
        The book cannot be added: please enter a valid Number of Pages <br>
 <% }
    else {
      	bookController.saveBook(book); 
     } 
  } %>
</font> 
<br/>
<h3> In the Library:</h3>
<%
    if (bookController.getSavedBooks().size() > 0) {
    	int i = 1;   
    	for (Book item: bookController.getSavedBooks()) {    		 		
            %>
            Book <%=i%>: <%=item.getAuthor()%>, <%=item.getTitle()%>, <%=item.getPagesCount()%> pages 
         <% if (item.getDescription() != null) { %>
                , <%=item.getDescription() %><br>
         <% }
            i++;
            %><br><% 
        }
    }
    else {
    	%> No books now. <%
    }
%>
</form>
</body>
</html>