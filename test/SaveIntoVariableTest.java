package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.variables.SaveIntoVariable;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @file SaveIntoVariableTest.java
 * @author Luigi Scovotto
 * @date 01 Dic 2021
 */

public class SaveIntoVariableTest {
    private static SaveIntoVariable saveIntoVariable;
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
        saveIntoVariable = new SaveIntoVariable();
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
    public void testSaveIntoVariable() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);
        stack.push(number5);
        stack.push(number6);
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);
        stack.push(number5);
        stack.push(number6);
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);
        stack.push(number5);
        stack.push(number6);
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);

        saveIntoVariable.execute(variable, stack, 'a');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'b');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'c');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'd');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'e');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'f');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'g');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'h');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'i');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'j');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'k');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'l');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'm');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'n');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'o');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'p');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'q');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'r');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 's');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 't');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'u');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'v');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'w');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'x');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'y');
        stack.pop();
        saveIntoVariable.execute(variable, stack, 'z');

        assertEquals(number4, variable.get('a'));
        assertEquals(number3, variable.get('b'));
        assertEquals(number2, variable.get('c'));
        assertEquals(number1, variable.get('d'));
        assertEquals(number0, variable.get('e'));
        assertEquals(number6, variable.get('f'));
        assertEquals(number5, variable.get('g'));
        assertEquals(number4, variable.get('h'));
        assertEquals(number3, variable.get('i'));
        assertEquals(number2, variable.get('j'));
        assertEquals(number1, variable.get('k'));
        assertEquals(number0, variable.get('l'));
        assertEquals(number6, variable.get('m'));
        assertEquals(number5, variable.get('n'));
        assertEquals(number4, variable.get('o'));
        assertEquals(number3, variable.get('p'));
        assertEquals(number2, variable.get('q'));
        assertEquals(number1, variable.get('r'));
        assertEquals(number0, variable.get('s'));
        assertEquals(number6, variable.get('t'));
        assertEquals(number5, variable.get('u'));
        assertEquals(number4, variable.get('v'));
        assertEquals(number3, variable.get('w'));
        assertEquals(number2, variable.get('x'));
        assertEquals(number1, variable.get('y'));
        assertEquals(number0, variable.get('z'));
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.clear();
        saveIntoVariable.execute(variable, stack, 'a');
    }
}
