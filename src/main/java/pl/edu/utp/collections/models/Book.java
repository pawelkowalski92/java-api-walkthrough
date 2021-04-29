package pl.edu.utp.collections.models;

public class Book {

    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book: " + getTitle();
    }
}
