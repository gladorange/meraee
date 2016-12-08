package com.mera.bookshelf;
import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -545430141678247462L;
	private String author;
	private Integer quantity;
	private String name;
	private String description;

	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
}
