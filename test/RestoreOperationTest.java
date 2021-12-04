package test;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.variables.RestoreOperation;
import src.main.java.variables.SaveOperation;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file RestoreOperationTest.java
 * @author Marco Plaitano
 * @date 01 Dic 2021
 */

public class RestoreOperationTest {
    private static RestoreOperation restoreOperation;
    private static SaveOperation saveOperation;
    private static Variables variable;
    private static VariablesStack stack;

    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static ComplexNumber number3;
    private static ComplexNumber number4;
    private static ComplexNumber number5;
    private static ComplexNumber number6;

    @BeforeClass
    public static void setUp() {
        restoreOperation = new RestoreOperation();
        saveOperation = new SaveOperation();
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);
        variable = new Variables();
        stack = new VariablesStack();
    }

    @Test
    public void testRestoreOperation() {
        variable.set('a', number0);
        variable.set('b', number1);
        variable.set('c', number2);
        variable.set('d', number3);
        variable.set('e', number4);
        variable.set('f', number5);
        variable.set('g', number6);
        variable.set('h', number0);
        variable.set('i', number1);
        variable.set('j', number2);
        variable.set('k', number3);
        variable.set('l', number4);
        variable.set('m', number5);
        variable.set('n', number6);
        variable.set('o', number0);
        variable.set('p', number1);
        variable.set('q', number2);
        variable.set('r', number3);
        variable.set('s', number4);
        variable.set('t', number5);
        variable.set('u', number6);
        variable.set('v', number0);
        variable.set('w', number1);
        variable.set('x', number2);
        variable.set('y', number3);
        variable.set('z', number4);

        saveOperation.execute(variable, stack);

        // change values for each variable.
        variable.set('a', number1);
        variable.set('b', number2);
        variable.set('c', number3);
        variable.set('d', number4);
        variable.set('e', number5);
        variable.set('f', number6);
        variable.set('g', number0);
        variable.set('h', number1);
        variable.set('i', number2);
        variable.set('j', number3);
        variable.set('k', number4);
        variable.set('l', number5);
        variable.set('m', number6);
        variable.set('n', number0);
        variable.set('o', number1);
        variable.set('p', number2);
        variable.set('q', number3);
        variable.set('r', number4);
        variable.set('s', number5);
        variable.set('t', number6);
        variable.set('u', number0);
        variable.set('v', number1);
        variable.set('w', number2);
        variable.set('x', number3);
        variable.set('y', number4);
        variable.set('z', number5);

        // now restore values and check they are just like they were before.
        restoreOperation.execute(variable, stack);

        assertEquals(number0, variable.get('a'));
        assertEquals(number1, variable.get('b'));
        assertEquals(number2, variable.get('c'));
        assertEquals(number3, variable.get('d'));
        assertEquals(number4, variable.get('e'));
        assertEquals(number5, variable.get('f'));
        assertEquals(number6, variable.get('g'));
        assertEquals(number0, variable.get('h'));
        assertEquals(number1, variable.get('i'));
        assertEquals(number2, variable.get('j'));
        assertEquals(number3, variable.get('k'));
        assertEquals(number4, variable.get('l'));
        assertEquals(number5, variable.get('m'));
        assertEquals(number6, variable.get('n'));
        assertEquals(number0, variable.get('o'));
        assertEquals(number1, variable.get('p'));
        assertEquals(number2, variable.get('q'));
        assertEquals(number3, variable.get('r'));
        assertEquals(number4, variable.get('s'));
        assertEquals(number5, variable.get('t'));
        assertEquals(number6, variable.get('u'));
        assertEquals(number0, variable.get('v'));
        assertEquals(number1, variable.get('w'));
        assertEquals(number2, variable.get('x'));
        assertEquals(number3, variable.get('y'));
        assertEquals(number4, variable.get('z'));

        // assert that the stack is now empty.
        assertTrue(stack.isEmpty('a'));
        assertTrue(stack.isEmpty('b'));
        assertTrue(stack.isEmpty('c'));
        assertTrue(stack.isEmpty('d'));
        assertTrue(stack.isEmpty('e'));
        assertTrue(stack.isEmpty('f'));
        assertTrue(stack.isEmpty('g'));
        assertTrue(stack.isEmpty('h'));
        assertTrue(stack.isEmpty('i'));
        assertTrue(stack.isEmpty('j'));
        assertTrue(stack.isEmpty('k'));
        assertTrue(stack.isEmpty('l'));
        assertTrue(stack.isEmpty('m'));
        assertTrue(stack.isEmpty('n'));
        assertTrue(stack.isEmpty('o'));
        assertTrue(stack.isEmpty('p'));
        assertTrue(stack.isEmpty('q'));
        assertTrue(stack.isEmpty('r'));
        assertTrue(stack.isEmpty('s'));
        assertTrue(stack.isEmpty('t'));
        assertTrue(stack.isEmpty('u'));
        assertTrue(stack.isEmpty('v'));
        assertTrue(stack.isEmpty('w'));
        assertTrue(stack.isEmpty('x'));
        assertTrue(stack.isEmpty('y'));
        assertTrue(stack.isEmpty('z'));
    }
}
