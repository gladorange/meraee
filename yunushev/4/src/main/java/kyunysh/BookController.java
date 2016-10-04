package kyunysh;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BookController
 */
@Stateless
@LocalBean
public class BookController {
	
	private List<Book> itsBooks = new LinkedList<Book>(); 

    /**
     * Default constructor. 
     */
    public BookController() {
        // TODO Auto-generated constructor stub
    }

    public void saveBook(Book anBook) {
    	itsBooks.add(anBook);
    }
    
    public List<Book> getSavedBooks() {
    	return itsBooks;
    }
}
