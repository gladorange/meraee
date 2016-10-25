package logic;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by svildan on 23.10.2016.
 */
public class Book implements Serializable {
    private int numberPages;
    private String author;
    private String name;
    private double price;

    public Book(){

    }
    public Book(int numberPages, String author, String name, double price) {
        this.numberPages = numberPages;
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
