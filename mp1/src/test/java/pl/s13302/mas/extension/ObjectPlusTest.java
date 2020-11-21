package pl.s13302.mas.extension;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;
import pl.s13302.mas.model.Address;
import pl.s13302.mas.model.Student;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class ObjectPlusTest {

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        TestHelper.setupEmptyExtension();
    }

    @Test
    public void testAddingToExtensioStudent() {
        Student student = new Student(
                "Marek",
                "Marek",
                new Address("Koszykowa", 1, "Warszawa", "00-000"),
                LocalDate.of(1980, 1, 1),
                "G");
        assertTrue(ObjectPlus.getExtension(Student.class).contains(student));
    }

    @Test
    public void testAddingToExtensionAddress() {
        Address address = new Address("Koszykowa", 1, "Warszawa", "00-000");
        assertTrue(ObjectPlus.getExtension(Address.class).contains(address));
    }

}
