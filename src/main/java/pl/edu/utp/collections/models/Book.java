package pl.edu.utp.collections.models;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Book) {
            Book book = (Book) o;
            return pageCount == book.pageCount && Objects.equals(title, book.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageCount);
    }

    @Override
    public String toString() {
        return "Book: " + getTitle();
    }
}
