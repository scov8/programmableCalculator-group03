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
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        dup.execute(stack);
    }
}
