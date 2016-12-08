package com.mera.bookshelf;
import java.util.ArrayList;
import java.util.List;

public class BookController {
	private List<Book> savedBooks;
	
	public BookController() {
		savedBooks = new ArrayList<Book>();
	}
	
	public void saveBook(Book entity) {
		savedBooks.add(entity);
	}
	public List<Book> getSavedBooks() {
		return savedBooks;
	}
}
