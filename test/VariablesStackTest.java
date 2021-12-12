package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.VariablesStack;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * @file VariablesStackTest.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */
public class VariablesStackTest {
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static VariablesStack variables;

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        variables = new VariablesStack();
    }

    @Test
    public void testAddNumbersToAllStacks() {
        variables.push('a', number0);
        variables.push('a', number1);
        assertEquals(number1, variables.pop('a'));
        variables.push('a', number2);
        assertEquals(number2, variables.pop('a'));
        assertEquals(number0, variables.pop('a'));

        variables.push('b', number0);
        variables.push('b', number1);
        assertEquals(number1, variables.pop('b'));
        variables.push('b', number2);
        assertEquals(number2, variables.pop('b'));
        assertEquals(number0, variables.pop('b'));

        variables.push('c', number0);
        variables.push('c', number1);
        assertEquals(number1, variables.pop('c'));
        variables.push('c', number2);
        assertEquals(number2, variables.pop('c'));
        assertEquals(number0, variables.pop('c'));

        variables.push('d', number0);
        variables.push('d', number1);
        assertEquals(number1, variables.pop('d'));
        variables.push('d', number2);
        assertEquals(number2, variables.pop('d'));
        assertEquals(number0, variables.pop('d'));

        variables.push('e', number0);
        variables.push('e', number1);
        assertEquals(number1, variables.pop('e'));
        variables.push('e', number2);
        assertEquals(number2, variables.pop('e'));
        assertEquals(number0, variables.pop('e'));

        variables.push('f', number0);
        variables.push('f', number1);
        assertEquals(number1, variables.pop('f'));
        variables.push('f', number2);
        assertEquals(number2, variables.pop('f'));
        assertEquals(number0, variables.pop('f'));

        variables.push('g', number0);
        variables.push('g', number1);
        assertEquals(number1, variables.pop('g'));
        variables.push('g', number2);
        assertEquals(number2, variables.pop('g'));
        assertEquals(number0, variables.pop('g'));

        variables.push('h', number0);
        variables.push('h', number1);
        assertEquals(number1, variables.pop('h'));
        variables.push('h', number2);
        assertEquals(number2, variables.pop('h'));
        assertEquals(number0, variables.pop('h'));

        variables.push('i', number0);
        variables.push('i', number1);
        assertEquals(number1, variables.pop('i'));
        variables.push('i', number2);
        assertEquals(number2, variables.pop('i'));
        assertEquals(number0, variables.pop('i'));

        variables.push('j', number0);
        variables.push('j', number1);
        assertEquals(number1, variables.pop('j'));
        variables.push('j', number2);
        assertEquals(number2, variables.pop('j'));
        assertEquals(number0, variables.pop('j'));

        variables.push('k', number0);
        variables.push('k', number1);
        assertEquals(number1, variables.pop('k'));
        variables.push('k', number2);
        assertEquals(number2, variables.pop('k'));
        assertEquals(number0, variables.pop('k'));

        variables.push('l', number0);
        variables.push('l', number1);
        assertEquals(number1, variables.pop('l'));
        variables.push('l', number2);
        assertEquals(number2, variables.pop('l'));
        assertEquals(number0, variables.pop('l'));

        variables.push('m', number0);
        variables.push('m', number1);
        assertEquals(number1, variables.pop('m'));
        variables.push('m', number2);
        assertEquals(number2, variables.pop('m'));
        assertEquals(number0, variables.pop('m'));

        variables.push('n', number0);
        variables.push('n', number1);
        assertEquals(number1, variables.pop('n'));
        variables.push('n', number2);
        assertEquals(number2, variables.pop('n'));
        assertEquals(number0, variables.pop('n'));

        variables.push('o', number0);
        variables.push('o', number1);
        assertEquals(number1, variables.pop('o'));
        variables.push('o', number2);
        assertEquals(number2, variables.pop('o'));
        assertEquals(number0, variables.pop('o'));

        variables.push('p', number0);
        variables.push('p', number1);
        assertEquals(number1, variables.pop('p'));
        variables.push('p', number2);
        assertEquals(number2, variables.pop('p'));
        assertEquals(number0, variables.pop('p'));

        variables.push('q', number0);
        variables.push('q', number1);
        assertEquals(number1, variables.pop('q'));
        variables.push('q', number2);
        assertEquals(number2, variables.pop('q'));
        assertEquals(number0, variables.pop('q'));

        variables.push('r', number0);
        variables.push('r', number1);
        assertEquals(number1, variables.pop('r'));
        variables.push('r', number2);
        assertEquals(number2, variables.pop('r'));
        assertEquals(number0, variables.pop('r'));

        variables.push('s', number0);
        variables.push('s', number1);
        assertEquals(number1, variables.pop('s'));
        variables.push('s', number2);
        assertEquals(number2, variables.pop('s'));
        assertEquals(number0, variables.pop('s'));

        variables.push('t', number0);
        variables.push('t', number1);
        assertEquals(number1, variables.pop('t'));
        variables.push('t', number2);
        assertEquals(number2, variables.pop('t'));
        assertEquals(number0, variables.pop('t'));

        variables.push('u', number0);
        variables.push('u', number1);
        assertEquals(number1, variables.pop('u'));
        variables.push('u', number2);
        assertEquals(number2, variables.pop('u'));
        assertEquals(number0, variables.pop('u'));

        variables.push('v', number0);
        variables.push('v', number1);
        assertEquals(number1, variables.pop('v'));
        variables.push('v', number2);
        assertEquals(number2, variables.pop('v'));
        assertEquals(number0, variables.pop('v'));

        variables.push('w', number0);
        variables.push('w', number1);
        assertEquals(number1, variables.pop('w'));
        variables.push('w', number2);
        assertEquals(number2, variables.pop('w'));
        assertEquals(number0, variables.pop('w'));

        variables.push('x', number0);
        variables.push('x', number1);
        assertEquals(number1, variables.pop('x'));
        variables.push('x', number2);
        assertEquals(number2, variables.pop('x'));
        assertEquals(number0, variables.pop('x'));

        variables.push('y', number0);
        variables.push('y', number1);
        assertEquals(number1, variables.pop('y'));
        variables.push('y', number2);
        assertEquals(number2, variables.pop('y'));
        assertEquals(number0, variables.pop('y'));

        variables.push('z', number0);
        variables.push('z', number1);
        assertEquals(number1, variables.pop('z'));
        variables.push('z', number2);
        assertEquals(number2, variables.pop('z'));
        assertEquals(number0, variables.pop('z'));
    }

    @Test
    public void testClearAll() {
        variables.push('a', number0);
        variables.push('b', number1);
        variables.push('c', number2);
        variables.push('d', number0);
        variables.push('e', number1);
        variables.push('f', number2);
        variables.push('g', number0);
        variables.push('h', number1);
        variables.push('i', number2);
        variables.push('j', number0);
        variables.push('k', number1);
        variables.push('l', number2);
        variables.push('m', number0);
        variables.push('n', number1);
        variables.push('o', number2);
        variables.push('p', number0);
        variables.push('q', number1);
        variables.push('r', number2);
        variables.push('s', number0);
        variables.push('t', number1);
        variables.push('u', number2);
        variables.push('v', number0);
        variables.push('w', number1);
        variables.push('x', number2);
        variables.push('y', number0);
        variables.push('z', number1);

        variables.clearAll();

        assertThrows(EmptyStackException.class, () -> variables.peek('a'));
        assertThrows(EmptyStackException.class, () -> variables.peek('b'));
        assertThrows(EmptyStackException.class, () -> variables.peek('c'));
        assertThrows(EmptyStackException.class, () -> variables.peek('d'));
        assertThrows(EmptyStackException.class, () -> variables.peek('e'));
        assertThrows(EmptyStackException.class, () -> variables.peek('f'));
        assertThrows(EmptyStackException.class, () -> variables.peek('g'));
        assertThrows(EmptyStackException.class, () -> variables.peek('h'));
        assertThrows(EmptyStackException.class, () -> variables.peek('i'));
        assertThrows(EmptyStackException.class, () -> variables.peek('j'));
        assertThrows(EmptyStackException.class, () -> variables.peek('k'));
        assertThrows(EmptyStackException.class, () -> variables.peek('l'));
        assertThrows(EmptyStackException.class, () -> variables.peek('m'));
        assertThrows(EmptyStackException.class, () -> variables.peek('n'));
        assertThrows(EmptyStackException.class, () -> variables.peek('o'));
        assertThrows(EmptyStackException.class, () -> variables.peek('p'));
        assertThrows(EmptyStackException.class, () -> variables.peek('q'));
        assertThrows(EmptyStackException.class, () -> variables.peek('r'));
        assertThrows(EmptyStackException.class, () -> variables.peek('s'));
        assertThrows(EmptyStackException.class, () -> variables.peek('t'));
        assertThrows(EmptyStackException.class, () -> variables.peek('u'));
        assertThrows(EmptyStackException.class, () -> variables.peek('v'));
        assertThrows(EmptyStackException.class, () -> variables.peek('w'));
        assertThrows(EmptyStackException.class, () -> variables.peek('x'));
        assertThrows(EmptyStackException.class, () -> variables.peek('y'));
        assertThrows(EmptyStackException.class, () -> variables.peek('z'));
    }

    @Test(expected = EmptyStackException.class)
    public void testClear() {
        variables.push('a', number0);

        variables.clear('a');

        variables.peek('a');
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackException() {
        variables.clearAll();
        variables.pop('a');
    }
}
