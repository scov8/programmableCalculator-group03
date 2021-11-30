package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.operations.SignInversionOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file SignInversionOperationTest.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class SignInversionOperationTest {
    private static SignInversionOperation signInversion;
    private static Stack<ComplexNumber> stack;

    // numbers for which we will perform the operations
    private static ComplexNumber number0; // number with both parts 0
    private static ComplexNumber number1; // number with both parts positive
    private static ComplexNumber number2; // number with both parts negative
    private static ComplexNumber number3; // number with real part positive and imaginary part negative
    private static ComplexNumber number4; // number with real part negative and imaginary part positive
    private static ComplexNumber number5; // number with only real part
    private static ComplexNumber number6; // number with only imaginary part

    // results of the square root operation
    private static ComplexNumber result0; // sign inversion of number 0
    private static ComplexNumber result1; // sign inversion of number 1
    private static ComplexNumber result2; // sign inversion of number 2
    private static ComplexNumber result3; // sign inversion of number 3
    private static ComplexNumber result4; // sign inversion of number 4
    private static ComplexNumber result5; // sign inversion of number 5
    private static ComplexNumber result6; // sign inversion of number 6

    @BeforeClass
    public static void setUp() {
        signInversion = new SignInversionOperation();
        stack = new Stack<>();

        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
        number5 = new ComplexNumber(8, 0);
        number6 = new ComplexNumber(0, -4);

        result0 = new ComplexNumber(0,0);
        result1 = new ComplexNumber(-3,-4);
        result2 = new ComplexNumber(2,1);
        result3 = new ComplexNumber(-7,8);
        result4 = new ComplexNumber(10,-11);
        result5 = new ComplexNumber(-8,0);
        result6 = new ComplexNumber(0,4);
    }

    @Test
    public void testExecute() {
        stack.clear();
        stack.push(number0);
        signInversion.execute(stack);
        assertEquals(result0, stack.peek());

        stack.clear();
        stack.push(number1);
        signInversion.execute(stack);
        assertEquals(result1, stack.peek());

        stack.clear();
        stack.push(number2);
        signInversion.execute(stack);
        assertEquals(result2, stack.peek());

        stack.clear();
        stack.push(number3);
        signInversion.execute(stack);
        assertEquals(result3, stack.peek());

        stack.clear();
        stack.push(number4);
        signInversion.execute(stack);
        assertEquals(result4, stack.peek());

        stack.clear();
        stack.push(number5);
        signInversion.execute(stack);
        assertEquals(result5, stack.peek());

        stack.clear();
        stack.push(number6);
        signInversion.execute(stack);
        assertEquals(result6, stack.peek());
    }
}
