package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.SumOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file SumOperationTest.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class SumOperationTest {
    private static SumOperation sum;
    private static Stack<ComplexNumber> stack;

    // numbers for which we will perform the operations
    private static ComplexNumber number0; // number with both parts 0
    private static ComplexNumber number1; // number with both parts positive
    private static ComplexNumber number2; // number with both parts negative
    private static ComplexNumber number3; // number with real part positive and imaginary part negative
    private static ComplexNumber number4; // number with real part negative and imaginary part positive
    private static ComplexNumber number5; // number with only real part
    private static ComplexNumber number6; // number with only imaginary part

    // results of the sum operation
    private static ComplexNumber result00; // result of number 0 and 0
    private static ComplexNumber result01; // result of number 0 and 1
    private static ComplexNumber result02; // result of number 0 and 2
    private static ComplexNumber result03; // result of number 0 and 3
    private static ComplexNumber result04; // result of number 0 and 4
    private static ComplexNumber result05; // result of number 0 and 5
    private static ComplexNumber result06; // result of number 0 and 6
    private static ComplexNumber result11; // result of number 1 and 1
    private static ComplexNumber result12; // result of number 1 and 2
    private static ComplexNumber result13; // result of number 1 and 3
    private static ComplexNumber result14; // result of number 1 and 4
    private static ComplexNumber result15; // result of number 1 and 5
    private static ComplexNumber result16; // result of number 1 and 6
    private static ComplexNumber result22; // result of number 2 and 2
    private static ComplexNumber result23; // result of number 2 and 3
    private static ComplexNumber result24; // result of number 2 and 4
    private static ComplexNumber result25; // result of number 2 and 5
    private static ComplexNumber result26; // result of number 2 and 6
    private static ComplexNumber result33; // result of number 3 and 3
    private static ComplexNumber result34; // result of number 3 and 4
    private static ComplexNumber result35; // result of number 3 and 5
    private static ComplexNumber result36; // result of number 3 and 6
    private static ComplexNumber result44; // result of number 4 and 4
    private static ComplexNumber result45; // result of number 4 and 5
    private static ComplexNumber result46; // result of number 4 and 6
    private static ComplexNumber result55; // result of number 5 and 5
    private static ComplexNumber result56; // result of number 5 and 6
    private static ComplexNumber result66; // result of number 6 and 6

    @BeforeClass
    public static void setUp() {
        sum = new SumOperation();
        stack = new Stack<>();

        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);

        result00 = new ComplexNumber(0, 0);
        result01 = new ComplexNumber(3, 4);
        result02 = new ComplexNumber(-2, -1);
        result03 = new ComplexNumber(7, -8);
        result04 = new ComplexNumber(-10, 11);
        result05 = new ComplexNumber(8, 0);
        result06 = new ComplexNumber(0, -4);
        result11 = new ComplexNumber(6, 8);
        result12 = new ComplexNumber(1, 3);
        result13 = new ComplexNumber(10, -4);
        result14 = new ComplexNumber(-7, 15);
        result15 = new ComplexNumber(11, 4);
        result16 = new ComplexNumber(3, 0);
        result22 = new ComplexNumber(-4, -2);
        result23 = new ComplexNumber(5, -9);
        result24 = new ComplexNumber(-12, 10);
        result25 = new ComplexNumber(6, -1);
        result26 = new ComplexNumber(-2, -5);
        result33 = new ComplexNumber(14, -16);
        result34 = new ComplexNumber(-3, 3);
        result35 = new ComplexNumber(15, -8);
        result36 = new ComplexNumber(7, -12);
        result44 = new ComplexNumber(-20, 22);
        result45 = new ComplexNumber(-2, 11);
        result46 = new ComplexNumber(-10, 7);
        result55 = new ComplexNumber(16, 0);
        result56 = new ComplexNumber(8, -4);
        result66 = new ComplexNumber(0, -8);
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.clear();
        stack.push(number0);
        sum.execute(stack);
    }

    @Test
    public void testExecute() {
        stack.clear();
        stack.push(number0);
        stack.push(number0);
        sum.execute(stack);
        assertEquals(result00, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number1);
        sum.execute(stack);
        assertEquals(result01, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number2);
        sum.execute(stack);
        assertEquals(result02, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number3);
        sum.execute(stack);
        assertEquals(result03, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number4);
        sum.execute(stack);
        assertEquals(result04, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result05, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result06, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number1);
        sum.execute(stack);
        assertEquals(result11, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number2);
        sum.execute(stack);
        assertEquals(result12, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number3);
        sum.execute(stack);
        assertEquals(result13, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number4);
        sum.execute(stack);
        assertEquals(result14, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result15, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result16, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number2);
        sum.execute(stack);
        assertEquals(result22, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number3);
        sum.execute(stack);
        assertEquals(result23, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number4);
        sum.execute(stack);
        assertEquals(result24, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result25, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result26, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number3);
        sum.execute(stack);
        assertEquals(result33, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number4);
        sum.execute(stack);
        assertEquals(result34, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result35, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result36, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number4);
        sum.execute(stack);
        assertEquals(result44, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result45, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result46, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number5);
        sum.execute(stack);
        assertEquals(result55, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result56, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number6);
        sum.execute(stack);
        assertEquals(result66, stack.peek());
    }
}
