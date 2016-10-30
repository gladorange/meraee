package com.library;

import java.util.ArrayList;
import java.util.List;

public class BookController{
	private List<Book> SavedBooks;
	
	public BookController() {
		SavedBooks = new ArrayList<Book>();
	}
	
	public void saveBook(Book book) {
        SavedBooks.add(book);
	}

    public List<Book> getSavedBooks() {
    	return SavedBooks;
    }
}
