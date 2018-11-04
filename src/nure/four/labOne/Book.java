package nure.four.labOne;
/**
 *
 */

import java.lang.Integer;
import java.util.Comparator;

/**
 * @author Дарина
 *
 */
public class Book {

    private String fio;
    private String title;
    private String publisher;
    private int year;
    private int pages=0;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public Book(){
        this.pages=0;
        this.year=1990;
    }

    public Book(String fio, String title, String publisher, int year, int pages) {

        this.fio = fio;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
    }

}

