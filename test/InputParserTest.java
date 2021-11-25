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
        n.setValues(-3, 0);
        assertEquals(n, InputParser.parseNumber("-3"));
        n.setValues(0, 12);
        assertEquals(n, InputParser.parseNumber("12i"));
        n.setValues(0, -12.5);
        assertEquals(n, InputParser.parseNumber("-12.5i"));

        assertEquals(null, InputParser.parseNumber("12a"));
        assertEquals(null, InputParser.parseNumber("hello world"));
        assertEquals(null, InputParser.parseNumber("3 + 2"));
        assertEquals(null, InputParser.parseNumber("3 +- 2"));
        assertEquals(null, InputParser.parseNumber("3 +- 2i"));
        assertEquals(null, InputParser.parseNumber("-3 -+ 212i"));
        assertEquals(null, InputParser.parseNumber("3a + 212i"));
        assertEquals(null, InputParser.parseNumber("a2 + 212i"));
    }

    @Test
    public void testIsOperation() {
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

        assertFalse(InputParser.isOperation("sqrtAB"));
        assertFalse(InputParser.isOperation("ciao"));
        assertFalse(InputParser.isOperation("+ -"));
        assertFalse(InputParser.isOperation("+--"));
        assertFalse(InputParser.isOperation("2+"));
        assertFalse(InputParser.isOperation("2+3i"));
    }
}
