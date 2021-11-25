package test;

import java.util.EmptyStackException;
import org.junit.*;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.MyStack;

import static org.junit.Assert.*;


public class MyStackTest {
    private static final int MAXIMUM_SIZE = 256;
    private static MyStack<ComplexNumber> stack;
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
        stack = new MyStack<>();
    }

    @Test
    public void testIsEmptyTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testPush() {
        stack.push(number0);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testIsEmptyFalse() {
        stack.push(number1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() {
        stack.push(number2);
        assertFalse(stack.isEmpty());
        assertEquals(number2, stack.pop());
    }

    @Test
    public void testTop() {
        stack.push(number3);
        assertFalse(stack.isEmpty());
        assertEquals(number3, stack.top());
    }

    @Test
    public void testIsFullTrue() {
        for (int i = 0; i < MAXIMUM_SIZE; i++)
            stack.push(number4);
        assertTrue(stack.isFull());
    }

    @Test
    public void testIsFullFalse() {
        for (int i = 0; i < MAXIMUM_SIZE - 1; i++)
            stack.push(number0);
        assertFalse(stack.isFull());
    }

    @Test
    public void testClear() {
        for (int i = 0; i < MAXIMUM_SIZE / 2; i++)
            stack.push(number1);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDup() {
        stack.push(number1);
        stack.push(number2);
        stack.dup();
        assertEquals(number2, stack.pop());
        assertEquals(number2, stack.pop());
    }

    @Test
    public void testDrop() {
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);
        assertNotEquals(number2, stack.top());
        assertNotEquals(number3, stack.top());
        assertEquals(number4, stack.top());
        assertEquals(stack.top(), stack.pop());
    }

    @Test
    public void testSwap() {
        stack.push(number4);
        stack.push(number2);
        stack.push(number0);
        stack.push(number1);
        stack.swap();
        assertEquals(number0, stack.pop());
        assertEquals(number1, stack.pop());
    }

    @Test
    public void testOver() {
        stack.push(number2);
        stack.push(number3);
        stack.push(number4);
        stack.over();
        assertEquals(number3, stack.pop());
        assertEquals(number4, stack.pop());
        assertEquals(number3, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnPop() {
        assertTrue(stack.isEmpty());
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnTop() {
        assertTrue(stack.isEmpty());
        stack.top();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnClear() {
        assertTrue(stack.isEmpty());
        stack.clear();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnDrop() {
        assertTrue(stack.isEmpty());
        stack.drop();
    }
}
