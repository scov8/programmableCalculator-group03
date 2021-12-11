package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.variables.SaveIntoStack;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @file SaveIntoStackTest.java
 * @author Francesco Tortora
 * @date 02 Dic 2021
 */
public class SaveIntoStackTest {
    private static SaveIntoStack saveIntoStack;
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static ComplexNumber number3;
    private static ComplexNumber number4;
    private static ComplexNumber number5;
    private static ComplexNumber number6;
    private static Stack<ComplexNumber> stack;
    private static Variables variable;

    @BeforeClass
    public static void setUp() {
        saveIntoStack = new SaveIntoStack();
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);
        variable = new Variables();
        stack = new Stack<>();
    }

    @Test
    public void testSaveIntoStack() {
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

        saveIntoStack.execute(variable, stack, 'a');
        saveIntoStack.execute(variable, stack, 'b');
        saveIntoStack.execute(variable, stack, 'c');
        saveIntoStack.execute(variable, stack, 'd');
        saveIntoStack.execute(variable, stack, 'e');
        saveIntoStack.execute(variable, stack, 'f');
        saveIntoStack.execute(variable, stack, 'g');
        saveIntoStack.execute(variable, stack, 'h');
        saveIntoStack.execute(variable, stack, 'i');
        saveIntoStack.execute(variable, stack, 'j');
        saveIntoStack.execute(variable, stack, 'k');
        saveIntoStack.execute(variable, stack, 'l');
        saveIntoStack.execute(variable, stack, 'm');
        saveIntoStack.execute(variable, stack, 'n');
        saveIntoStack.execute(variable, stack, 'o');
        saveIntoStack.execute(variable, stack, 'p');
        saveIntoStack.execute(variable, stack, 'q');
        saveIntoStack.execute(variable, stack, 'r');
        saveIntoStack.execute(variable, stack, 's');
        saveIntoStack.execute(variable, stack, 't');
        saveIntoStack.execute(variable, stack, 'u');
        saveIntoStack.execute(variable, stack, 'v');
        saveIntoStack.execute(variable, stack, 'w');
        saveIntoStack.execute(variable, stack, 'x');
        saveIntoStack.execute(variable, stack, 'y');
        saveIntoStack.execute(variable, stack, 'z');

        assertEquals(number4, stack.pop());
        assertEquals(number3, stack.pop());
        assertEquals(number2, stack.pop());
        assertEquals(number1, stack.pop());
        assertEquals(number0, stack.pop());
        assertEquals(number6, stack.pop());
        assertEquals(number5, stack.pop());
        assertEquals(number4, stack.pop());
        assertEquals(number3, stack.pop());
        assertEquals(number2, stack.pop());
        assertEquals(number1, stack.pop());
        assertEquals(number0, stack.pop());
        assertEquals(number6, stack.pop());
        assertEquals(number5, stack.pop());
        assertEquals(number4, stack.pop());
        assertEquals(number3, stack.pop());
        assertEquals(number2, stack.pop());
        assertEquals(number1, stack.pop());
        assertEquals(number0, stack.pop());
        assertEquals(number6, stack.pop());
        assertEquals(number5, stack.pop());
        assertEquals(number4, stack.pop());
        assertEquals(number3, stack.pop());
        assertEquals(number2, stack.pop());
        assertEquals(number1, stack.pop());
        assertEquals(number0, stack.pop());
    }

    @Test(expected = VariableWithoutValueException.class)
    public void testVariableWithoutValueExceptionOnExecute() {
        variable.set('a', null);
        saveIntoStack.execute(variable, stack, 'a');
    }
}
