package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.DupOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file DupOperationTest.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */
public class DupOperationTest {
    private static DupOperation dup;
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
        dup = new DupOperation();
        stack = new Stack<>();
    }

    @Test
    public void testDupOperation() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        dup.execute(stack);
        assertEquals(number2, stack.pop());
        assertEquals(number2, stack.pop());
        stack.push(number3);
        stack.push(number4);
        dup.execute(stack);
        assertEquals(number4, stack.pop());
        assertEquals(number4, stack.pop());
    }

    @Test (expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        dup.execute(stack);
    }


}
