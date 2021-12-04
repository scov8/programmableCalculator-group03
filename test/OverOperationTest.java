package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.OverOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file OverOperationTest.java
 * @author Luigi Scovotto
 * @date 30 Nov 2021
 */
public class OverOperationTest {
    private static OverOperation over;
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
        over = new OverOperation();
        stack = new Stack<>();
    }

    @Test
    public void testOverOperation() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        over.execute(stack);
        assertEquals(number1, stack.pop());
        assertEquals(number2, stack.pop());
        assertEquals(number1, stack.pop());
    }

    @Test (expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        stack.push(number0);
        over.execute(stack);
    }
}
