package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.time.LocalDate;
import java.util.*;

public class Library extends ObjectPlus {

    private static final long serialVersionUID = 1L;

    private String name;
    private Address address;
    private Map<String, Book> books = new HashMap<>();

    public Library(String name, Address address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (getAddress() != address) {
            if (getAddress() != null && getAddress() != address) {
                getAddress().removeLibraryAssociation(this);
            }
            this.address = address;
            if (address != null) {
                address.setLibrary(this);
            }
        }
    }

    protected void removeAddressAssociation(Address address) {
        if (this.address != null && this.address == address) {
            this.address = null;
            address.removeLibraryAssociation(this);
        }
    }

    public Collection<Book> getBooks() {
        return Collections.unmodifiableCollection(books.values());
    }

    public Book findBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public void addBook(Book book) {
        if (!getBooks().contains(book)) {
            books.put(book.getIsbn(), book);
            book.setLibrary(this);
        }
    }

    public void addBooks(Book... books) {
        for (Book book: books) {
            addBook(book);
        }
    }

    public void removeBook(Book book) {
        if (books.containsKey(book.getIsbn()) && books.containsValue(book)) {
            books.remove(book.getIsbn(), book);
            book.setLibrary(null);
        }
    }

    public Renting rentBook(String isbn, Reader reader) {
        return rentBook(findBookByIsbn(isbn), reader);
    }

    public Renting rentBook(Book book, Reader reader) {
        Renting renting = new Renting(LocalDate.now(), book, reader);
        return renting;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + getName() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}
