package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author;

    @Before
    public void setup() {
        author = TestHelper.createAuthor();
    }

    @Test
    public void testBookAssociationAdd() {
        Book book = TestHelper.createBook();
        author.addWrittenBook(book);

        assertTrue(author.getWrittenBooks().contains(book));
        assertTrue(book.getAuthors().contains(author));
    }

    @Test
    public void testBookAssociationRemove() {
        Book book = TestHelper.createBook();
        author.addWrittenBook(book);

        assertTrue(author.getWrittenBooks().contains(book));
        assertTrue(book.getAuthors().contains(author));

        author.removeWrittenBook(book);

        assertFalse(author.getWrittenBooks().contains(book));
        assertFalse(book.getAuthors().contains(author));
    }

}
