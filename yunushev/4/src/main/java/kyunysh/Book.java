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

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
