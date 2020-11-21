package pl.s13302.mas.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MovieTest {

    private final static Long ID = 1L;
    private final static String TITLE = "Dummy Title";
    private final static Date RELEASE_DATE = new Date();
    private final static Rating RATING = Rating._7;
    private final static String[] CATEGORIES = { "Sci-Fi" };

    private Movie movie;

    @Before
    public void setup() {
        movie = new Movie(ID, TITLE, RELEASE_DATE, RATING, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testRequiredId() {
        new Movie(null, TITLE, RELEASE_DATE, RATING, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testRequiredTitle() {
        new Movie(ID, null, RELEASE_DATE, RATING, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyTitle() {
        new Movie(ID, "", RELEASE_DATE, RATING, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testRequiredReleaseDate() {
        new Movie(ID, TITLE, null, RATING, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testRequiredRating() {
        new Movie(ID, TITLE, RELEASE_DATE, null, CATEGORIES);
    }

    @Test(expected = NullPointerException.class)
    public void testRequiredCategories() {
        new Movie(ID, TITLE, RELEASE_DATE, RATING, null);
    }

    @Test(expected = NullPointerException.class)
    public void testZeroCategoriesArray() {
        String[] zero = {};
        new Movie(ID, TITLE, RELEASE_DATE, RATING, zero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCategoryOutOfKnownCategories() {
        new Movie(ID, TITLE, RELEASE_DATE, RATING, "Out of known categories");
    }

    @Test
    public void testAddCategory() {
        String CATEGORY = "Thiller";
        movie.addCategory(CATEGORY);

        assertEquals(2, movie.getCategory().size());
        assertTrue(movie.getCategory().contains(CATEGORY));
    }

}
