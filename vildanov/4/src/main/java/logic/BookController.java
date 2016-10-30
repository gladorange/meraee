package logic;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by svildan on 23.10.2016.
 */

public class BookController {
    private List<Book> booksList;

    public BookController() {
        booksList = new ArrayList<Book>();
    }

    public void saveBook(Book book) {
        booksList.add(book);
    }

     public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
