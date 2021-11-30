/**
 * @file InputParserTest.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.resources.TextRecognizer;
import src.main.java.resources.ComplexNumber;

public class InputParserTest {
    private static TextRecognizer textRecognizer;

    @BeforeClass
    public static void setUp() {
        textRecognizer = new TextRecognizer();
    }

    @Test
    public void testParseNumber() {
        // default cases with both positive and negative values for real and
        // imaginary part of the number.
        ComplexNumber n = new ComplexNumber(2, 5);
        assertEquals(n, textRecognizer.extractNumber("2 + 5i"));
        n.setValues(-10, 5);
        assertEquals(n, textRecognizer.extractNumber("-10 + 5j"));
        n.setValues(-10, -25);
        assertEquals(n, textRecognizer.extractNumber("-10 -25i"));
        n.setValues(123, -7);
        assertEquals(n, textRecognizer.extractNumber("+123 -7i"));
        n.setValues(12.3, -7.3);
        assertEquals(n, textRecognizer.extractNumber("12.3 - 7.3j"));
        n.setValues(-12.3, -7.3);
        assertEquals(n, textRecognizer.extractNumber("-12.3 - 7.3i"));
        n.setValues(2, 1);
        assertEquals(n, textRecognizer.extractNumber("2 + i"));
        n.setValues(2, -1);
        assertEquals(n, textRecognizer.extractNumber("2 - i"));

        // at least one of the two parts is null.
        n.setValues(0, 0);
        assertEquals(n, textRecognizer.extractNumber("0 + 0 i"));
        n.setValues(0, 0);
        assertEquals(n, textRecognizer.extractNumber("0"));
        n.setValues(0, 0);
        assertEquals(n, textRecognizer.extractNumber("0j"));
        n.setValues(0, 0);
        assertEquals(n, textRecognizer.extractNumber("0i"));
        n.setValues(3, 0);
        assertEquals(n, textRecognizer.extractNumber("3"));
        assertEquals(n, textRecognizer.extractNumber("+3"));
        n.setValues(-3, 0);
        assertEquals(n, textRecognizer.extractNumber("-3"));
        n.setValues(0, 12.05);
        assertEquals(n, textRecognizer.extractNumber("12.05i"));
        assertEquals(n, textRecognizer.extractNumber("+12.05i"));
        n.setValues(0, -12.05);
        assertEquals(n, textRecognizer.extractNumber("-12.05i"));

        // string only contains imaginary letter.
        n.setValues(0, 1);
        assertEquals(n, textRecognizer.extractNumber("i"));
        assertEquals(n, textRecognizer.extractNumber("I"));
        assertEquals(n, textRecognizer.extractNumber("j"));
        assertEquals(n, textRecognizer.extractNumber("J"));

        // unrecognized input.
        assertEquals(null, textRecognizer.extractNumber("12a"));
        assertEquals(null, textRecognizer.extractNumber("hello world"));
        assertEquals(null, textRecognizer.extractNumber("3 + 2"));
        assertEquals(null, textRecognizer.extractNumber("3 +- 2"));
        assertEquals(null, textRecognizer.extractNumber("3 +- 2i"));
        assertEquals(null, textRecognizer.extractNumber("-3 -+ 212i"));
        assertEquals(null, textRecognizer.extractNumber("3a + 212i"));
        assertEquals(null, textRecognizer.extractNumber("a2 + 212i"));
        assertEquals(null, textRecognizer.extractNumber("ai"));
    }

    @Test
    public void testisStackOperation() {
        // test recognized operations (also with spaces in the string).
        assertTrue(textRecognizer.isStackOperation("+"));
        assertTrue(textRecognizer.isStackOperation(" +"));
        assertTrue(textRecognizer.isStackOperation("-"));
        assertTrue(textRecognizer.isStackOperation("- "));
        assertTrue(textRecognizer.isStackOperation("*"));
        assertTrue(textRecognizer.isStackOperation(" * "));
        assertTrue(textRecognizer.isStackOperation("/"));
        assertTrue(textRecognizer.isStackOperation("   /   "));
        assertTrue(textRecognizer.isStackOperation("+-"));
        assertTrue(textRecognizer.isStackOperation("+ -"));
        assertTrue(textRecognizer.isStackOperation("sqrt"));

        // unrecognized operations.
        assertFalse(textRecognizer.isStackOperation("sqrtAB"));
        assertFalse(textRecognizer.isStackOperation("ciao"));
        assertFalse(textRecognizer.isStackOperation("+--"));
        assertFalse(textRecognizer.isStackOperation("2+"));
        assertFalse(textRecognizer.isStackOperation("2+3i"));
    }
}
