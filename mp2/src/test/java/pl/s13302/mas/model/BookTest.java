package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setup() {
        book = TestHelper.createBook();
    }

    @Test
    public void testAuthorAssociationAdd() {
        Author author = TestHelper.createAuthor();
        book.addAuthor(author);

        assertTrue(book.getAuthors().contains(author));
        assertTrue(author.getWrittenBooks().contains(book));
    }

    @Test
    public void testAuthorAssociationRemove() {
        Author author = TestHelper.createAuthor();
        book.addAuthor(author);

        assertTrue(book.getAuthors().contains(author));
        assertTrue(author.getWrittenBooks().contains(book));

        book.removeAuthor(author);

        assertFalse(book.getAuthors().contains(author));
        assertFalse(author.getWrittenBooks().contains(book));
    }

    @Test
    public void testLibraryAssociationAdd() {
        Library library = TestHelper.createLibrary();
        book.setLibrary(library);

        assertSame(library, book.getLibrary());
        assertTrue(library.getBooks().contains(book));
    }

}
