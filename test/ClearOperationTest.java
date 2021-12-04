package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.operations.ClearOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file ClearOperationTest.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */

public class ClearOperationTest {
    private static ClearOperation clear;
    private static Stack<ComplexNumber> stack;

    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0, 0);
        number1 = new ComplexNumber(3, 4);
        number2 = new ComplexNumber(-2, -1);
        clear = new ClearOperation();
        stack = new Stack<>();
    }

    @Test
    public void testClearOperation() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        clear.execute(stack);
        assertTrue(stack.empty());

        clear.execute(stack);
        assertTrue(stack.empty());
    }
}
