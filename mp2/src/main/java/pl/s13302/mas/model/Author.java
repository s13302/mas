package pl.s13302.mas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author extends Person {

    private static final long serialVersionUID = 1L;

    private List<Book> writtenBooks = new ArrayList<>();

    public Author(String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        super(firstName, middleName, lastName, dateOfBirth);
    }

    public List<Book> getWrittenBooks() {
        return Collections.unmodifiableList(writtenBooks);
    }

    public void addWrittenBook(Book book) {
        if (!getWrittenBooks().contains(book)) {
            writtenBooks.add(book);
            book.addAuthor(this);
        }
    }

    public void removeWrittenBook(Book book) {
        if (getWrittenBooks().contains(book)) {
            writtenBooks.remove(book);
            book.removeAuthor(this);
        }
    }

}
