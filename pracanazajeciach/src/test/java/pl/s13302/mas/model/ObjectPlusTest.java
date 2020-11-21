package pl.s13302.mas.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ObjectPlusTest {

    @Test
    public void testLoadEmptyExtension() {
        ObjectPlus.saveExtension();
        ObjectPlus.loadExtension();

        assertEquals(0, ObjectPlus.getExtension().size());
    }

    @Test
    public void testLoadExtension() {
        Movie movie = new Movie(1L, "Dummy Title", new Date(), Rating._7, "Sci-Fi");

        ObjectPlus.saveExtension();
        ObjectPlus.loadExtension();

        assertEquals(1, ObjectPlus.getExtension().size());
        assertEquals(movie, ObjectPlus.getExtension().get(0));
    }

}
