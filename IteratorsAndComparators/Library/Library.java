package Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator(){
        return new Iterator<Book>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Book next() {
                return null;
            }
        };
    }


    }
}
