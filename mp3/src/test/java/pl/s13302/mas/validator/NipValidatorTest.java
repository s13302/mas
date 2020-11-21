package pl.s13302.mas.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class NipValidatorTest {

    public static final String CORRECT_NIP_WITH_DASH = "118-201-69-86";
    public static final String CORRECT_NIP_WITHOUT_DASH = "1182016986";
    public static final String INCORRECT_NIP_TOO_SHORT = "118201698";
    public static final String INCORRECT_NIP_TOO_LONG = "118-201-69-860";

    private NipValidator nipValidator;

    @Before
    public void setup() {
        nipValidator = new NipValidator();
    }

    @Test
    public void testCorrectNipWithDash() {
        assertTrue(nipValidator.doValidate(CORRECT_NIP_WITH_DASH));
    }

    @Test
    public void testCorrectNipWithoutDash() {
        assertTrue(nipValidator.doValidate(CORRECT_NIP_WITHOUT_DASH));
    }

    @Test
    public void testIncorrectNipTooShort() {
        assertFalse(nipValidator.doValidate(INCORRECT_NIP_TOO_SHORT));
    }

    @Test
    public void testIncorrectNipTooLong() {
        assertFalse(nipValidator.doValidate(INCORRECT_NIP_TOO_LONG));
    }

}
