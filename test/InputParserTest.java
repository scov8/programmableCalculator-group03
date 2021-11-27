/**
 * @file InputParserTest.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.resources.InputParser;
import src.main.java.resources.ComplexNumber;

public class InputParserTest {
    @Test
    public void testParseNumber() {
        // default cases with both positive and negative values for real and
        // imaginary part of the number.
        ComplexNumber n = new ComplexNumber(2, 5);
        assertEquals(n, InputParser.parseNumber("2 + 5i"));
        n.setValues(-10, 5);
        assertEquals(n, InputParser.parseNumber("-10 + 5j"));
        n.setValues(-10, -25);
        assertEquals(n, InputParser.parseNumber("-10 -25i"));
        n.setValues(123, -7);
        assertEquals(n, InputParser.parseNumber("+123 -7i"));
        n.setValues(12.3, -7.3);
        assertEquals(n, InputParser.parseNumber("12.3 - 7.3j"));
        n.setValues(-12.3, -7.3);
        assertEquals(n, InputParser.parseNumber("-12.3 - 7.3i"));

        // at least one of the two parts is null.
        n.setValues(0, 0);
        assertEquals(n, InputParser.parseNumber("0 + 0 i"));
        n.setValues(0, 0);
        assertEquals(n, InputParser.parseNumber("0"));
        n.setValues(0, 0);
        assertEquals(n, InputParser.parseNumber("0j"));
        n.setValues(0, 0);
        assertEquals(n, InputParser.parseNumber("0i"));
        n.setValues(3, 0);
        assertEquals(n, InputParser.parseNumber("3"));
        assertEquals(n, InputParser.parseNumber("+3"));
        n.setValues(-3, 0);
        assertEquals(n, InputParser.parseNumber("-3"));
        n.setValues(0, 12.05);
        assertEquals(n, InputParser.parseNumber("12.05i"));
        assertEquals(n, InputParser.parseNumber("+12.05i"));
        n.setValues(0, -12.05);
        assertEquals(n, InputParser.parseNumber("-12.05i"));

        // string only contains imaginary letter.
        n.setValues(0, 1);
        assertEquals(n, InputParser.parseNumber("i"));
        assertEquals(n, InputParser.parseNumber("I"));
        assertEquals(n, InputParser.parseNumber("j"));
        assertEquals(n, InputParser.parseNumber("J"));

        // unrecognized input.
        assertEquals(null, InputParser.parseNumber("12a"));
        assertEquals(null, InputParser.parseNumber("hello world"));
        assertEquals(null, InputParser.parseNumber("3 + 2"));
        assertEquals(null, InputParser.parseNumber("3 +- 2"));
        assertEquals(null, InputParser.parseNumber("3 +- 2i"));
        assertEquals(null, InputParser.parseNumber("-3 -+ 212i"));
        assertEquals(null, InputParser.parseNumber("3a + 212i"));
        assertEquals(null, InputParser.parseNumber("a2 + 212i"));
        assertEquals(null, InputParser.parseNumber("ai"));
    }

    @Test
    public void testIsOperation() {
        // test recognized operations (also with spaces in the string).
        assertTrue(InputParser.isOperation("+"));
        assertTrue(InputParser.isOperation(" +"));
        assertTrue(InputParser.isOperation("-"));
        assertTrue(InputParser.isOperation("- "));
        assertTrue(InputParser.isOperation("*"));
        assertTrue(InputParser.isOperation(" * "));
        assertTrue(InputParser.isOperation("/"));
        assertTrue(InputParser.isOperation("   /   "));
        assertTrue(InputParser.isOperation("+-"));
        assertTrue(InputParser.isOperation("sqrt"));

        // unrecognized operations.
        assertFalse(InputParser.isOperation("sqrtAB"));
        assertFalse(InputParser.isOperation("ciao"));
        assertFalse(InputParser.isOperation("+ -"));
        assertFalse(InputParser.isOperation("+--"));
        assertFalse(InputParser.isOperation("2+"));
        assertFalse(InputParser.isOperation("2+3i"));
    }
}
