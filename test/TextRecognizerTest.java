package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.resources.TextRecognizer;
import src.main.java.userOperations.UserOperation;
import src.main.java.operations.OperationsMap;

/**
 * @file TextRecognizerTest.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */
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
    public void testIsComplexNumber() {
        // default cases with both positive and negative values for real and
        // imaginary part of the number.
        assertTrue(textRecognizer.isComplexNumber("2+5i"));
        assertTrue(textRecognizer.isComplexNumber("-10+5j"));
        assertTrue(textRecognizer.isComplexNumber("-10-25i"));

        assertTrue(textRecognizer.isComplexNumber("+123-7i"));
        assertTrue(textRecognizer.isComplexNumber("12.3-7.3j"));
        assertTrue(textRecognizer.isComplexNumber("-12.3-7.3i"));
        assertTrue(textRecognizer.isComplexNumber("2+i"));
        assertTrue(textRecognizer.isComplexNumber("2-i"));

        // at least one of the two parts is null.
        assertTrue(textRecognizer.isComplexNumber("0+0i"));
        assertTrue(textRecognizer.isComplexNumber("0"));
        assertTrue(textRecognizer.isComplexNumber("0j"));
        assertTrue(textRecognizer.isComplexNumber("0i"));
        assertTrue(textRecognizer.isComplexNumber("3"));
        assertTrue(textRecognizer.isComplexNumber("+3"));
        assertTrue(textRecognizer.isComplexNumber("-3"));
        assertTrue(textRecognizer.isComplexNumber("12.05i"));
        assertTrue(textRecognizer.isComplexNumber("+12.05i"));
        assertTrue(textRecognizer.isComplexNumber("-12.05i"));

        // string only contains imaginary letter.
        assertTrue(textRecognizer.isComplexNumber("i"));
        assertTrue(textRecognizer.isComplexNumber("j"));

        // number written with spaces is not recognized.
        assertFalse(textRecognizer.isComplexNumber("2 + 3i"));
        assertFalse(textRecognizer.isComplexNumber("2+3 i"));
        assertFalse(textRecognizer.isComplexNumber("- 2 + 3 i"));

        // double number written with ','.
        assertFalse(textRecognizer.isComplexNumber("1+2,5i"));

        // unrecognized input.
        assertFalse(textRecognizer.isComplexNumber("12a"));
        assertFalse(textRecognizer.isComplexNumber("3I"));
        assertFalse(textRecognizer.isComplexNumber("4-50J"));
        assertFalse(textRecognizer.isComplexNumber("hello world"));
        assertFalse(textRecognizer.isComplexNumber("3 + 2"));
        assertFalse(textRecognizer.isComplexNumber("3 +- 2"));
        assertFalse(textRecognizer.isComplexNumber("3 +- 2i"));
        assertFalse(textRecognizer.isComplexNumber("-3 -+ 212i"));
        assertFalse(textRecognizer.isComplexNumber("3a + 212i"));
        assertFalse(textRecognizer.isComplexNumber("a2 + 212i"));
        assertFalse(textRecognizer.isComplexNumber("ai"));
        assertFalse(textRecognizer.isComplexNumber("I"));
        assertFalse(textRecognizer.isComplexNumber("J"));
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
