package org.arvios.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public class BookController implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Book> savedBooks;

    public BookController() {
        savedBooks = new ArrayList<Book>();
    }

    public List<Book> getSavedBooks() {
        return savedBooks;
    }

    public void saveBook(Book book) {
        savedBooks.add(book);
    }
}
