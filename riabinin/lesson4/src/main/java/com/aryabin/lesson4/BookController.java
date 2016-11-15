package com.aryabin.lesson4;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	private List<Book> books;
	
	public BookController() {
		books = new ArrayList<Book>();
	}
	
	public List<Book> getSavedBooks() {
		return books;
	}
	
	public void saveBook(Book book) {
		books.add(book);
	}
}
