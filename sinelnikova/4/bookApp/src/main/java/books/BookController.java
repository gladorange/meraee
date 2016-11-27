package books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktoria on 25-Sep-16.
 */
public class BookController implements Serializable {
    private List<Book> savedBooks = new ArrayList<>();

    public BookController() {
    }

    public List<Book> getSavedBooks() {
        return savedBooks;
    }

    public void saveBook(Book book) {
        savedBooks.add(book);
    }
}
