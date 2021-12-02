package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;
import src.main.java.variables.SaveOperation;

import static org.junit.Assert.*;

public class SaveOperationTest {
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static ComplexNumber number3;
    private static ComplexNumber number4;
    private static ComplexNumber number5;
    private static ComplexNumber number6;

    private static Variables variable;
    private static VariablesStack stack;
    private static SaveOperation saveOperation;

    @BeforeClass
    public static void setUp() {
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
    public void testSaveOperation() {
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

        assertEquals(number0, stack.peek('a'));
        assertEquals(number1, stack.peek('b'));
        assertEquals(number2, stack.peek('c'));
        assertEquals(number3, stack.peek('d'));
        assertEquals(number4, stack.peek('e'));
        assertEquals(number5, stack.peek('f'));
        assertEquals(number6, stack.peek('g'));
        assertEquals(number0, stack.peek('h'));
        assertEquals(number1, stack.peek('i'));
        assertEquals(number2, stack.peek('j'));
        assertEquals(number3, stack.peek('k'));
        assertEquals(number4, stack.peek('l'));
        assertEquals(number5, stack.peek('m'));
        assertEquals(number6, stack.peek('n'));
        assertEquals(number0, stack.peek('o'));
        assertEquals(number1, stack.peek('p'));
        assertEquals(number2, stack.peek('q'));
        assertEquals(number3, stack.peek('r'));
        assertEquals(number4, stack.peek('s'));
        assertEquals(number5, stack.peek('t'));
        assertEquals(number6, stack.peek('u'));
        assertEquals(number0, stack.peek('v'));
        assertEquals(number1, stack.peek('w'));
        assertEquals(number2, stack.peek('x'));
        assertEquals(number3, stack.peek('y'));
        assertEquals(number4, stack.peek('z'));

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

        saveOperation.execute(variable, stack);

        assertEquals(number1, stack.peek('a'));
        assertEquals(number2, stack.peek('b'));
        assertEquals(number3, stack.peek('c'));
        assertEquals(number4, stack.peek('d'));
        assertEquals(number5, stack.peek('e'));
        assertEquals(number6, stack.peek('f'));
        assertEquals(number0, stack.peek('g'));
        assertEquals(number1, stack.peek('h'));
        assertEquals(number2, stack.peek('i'));
        assertEquals(number3, stack.peek('j'));
        assertEquals(number4, stack.peek('k'));
        assertEquals(number5, stack.peek('l'));
        assertEquals(number6, stack.peek('m'));
        assertEquals(number0, stack.peek('n'));
        assertEquals(number1, stack.peek('o'));
        assertEquals(number2, stack.peek('p'));
        assertEquals(number3, stack.peek('q'));
        assertEquals(number4, stack.peek('r'));
        assertEquals(number5, stack.peek('s'));
        assertEquals(number6, stack.peek('t'));
        assertEquals(number0, stack.peek('u'));
        assertEquals(number1, stack.peek('v'));
        assertEquals(number2, stack.peek('w'));
        assertEquals(number3, stack.peek('x'));
        assertEquals(number4, stack.peek('y'));
        assertEquals(number5, stack.peek('z'));
    }
}
