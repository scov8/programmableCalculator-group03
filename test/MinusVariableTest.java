package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.variables.MinusVariable;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @file MinusVariableTest.java
 * @author Francesco Tortora
 * @date 02 Dic 2021
 */
public class MinusVariableTest {
    private static MinusVariable minusVariable;
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static ComplexNumber number3;
    private static ComplexNumber number4;
    private static ComplexNumber number5;
    private static ComplexNumber number6;

    private static ComplexNumber result30;
    private static ComplexNumber result41;
    private static ComplexNumber result52;
    private static ComplexNumber result63;

    private static Stack<ComplexNumber> stack;
    private static Variables variable;

    @BeforeClass
    public static void setUp() {
        minusVariable = new MinusVariable();
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);
        variable = new Variables();
        stack = new Stack<>();

        result30 = new ComplexNumber(7, -8);
        result41 = new ComplexNumber(-13, 7);
        result52 = new ComplexNumber(10, 1);
        result63 = new ComplexNumber(-7, 4);
    }

    @Test
    public void testMinusVariableTest() {
        stack.push(number3);
        stack.push(number2);
        stack.push(number1);
        stack.push(number0);
        variable.set('a', number3);
        variable.set('b', number4);
        variable.set('c', number5);
        variable.set('d', number6);
        minusVariable.execute(variable, stack, 'a');
        minusVariable.execute(variable, stack, 'b');
        minusVariable.execute(variable, stack, 'c');
        minusVariable.execute(variable, stack, 'd');
        assertEquals(result30, variable.get('a'));
        assertEquals(result41, variable.get('b'));
        assertEquals(result52, variable.get('c'));
        assertEquals(result63, variable.get('d'));
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.clear();
        variable.set('a', number0);
        minusVariable.execute(variable, stack, 'a');
    }

    @Test(expected = VariableWithoutValueException.class)
    public void testVariableWithoutValueExceptionOnExecute() {
        stack.push(number0);
        variable.set('a', null);
        minusVariable.execute(variable, stack, 'a');
    }
}
