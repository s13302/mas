package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.time.LocalDate;

public class Renting extends ObjectPlus {

    private LocalDate from;
    private LocalDate to;
    private Book book;
    private Reader reader;

    protected Renting(LocalDate from, Book book, Reader reader) {
        setFrom(from);
        setBook(book);
        setReader(reader);
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null in renting");
        }
        if (getBook() != book) {
            if (getBook() != null) {
                getBook().removeRenting(this);
            }
            this.book = book;
            book.addRenting(this);
        }
    }

    protected void removeBookAssociation(Book book) {
        if (book != null && getBook() == book) {
            this.book = null;
            book.removeRenting(this);
        }
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("Reader cannot be null");
        }
        if (getReader() != reader) {
            if (getReader() != null) {
                getReader().removeRenting(this);
            }
            this.reader = reader;
            reader.addRenting(this);
        }
    }

    protected void removeReaderAssociation(Reader reader) {
        if (reader != null && getReader() == reader) {
            this.reader = null;
            reader.removeRenting(this);
        }
    }

    @Override
    public String toString() {
        return "Renting{" +
                "from=" + getFrom() +
                ", to=" + getTo() +
                ", book=" + getBook() +
                ", reader=" + getReader() +
                '}';
    }
}
