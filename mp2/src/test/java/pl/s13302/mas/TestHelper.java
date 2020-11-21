package pl.s13302.mas;

import pl.s13302.mas.model.*;

import java.time.LocalDate;

public class TestHelper {

    public static Address createAddress() {
        return new Address(
                "Dobra",
                "56/66",
                "Warszawa",
                "00-312"
        );
    }

    public static Library createLibrary() {
        return new Library("Biblioteka Uniwersytecka", createAddress());
    }

    public static Book createBook() {
        return new Book("TestISBN", "", createLibrary());
    }

    public static Author createAuthor() {
        return new Author(
                "Rafał",
                "",
                "Podkoński",
                LocalDate.of(1991, 9, 25)
        );
    }

    public static Reader createReader() {
        return new Reader(
                "Rafał",
                "",
                "Podkoński",
                LocalDate.of(1991, 9, 25)
        );
    }

}
