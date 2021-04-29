package pl.edu.utp.collections.models;

public class FantasyBook extends Book {

    public FantasyBook(String title, int pageCount) {
        super(title, pageCount);
    }

    @Override
    public String toString() {
        return "Fantasy book: " + getTitle();
    }

}
