package pl.s13302.mas.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;
import pl.s13302.mas.extension.ObjectPlus;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AddressTest {

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        TestHelper.setupEmptyExtension();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseNumberLessThan0() {
        new Address(-5, "Warszawa", "00-000");
        assertTrue("House number was -5", false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseNumberNull() {
        new Address(null, "Warszawa", "00-000");
        assertTrue("House number was null", false);
    }

    @Test
    public void testZipCodeInCorrectFormat() {
        Address address = new Address(1, "Warszawa", "98-345");
        assertEquals("98-345", address.getZipCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZipCodeInIncorrectFormat() {
        new Address(1, "Warszawa", "98345");
        assertTrue(false);
    }

    @Test
    public void testAddressFoundInExtension() {
        Address address = new Address(1, "Warszawa", "98-345");
        Address foundAddress = Address.findAddressInExtension(null, 1, "Warszawa", "98-345");
        assertSame(address, foundAddress);
    }

    @Test
    public void testAddressNotFoundInExtension() {
        Address address = new Address(1, "Warszawa", "98-345");
        Address foundAddress = Address.findAddressInExtension(null, 1, "Empty", "34-444");
        assertNotSame(address, foundAddress);
        assertNull(foundAddress);
    }

}
