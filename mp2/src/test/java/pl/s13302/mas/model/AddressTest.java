package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import static org.junit.Assert.*;

public class AddressTest {

    private Address address;

    @Before
    public void setup() {
        address = TestHelper.createAddress();
    }

    @Test
    public void testLibraryAssociationAdd() {
        Library library = TestHelper.createLibrary();
        address.setLibrary(library);

        assertSame(library, address.getLibrary());
        assertSame(address, library.getAddress());
    }

    @Test
    public void testLibraryAssociationRemove() {
        Library library = TestHelper.createLibrary();
        address.setLibrary(library);

        assertSame(library, address.getLibrary());
        assertSame(address, library.getAddress());

        address.setLibrary(null);

        assertNull(library.getAddress());
        assertNull(address.getLibrary());
    }
}
