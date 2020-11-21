package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {

    private Student student;

    @Before
    public void setup() {
        this.student = new Student("Rafał", "Podkoński", createAddress(), LocalDate.of(1970, 1, 1), "G");
    }

    @Test
    public void testGetAge() {
        student.setBirthDate(LocalDate.of(1991, 9, 25));
        assertEquals(27, student.getAge().intValue());
        student.setBirthDate(LocalDate.of(1971, 9, 25));
        assertEquals(47, student.getAge().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeWhenBirthDateIsNull() {
        student.setBirthDate(null);
    }

    private Address createAddress() {
        return new Address(1, "Warszawa", "00-000");
    }

}
