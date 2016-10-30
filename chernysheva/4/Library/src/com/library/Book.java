package com.library;

import java.io.Serializable;

public class Book  implements Serializable {
	private String author;
	
	private String title;
	
	private String description;
	
	private String pagesCount;

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPagesCount() {
		return this.pagesCount;
	}

	public void setPagesCount(String pagesCount) {
		this.pagesCount = pagesCount;
	}
}

