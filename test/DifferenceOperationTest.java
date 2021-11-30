package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.DifferenceOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file DifferenceOperationTest.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class DifferenceOperationTest {
    private static DifferenceOperation difference;
    private static Stack<ComplexNumber> stack;

    // numbers for which we will perform the operations
    private static ComplexNumber number0; // number with both parts 0
    private static ComplexNumber number1; // number with both parts positive
    private static ComplexNumber number2; // number with both parts negative
    private static ComplexNumber number3; // number with real part positive and imaginary part negative
    private static ComplexNumber number4; // number with real part negative and imaginary part positive
    private static ComplexNumber number5; // number with only real part
    private static ComplexNumber number6; // number with only imaginary part

    // results of the difference operation
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
    private static ComplexNumber result10; // result of number 1 and 0
    private static ComplexNumber result20; // result of number 2 and 0
    private static ComplexNumber result30; // result of number 3 and 0
    private static ComplexNumber result40; // result of number 4 and 0
    private static ComplexNumber result50; // result of number 5 and 0
    private static ComplexNumber result60; // result of number 6 and 0
    private static ComplexNumber result21; // result of number 2 and 1
    private static ComplexNumber result31; // result of number 3 and 1
    private static ComplexNumber result41; // result of number 4 and 1
    private static ComplexNumber result51; // result of number 5 and 1
    private static ComplexNumber result61; // result of number 6 and 1
    private static ComplexNumber result32; // result of number 3 and 2
    private static ComplexNumber result42; // result of number 4 and 2
    private static ComplexNumber result52; // result of number 5 and 2
    private static ComplexNumber result62; // result of number 6 and 2
    private static ComplexNumber result43; // result of number 4 and 3
    private static ComplexNumber result53; // result of number 5 and 3
    private static ComplexNumber result63; // result of number 6 and 3
    private static ComplexNumber result54; // result of number 5 and 4
    private static ComplexNumber result64; // result of number 6 and 4
    private static ComplexNumber result65; // result of number 6 and 5

    @BeforeClass
    public static void setUp() {
        difference = new DifferenceOperation();
        stack = new Stack<>();

        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);

        result00 = new ComplexNumber(0, 0);
        result01 = new ComplexNumber(-3, -4);
        result02 = new ComplexNumber(2, 1);
        result03 = new ComplexNumber(-7, 8);
        result04 = new ComplexNumber(10, -11);
        result05 = new ComplexNumber(-8, 0);
        result06 = new ComplexNumber(0, 4);
        result11 = new ComplexNumber(0, 0);
        result12 = new ComplexNumber(5, 5);
        result13 = new ComplexNumber(-4, 12);
        result14 = new ComplexNumber(13, -7);
        result15 = new ComplexNumber(-5, 4);
        result16 = new ComplexNumber(3, 8);
        result22 = new ComplexNumber(0, 0);
        result23 = new ComplexNumber(-9, 7);
        result24 = new ComplexNumber(8, -12);
        result25 = new ComplexNumber(-10, -1);
        result26 = new ComplexNumber(-2, 3);
        result33 = new ComplexNumber(0, 0);
        result34 = new ComplexNumber(17, -19);
        result35 = new ComplexNumber(-1, -8);
        result36 = new ComplexNumber(7, -4);
        result44 = new ComplexNumber(0, 0);
        result45 = new ComplexNumber(-18, 11);
        result46 = new ComplexNumber(-10, 15);
        result55 = new ComplexNumber(0, 0);
        result56 = new ComplexNumber(8, 4);
        result66 = new ComplexNumber(0, 0);
        result10 = new ComplexNumber(3, 4);
        result20 = new ComplexNumber(-2, -1);
        result30 = new ComplexNumber(7, -8);
        result40 = new ComplexNumber(-10, 11);
        result50 = new ComplexNumber(8, 0);
        result60 = new ComplexNumber(0, -4);
        result21 = new ComplexNumber(-5, -5);
        result31 = new ComplexNumber(4, -12);
        result41 = new ComplexNumber(-13, 7);
        result51 = new ComplexNumber(5, -4);
        result61 = new ComplexNumber(-3, -8);
        result32 = new ComplexNumber(9, -7);
        result42 = new ComplexNumber(-8, 12);
        result52 = new ComplexNumber(10, 1);
        result62 = new ComplexNumber(2, -3);
        result43 = new ComplexNumber(-17, 19);
        result53 = new ComplexNumber(1, 8);
        result63 = new ComplexNumber(-7, 4);
        result54 = new ComplexNumber(18, -11);
        result64 = new ComplexNumber(10, -15);
        result65 = new ComplexNumber(-8, -4);
    }

    @Test (expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.clear();
        stack.push(number0);
        difference.execute(stack);
    }

    @Test
    public void testExecute() {
        stack.clear();
        stack.push(number0);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result00, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result01, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result02, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result03, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result04, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result05, stack.peek());

        stack.clear();
        stack.push(number0);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result06, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result11, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result12, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result13, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result14, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result15, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result16, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result22, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result23, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result24, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result25, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result26, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result33, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result34, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result35, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result36, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result44, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result45, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result46, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result55, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result56, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number6);
        difference.execute(stack);
        assertEquals(result66, stack.peek());

        stack.clear();
        stack.push(number1);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result10, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result20, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result30, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result40, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result50, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number0);
        difference.execute(stack);
        assertEquals(result60, stack.peek());

        stack.clear();
        stack.push(number2);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result21, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result31, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result41, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result51, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number1);
        difference.execute(stack);
        assertEquals(result61, stack.peek());

        stack.clear();
        stack.push(number3);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result32, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result42, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result52, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number2);
        difference.execute(stack);
        assertEquals(result62, stack.peek());

        stack.clear();
        stack.push(number4);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result43, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result53, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number3);
        difference.execute(stack);
        assertEquals(result63, stack.peek());

        stack.clear();
        stack.push(number5);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result54, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number4);
        difference.execute(stack);
        assertEquals(result64, stack.peek());

        stack.clear();
        stack.push(number6);
        stack.push(number5);
        difference.execute(stack);
        assertEquals(result65, stack.peek());
    }
}
