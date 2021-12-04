package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.DropOperation;
import src.main.java.resources.ComplexNumber;

/**
 * @file DropOperationTest.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021
 */
public class DropOperationTest {
    private static DropOperation drop;
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
        drop = new DropOperation();
        stack = new Stack<>();
    }

    @Test
    public void testDropOperation() {
        stack.push(number0);
        stack.push(number1);
        stack.push(number2);
        drop.execute(stack);
        assertEquals(number1, stack.peek());
        drop.execute(stack);
        assertEquals(number0, stack.peek());
        drop.execute(stack);
        assertTrue(stack.empty());
    }

    @Test (expected = NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnExecute() {
        drop.execute(stack);
    }
}
