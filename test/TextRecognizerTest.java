/**
 * @file InputParserTest.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.resources.TextRecognizer;
import src.main.java.userOperations.UserOperation;
import src.main.java.operations.OperationsMap;
import src.main.java.resources.ComplexNumber;

public class TextRecognizerTest {
    private static TextRecognizer textRecognizer;

    @BeforeClass
    public static void setUp() {
        textRecognizer = new TextRecognizer();
    }

    @Test
    public void testFormatText() {
        String s = "+";
        assertEquals(s, textRecognizer.formatText("+"));
        assertEquals(s, textRecognizer.formatText(" +"));
        assertEquals(s, textRecognizer.formatText("  +"));
        assertEquals(s, textRecognizer.formatText("  + "));
        assertEquals(s, textRecognizer.formatText("  +  "));

        s = "hello";
        assertEquals(s, textRecognizer.formatText("hello"));
        assertEquals(s, textRecognizer.formatText("hello "));
        assertEquals(s, textRecognizer.formatText(" hello "));
        assertEquals(s, textRecognizer.formatText("  hello  "));
        assertEquals(s, textRecognizer.formatText("HELLO"));
        assertEquals(s, textRecognizer.formatText("HelLO"));
        assertNotEquals(s, textRecognizer.formatText("hel lo"));
        assertNotEquals(s, textRecognizer.formatText("H E L L O"));
        assertNotEquals(s, textRecognizer.formatText("H E   lL O"));

        s = "+ -";
        assertEquals(s, textRecognizer.formatText("+ -"));
        assertEquals(s, textRecognizer.formatText("+  -"));
        assertEquals(s, textRecognizer.formatText("+  -  "));
        assertEquals(s, textRecognizer.formatText(" +  -  "));
        assertNotEquals(s, textRecognizer.formatText("+-"));
    }

    @Test
    public void testExtractNumber() {
        // default cases with both positive and negative values for real and
        // imaginary part of the number.
        ComplexNumber n = new ComplexNumber(2, 5);
        assertEquals(n, textRecognizer.extractNumber("2+5i"));
        n.setValues(-10, 5);
        assertEquals(n, textRecognizer.extractNumber("-10+5j"));
        n.setValues(-10, -25);
        assertEquals(n, textRecognizer.extractNumber("-10-25i"));
        n.setValues(123, -7);
        assertEquals(n, textRecognizer.extractNumber("+123-7i"));
        n.setValues(12.3, -7.3);
        assertEquals(n, textRecognizer.extractNumber("12.3-7.3j"));
        n.setValues(-12.3, -7.3);
        assertEquals(n, textRecognizer.extractNumber("-12.3-7.3i"));
        n.setValues(2, 1);
        assertEquals(n, textRecognizer.extractNumber("2+i"));
        n.setValues(2, -1);
        assertEquals(n, textRecognizer.extractNumber("2-i"));

        // at least one of the two parts is null.
        n.setValues(0, 0);
        assertEquals(n, textRecognizer.extractNumber("0+0i"));
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
        assertEquals(n, textRecognizer.extractNumber("j"));

        // number written with spaces is not recognized
        assertEquals(null, textRecognizer.extractNumber("2 + 3i"));
        assertEquals(null, textRecognizer.extractNumber("2+3 i"));
        assertEquals(null, textRecognizer.extractNumber("- 2 + 3 i"));

        // double number written with ','
        assertEquals(null, textRecognizer.extractNumber("1+2,5i"));

        // unrecognized input.
        assertEquals(null, textRecognizer.extractNumber("12a"));
        assertEquals(null, textRecognizer.extractNumber("3I"));
        assertEquals(null, textRecognizer.extractNumber("4-50J"));
        assertEquals(null, textRecognizer.extractNumber("hello world"));
        assertEquals(null, textRecognizer.extractNumber("3 + 2"));
        assertEquals(null, textRecognizer.extractNumber("3 +- 2"));
        assertEquals(null, textRecognizer.extractNumber("3 +- 2i"));
        assertEquals(null, textRecognizer.extractNumber("-3 -+ 212i"));
        assertEquals(null, textRecognizer.extractNumber("3a + 212i"));
        assertEquals(null, textRecognizer.extractNumber("a2 + 212i"));
        assertEquals(null, textRecognizer.extractNumber("ai"));
        assertEquals(null, textRecognizer.extractNumber("I"));
        assertEquals(null, textRecognizer.extractNumber("J"));
    }

    @Test
    public void testIsStackOperation() {
        // test recognized operations.
        assertTrue(textRecognizer.isStackOperation("+"));
        assertTrue(textRecognizer.isStackOperation("-"));
        assertTrue(textRecognizer.isStackOperation("*"));
        assertTrue(textRecognizer.isStackOperation("/"));
        assertTrue(textRecognizer.isStackOperation("+-"));
        assertTrue(textRecognizer.isStackOperation("sqrt"));

        // unrecognized operations.
        assertFalse(textRecognizer.isStackOperation("+ -"));
        assertFalse(textRecognizer.isStackOperation("sqrtAB"));
        assertFalse(textRecognizer.isStackOperation("ciao"));
        assertFalse(textRecognizer.isStackOperation("+--"));
        assertFalse(textRecognizer.isStackOperation("2+"));
        assertFalse(textRecognizer.isStackOperation("2+3i"));
    }

    @Test
    public void testIsVariableOperation() {
        // test recognized operations.
        assertTrue(textRecognizer.isVariableOperation(">a"));
        assertTrue(textRecognizer.isVariableOperation("<a"));
        assertTrue(textRecognizer.isVariableOperation("+a"));
        assertTrue(textRecognizer.isVariableOperation("-a"));
        assertTrue(textRecognizer.isVariableOperation(">i"));
        assertTrue(textRecognizer.isVariableOperation("<i"));
        assertTrue(textRecognizer.isVariableOperation("+i"));
        assertTrue(textRecognizer.isVariableOperation("-i"));
        assertTrue(textRecognizer.isVariableOperation(">j"));
        assertTrue(textRecognizer.isVariableOperation("<j"));
        assertTrue(textRecognizer.isVariableOperation("+j"));
        assertTrue(textRecognizer.isVariableOperation("-j"));

        // unrecognized operations.
        assertFalse(textRecognizer.isVariableOperation(">A"));
        assertFalse(textRecognizer.isVariableOperation("+A"));
        assertFalse(textRecognizer.isVariableOperation("*a"));
        assertFalse(textRecognizer.isVariableOperation("/a"));
        assertFalse(textRecognizer.isVariableOperation("+"));
        assertFalse(textRecognizer.isVariableOperation("+ -"));
        assertFalse(textRecognizer.isVariableOperation("sqrt"));
        assertFalse(textRecognizer.isVariableOperation("ciao"));
        assertFalse(textRecognizer.isVariableOperation("+--"));
        assertFalse(textRecognizer.isVariableOperation("2+"));
        assertFalse(textRecognizer.isVariableOperation("2+3i"));
    }

    @Test
    public void testIsVariableStorageOperation() {
        // test recognized operations.
        assertTrue(textRecognizer.isVariableStorageOperation("save"));
        assertTrue(textRecognizer.isVariableStorageOperation("restore"));

        // unrecognized operations.
        assertFalse(textRecognizer.isVariableStorageOperation(">a"));
        assertFalse(textRecognizer.isVariableStorageOperation("+a"));
        assertFalse(textRecognizer.isVariableStorageOperation("*a"));
        assertFalse(textRecognizer.isVariableStorageOperation("/a"));
        assertFalse(textRecognizer.isVariableStorageOperation("+"));
        assertFalse(textRecognizer.isVariableStorageOperation("+ -"));
        assertFalse(textRecognizer.isVariableStorageOperation("sqrt"));
        assertFalse(textRecognizer.isVariableStorageOperation("ciao"));
        assertFalse(textRecognizer.isVariableStorageOperation("+--"));
        assertFalse(textRecognizer.isVariableStorageOperation("2+"));
        assertFalse(textRecognizer.isVariableStorageOperation("2+3i"));
    }

    @Test
    public void testIsUserDefinedOperation() {
        UserOperation op = new UserOperation("hello", "+ - +");
        OperationsMap.getInstance().addUserDefinedOperation(op);

        assertTrue(textRecognizer.isUserDefinedOperation("hello"));

        // unrecognized operations.
        assertFalse(textRecognizer.isUserDefinedOperation("HELLO"));
        assertFalse(textRecognizer.isUserDefinedOperation(">a"));
        assertFalse(textRecognizer.isUserDefinedOperation("+a"));
        assertFalse(textRecognizer.isUserDefinedOperation("*a"));
        assertFalse(textRecognizer.isUserDefinedOperation("/a"));
        assertFalse(textRecognizer.isUserDefinedOperation("+"));
        assertFalse(textRecognizer.isUserDefinedOperation("+ -"));
        assertFalse(textRecognizer.isUserDefinedOperation("sqrt"));
        assertFalse(textRecognizer.isUserDefinedOperation("ciao"));
        assertFalse(textRecognizer.isUserDefinedOperation("+--"));
        assertFalse(textRecognizer.isUserDefinedOperation("2+"));
        assertFalse(textRecognizer.isUserDefinedOperation("2+3i"));

        OperationsMap.getInstance().deleteUserDefinedOperation(op);
    }

    @Test
    public void testIsValidUserDefinedOperationName() {
        // only letters are allowed.
        assertTrue(textRecognizer.isValidUserDefinedOperationName("ciao"));
        assertTrue(textRecognizer.isValidUserDefinedOperationName("hypotenuse"));
        assertTrue(textRecognizer.isValidUserDefinedOperationName("myFunc"));
        assertTrue(textRecognizer.isValidUserDefinedOperationName("NEWFUNCTION"));
        assertTrue(textRecognizer.isValidUserDefinedOperationName("new_function"));
        assertTrue(textRecognizer.isValidUserDefinedOperationName("HELLO123"));

        // these names are not allowed since they already exist.
        assertFalse(textRecognizer.isValidUserDefinedOperationName("sqrt"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("clear"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("swap"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("over"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("dup"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("drop"));

        // unrecognized operations.
        assertFalse(textRecognizer.isValidUserDefinedOperationName("23"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("another function new"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("+a"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("*a"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("/a"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("+"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("+ -"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("+--"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("2+"));
        assertFalse(textRecognizer.isValidUserDefinedOperationName("2+3i"));
    }

    @Test
    public void testIsValidUserDefinedOperationSequence() {
        UserOperation op = new UserOperation("hello", "+ - +");
        OperationsMap.getInstance().addUserDefinedOperation(op);

        // only letters are allowed.
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "+ - sqrt +- + + +"));
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "- / * * * save"));
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "restore >a - - +b +b <i"));
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "45+9i >a j >j + - clear"));
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "23 save + - >a drop dup over"));
        // calling other user defined.
        assertTrue(textRecognizer.isValidUserDefinedOperationSequence("name", "save 45 >x +y hello - 0 i"));

        // empty sequence.
        assertFalse(textRecognizer.isValidUserDefinedOperationSequence("name", ""));
        // invalid sequences.
        assertFalse(textRecognizer.isValidUserDefinedOperationSequence("name", "++/-sqrt"));
        assertFalse(textRecognizer.isValidUserDefinedOperationSequence("name", "+-    *  +"));
        // can't call itself.
        assertFalse(textRecognizer.isValidUserDefinedOperationSequence("name", "3 + - / name +"));

        OperationsMap.getInstance().deleteUserDefinedOperation(op);
    }
}
