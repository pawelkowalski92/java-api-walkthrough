package pl.edu.utp.collections.models;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }
    public int getPageCount() {
        return pageCount;
    }

    /*
    if returns negative:
    {this}, {other}
    if returns positive:
    {other}, {this}
    if returns 0:
    {this} == {other} (treated as equals)
     */
    @Override
    public int compareTo(Book other) {
        int result = this.pageCount - other.pageCount;
        if (result == 0) {
            result = this.title.compareTo(other.title);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Book) {
            return compareTo((Book) o) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageCount);
    }

    @Override
    public String toString() {
        return "Book: " + getTitle() + "[" + pageCount + "]";
    }

}
