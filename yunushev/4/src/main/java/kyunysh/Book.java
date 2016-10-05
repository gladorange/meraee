package kyunysh;

public class Book {

	private String name;
	private String author;
	private int pageNumbers;
	private String description;

	/**
	 * Default constructor.
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(final int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}
