package logic;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ansemen on 03.10.2016.
 */
public class BookController implements Serializable{

    private List<Book> savedBooks;

    public BookController(){
        savedBooks = new ArrayList<>();
    }

    public List<Book> getSavedBooks(){
        return savedBooks;
    }

    public void saveBook(Book book) {
        if(savedBooks == null) {
            savedBooks = new ArrayList<>();
        }
        savedBooks.add(book);
    }

    public String getBookList() {
        return StringUtils.join(
                savedBooks.stream().map(book -> book.getName()).collect(Collectors.toList()), ",");
    }
}
