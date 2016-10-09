package kyunysh;

import java.util.LinkedList;
import java.util.List;

/**
 * Session Bean implementation class BookController
 */
public class BookController {

	private final List<Book> savedBooks = new LinkedList<Book>();

	/**
	 * Default constructor.
	 */
	public BookController() {
		// TODO Auto-generated constructor stub
	}

	public void saveBook(final Book anBook) {
		savedBooks.add(anBook);
	}

	public List<Book> getSavedBooks() {
		return savedBooks;
	}
}
