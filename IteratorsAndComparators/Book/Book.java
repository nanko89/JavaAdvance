package Book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
      setTitle(title);
      setYear(year);
      setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        for (String author : authors) {
             this.authors.add(author);
        }
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
