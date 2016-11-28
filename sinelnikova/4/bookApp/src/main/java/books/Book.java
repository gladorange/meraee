package books;

import java.io.Serializable;

/**
 * Created by Viktoria on 25-Sep-16.
 */
public class Book implements Serializable {
    private String author = null;
    private String title = null;
    private String summary = null;
    private int pagesNum = 0;

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }
}
