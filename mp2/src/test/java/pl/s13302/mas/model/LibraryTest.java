package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setup() {
        library = TestHelper.createLibrary();
    }

    @Test
    public void testBookAssociationAdd() {
        Book book = TestHelper.createBook();
        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
        assertSame(library, book.getLibrary());
    }

    @Test
    public void testBookAssociationRemove() {
        Book book = TestHelper.createBook();
        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
        assertSame(library, book.getLibrary());

        library.removeBook(book);

        assertFalse(library.getBooks().contains(book));
        assertNull(book.getLibrary());
    }

    @Test
    public void testAddressAssociationAdd() {
        Address address = TestHelper.createAddress();
        library.setAddress(address);

        assertEquals(address, library.getAddress());
        assertEquals(library, address.getLibrary());
    }

    @Test
    public void testAddressAssociationRemove() {
        Address address = TestHelper.createAddress();
        library.setAddress(address);

        assertEquals(address, library.getAddress());
        assertEquals(library, address.getLibrary());

        library.setAddress(null);

        assertNull(library.getAddress());
        assertNull(address.getLibrary());
    }

    @Test
    public void testFindByIsbnNull() {
        assertNull(library.findBookByIsbn(null));
    }

    @Test
    public void testFindByIsbnEmpty() {
        Book book = TestHelper.createBook();

        assertNull(library.findBookByIsbn(book.getIsbn()));
    }

    @Test
    public void testFindByIsbnSuccess() {
        Book book = TestHelper.createBook();
        library.addBook(book);

        assertSame(book, library.findBookByIsbn(book.getIsbn()));
    }

}
