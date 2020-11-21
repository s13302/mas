package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.mas.TestHelper;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReaderTest {

    private Reader reader;

    @Before
    public void setup() {
        reader = TestHelper.createReader();
    }

    @Test
    public void testReadingAssociationRentingConstructor() {
        Renting renting = new Renting(LocalDate.now(), TestHelper.createBook(), reader);

        assertSame(reader, renting.getReader());
        assertTrue(reader.getRentings().contains(renting));
    }

    @Test
    public void testRendingAssociationRentingSetter() {
        Renting renting = new Renting(LocalDate.now(), TestHelper.createBook(), TestHelper.createReader());
        renting.setReader(reader);

        assertSame(reader, renting.getReader());
        assertTrue(reader.getRentings().contains(renting));
    }

    @Test
    public void testRentingAssociationReaderSetter() {
        Renting renting = new Renting(LocalDate.now(), TestHelper.createBook(), TestHelper.createReader());
        reader.addRenting(renting);

        assertSame(reader, renting.getReader());
        assertTrue(reader.getRentings().contains(renting));
    }

}
