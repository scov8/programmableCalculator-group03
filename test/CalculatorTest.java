/**
 * @file CalculatorTest.java
 * @author Gerardo Rosa
 * @date 27 Nov 2021
 */

package test;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.Operations;
import src.main.java.resources.Calculator;
import src.main.java.resources.ComplexNumber;
public class CalculatorTest {
    private static Calculator c;
    private static Stack<ComplexNumber> stack;

    @BeforeClass
    public static void setUp() {
        c = new Calculator();
        stack = new Stack<>();
    }

    @Before
    public void initStack() {
        stack.push(new ComplexNumber(1, 3.5));
        stack.push(new ComplexNumber(2.4, -8.024));
    }

    @Test
    public void testRunOperationOnNoOperation() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // operation not recognized means no operation gets executed.
        c.runOperation(stack, "hello");
        assertEquals(top, stack.peek());
        assertEquals(size, stack.size());
    }

    @Test
    public void testRunOperationOnSignInversion() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // sign invertion. Top inverts its sign, size does not change.
        c.runOperation(stack, "+-");
        assertEquals(Operations.signInvertion(top), stack.peek());
        assertEquals(size, stack.size());
    }

    @Test
    public void testRunOperationOnSquareRoot() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // square root. Top gets square rooted, size does not change.
        c.runOperation(stack, "sqrt");
        assertEquals(Operations.squareRoot(top), stack.peek());
        assertEquals(size, stack.size());
    }

    @Test
    public void testRunOperationOnSum() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // second to top element of the stack.
        ComplexNumber top2 = stack.elementAt(size - 2);
        // Sum. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "+");
        assertEquals(Operations.sum(top2, top), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnDifference() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // second to top element of the stack.
        ComplexNumber top2 = stack.elementAt(size - 2);
        // Difference. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "-");
        assertEquals(Operations.difference(top2, top), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnMultiplication() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // second to top element of the stack.
        ComplexNumber top2 = stack.elementAt(size - 2);
        // Multiplication. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "*");
        assertEquals(Operations.multiplication(top2, top), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnDivsion() throws Exception {
        int size = stack.size();
        ComplexNumber top = stack.peek();
        // second to top element of the stack.
        ComplexNumber top2 = stack.elementAt(size - 2);
        // Division. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "/");
        assertEquals(Operations.division(top2, top), stack.peek());
        assertEquals(size - 1, stack.size());
    }
    @Test
    public void testNotEnoughOperandsExceptionOnRunOperation() throws Exception {
        // only 1 item in the stack.
        stack.clear();
        stack.push(new ComplexNumber(-2.8, 11));
        assertEquals(1, stack.size());
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "+"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "*"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "/"));

        // no items in the stack.
        stack.clear();
        assertEquals(0, stack.size());

        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "+"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "*"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "/"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "+-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.runOperation(stack, "sqrt"));
    }
}
