package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.SwapOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file SwapOperationTest.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021 *
 */
public class SwapOperationTest {
    private static SwapOperation swap;
    private static Stack<ComplexNumber> stack;

    // numbers for which we will perform the operations
    private static ComplexNumber number0; // number with both parts 0
    private static ComplexNumber number1; // number with both parts positive
    private static ComplexNumber number2; // number with both parts negative
    private static ComplexNumber number3; // number with real part positive and imaginary part negative
    private static ComplexNumber number4; // number with real part negative and imaginary part positive

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        number3 = new ComplexNumber(7, -8);
        number4 = new ComplexNumber(-10, 11);
    }
    @Before
    public void initStack() {
        swap = new SwapOperation();
        stack = new Stack<>();
    }

    @Test
    public void testSwap() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        swap.execute(stack);
        assertEquals(number1, stack.pop());
        assertEquals(number2, stack.pop());
        stack.push(number3);
        stack.push(number4);
        swap.execute(stack);
        assertEquals(number3, stack.pop());
        assertEquals(number4, stack.pop());
    }
    @Test (expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.push(number0);
        swap.execute(stack);
    }
}
