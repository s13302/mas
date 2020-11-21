package pl.s13302.mas;

import pl.s13302.mas.model.*;

import java.time.LocalDate;

public class Main {

    private static final String ISBN_1 = "9788301156398";
    private static final String ISBN_2 = "9788301156300";

    public static void main(String[] args) {
        Address address = new Address("Koszykowa", "86", "Warszawa", "02-008");
        Library library = new Library("Biblioteka PJATK", address);
        Book book1 = new Book(ISBN_1, "Obiekty z klasą", library);
        Book book2 = new Book(ISBN_2, "Head first Java", library);
        Author author1 = new Author("Dorota", "", "Cendrowska", LocalDate.now());
        Author author2 = new Author("Rafał", "", "Podkoński", LocalDate.now());
        Reader reader = new Reader("Rafał", "", "Podkoński", LocalDate.now());

        book1.addAuthor(author1); // Asocjacja binarna - Book -> Author
        author2.addWrittenBook(book1); // Asocjacja binarna - Author -> Book

        System.out.println(library.findBookByIsbn(ISBN_1)); // Asocjacja kwalifikowana - wyszukiwanie po kluczu

        Renting renting = library.rentBook(ISBN_1, reader); // Asocjacja z atrybutem - asocjacja jest między obiektem klasy Book i obiektem klasy Reader
        System.out.println(renting);

        book1.addChapter("1", "Wstęp"); // Kompozycja
        book1.addChapter("2", "Rozwinięcie"); // Kompozycja
        book1.addChapter("3", "Zakończenie"); // Kompozycja
        Book.Chapter chapter = book1.new Chapter("4", "Bibliografia"); // Kompozycja

        System.out.println(book1.getChapters());
    }

}
