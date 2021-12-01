package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

import static org.junit.Assert.*;

public class VariablesTest {
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static ComplexNumber number3;
    private static ComplexNumber number4;
    private static ComplexNumber number5;
    private static ComplexNumber number6;

    private static Variables variable;

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);
        variable = new Variables();
    }

    @Test
    public void testGetSet() {
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
    }

    @Test
    public void testUpdate() {
        variable.set('a', number0);
        assertEquals(number0, variable.get('a'));
        variable.set('a', number1);
        assertEquals(number1, variable.get('a'));
        variable.set('a', number2);
        assertEquals(number2, variable.get('a'));
        variable.set('a', number3);
        assertEquals(number3, variable.get('a'));
        variable.set('a', number4);
        assertEquals(number4, variable.get('a'));
        variable.set('a', number5);
        assertEquals(number5, variable.get('a'));
        variable.set('a', number6);
        assertEquals(number6, variable.get('a'));
    }

}
