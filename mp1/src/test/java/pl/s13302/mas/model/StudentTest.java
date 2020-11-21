package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentTest {

    private Address address;
    private Student student;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        TestHelper.setupEmptyExtension();
        address = new Address("Street1", 1, "City1", "00-000");
        student = new Student("Mikołaj", "Kopernik", address, LocalDate.MIN, "spec1", "spec2", "spec3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBirthDateLessThanMIN_AGE() {
        student.setBirthDate(LocalDate.now());
        assertTrue(false);
    }

    @Test
    public void testSetBirthDateGreaterThanMIN_AGE() {
        student.setBirthDate(LocalDate.MIN);
        assertTrue(LocalDate.MIN.isEqual(student.getBirthDate()));
    }

    @Test
    public void testStudentFoundInExtension() {
        Student foundStudent = Student.findStudentInExtenstion("Mikołaj", "Kopernik", address, LocalDate.MIN, "spec1", "spec2", "spec3");
        assertSame(student, foundStudent);
    }

    @Test
    public void testStudentNotFoundInExtension() {
        Student foundStudent = Student.findStudentInExtenstion("None", "None", address, LocalDate.MIN, "None");
        assertNotSame(student, foundStudent);
        assertNull(foundStudent);
    }

}
