package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import static org.junit.Assert.*;

public class RentingTest {

    private Library library;
    private Book book;
    private Reader reader;

    @Before
    public void setup() {
        library = TestHelper.createLibrary();
        book = TestHelper.createBook();
        reader = TestHelper.createReader();

        library.addBook(book);
    }

    @Test
    public void testIsRentingReturnedByObject() {
        Renting renting = library.rentBook(book, reader);

        assertNotNull(renting);
    }

    @Test
    public void testIsRentingReturnedByIsbn() {
        Renting renting = library.rentBook(book.getIsbn(), reader);

        assertNotNull(renting);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRentingReturnedByNullObject() {
        Renting renting = library.rentBook((Book) null, reader);

        assertTrue(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRentingReturnedByNullIsbn() {
        Renting renting = library.rentBook((String) null, reader);

        assertTrue(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRentingReturnedWithNullReader() {
        Renting renting = library.rentBook(book, null);

        assertTrue(false);
    }

    @Test
    public void testBookAssociation() {
        Renting renting = library.rentBook(book, reader);

        assertSame(book, renting.getBook());
        assertTrue(book.getRentings().contains(renting));
    }

    @Test
    public void testReaderAssociation() {
        Renting renting = library.rentBook(book, reader);

        assertSame(reader, renting.getReader());
        assertTrue(reader.getRentings().contains(renting));
    }

}
