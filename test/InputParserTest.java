/**
 * @file InputParserTest.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.resources.InputParser;

public class InputParserTest {
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
