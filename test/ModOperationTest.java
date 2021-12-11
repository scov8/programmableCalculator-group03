package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.ModOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file ModOperationTest.java
 * @author Francesco Tortora
 * @date 10 Dec 2021
 */

public class ModOperationTest {
    private static ModOperation mod;
    private static Stack<ComplexNumber> stack;

    // numbers for which we will perform the operations
    private static ComplexNumber number0; // number with both parts 0
    private static ComplexNumber number1; // number with both parts positive
    private static ComplexNumber number2; // number with both parts negative
    private static ComplexNumber number3; // number with real part positive and imaginary part negative
    private static ComplexNumber number4; // number with real part negative and imaginary part positive
    private static ComplexNumber number5; // number with only real part
    private static ComplexNumber number6; // number with only imaginary part

    // results of the mod operation
    private static ComplexNumber result0; // mod of number 0
    private static ComplexNumber result1; // mod of number 1
    private static ComplexNumber result2; // mod of number 2
    private static ComplexNumber result3; // mod of number 3
    private static ComplexNumber result4; // mod of number 4
    private static ComplexNumber result5; // mod of number 5
    private static ComplexNumber result6; // mod of number 6

    @BeforeClass
    public static void setUp() {
        mod = new ModOperation();
        stack = new Stack<>();

        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);

        result0 = new ComplexNumber(0, 0);
        result1 = new ComplexNumber(5, 0);
        result2 = new ComplexNumber(2.236067977499790, 0);
        result3 = new ComplexNumber(10.630145812734650, 0);
        result4 = new ComplexNumber(14.866068747318506, 0);
        result5 = new ComplexNumber(8, 0);
        result6 = new ComplexNumber(4, 0);
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.clear();
        mod.execute(stack);
    }

    @Test
    public void testExecute() {
        stack.clear();
        stack.push(number0);
        mod.execute(stack);
        assertEquals(result0, stack.peek());

        stack.clear();
        stack.push(number1);
        mod.execute(stack);
        assertEquals(result1, stack.peek());

        stack.clear();
        stack.push(number2);
        mod.execute(stack);
        assertEquals(result2, stack.peek());

        stack.clear();
        stack.push(number3);
        mod.execute(stack);
        assertEquals(result3, stack.peek());

        stack.clear();
        stack.push(number4);
        mod.execute(stack);
        assertEquals(result4, stack.peek());

        stack.clear();
        stack.push(number5);
        mod.execute(stack);
        assertEquals(result5, stack.peek());

        stack.clear();
        stack.push(number6);
        mod.execute(stack);
        assertEquals(result6, stack.peek());
    }
}
