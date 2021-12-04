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
 * @date 30 Nov 2021
 */
public class SwapOperationTest {
    private static SwapOperation swap;
    private static Stack<ComplexNumber> stack;

    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
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
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.push(number0);
        swap.execute(stack);
    }
}
