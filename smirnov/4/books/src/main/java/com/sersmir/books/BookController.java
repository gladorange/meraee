package com.sersmir.books;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sersmir on 09.12.2016.
 */
public class BookController {
    private List<Book> savedBooks = new ArrayList<Book>();

    public void saveBook(Book book) {
        savedBooks.add(book);
    }

    public List<Book> getSavedBooks() {
        return savedBooks;
    }
}
