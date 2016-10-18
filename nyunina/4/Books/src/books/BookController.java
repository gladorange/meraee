package books;


import java.util.ArrayList;
import java.util.List;

public class BookController {
	private List<Book> savedBooks = new ArrayList<>();
	
	public List<Book>getSavedBooks()
	{
		return savedBooks;
	}
	
	public void saveBook(Book currentBook) 
	{
		savedBooks.add(currentBook);
	}

}
