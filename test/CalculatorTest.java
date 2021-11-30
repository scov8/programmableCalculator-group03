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
import src.main.java.exceptions.UnrecognizedOperationException;
import src.main.java.operations.DifferenceOperation;
import src.main.java.operations.DivisionOperation;
import src.main.java.operations.MultiplicationOperation;
import src.main.java.operations.SignInversionOperation;
import src.main.java.operations.SquareRootOperation;
import src.main.java.operations.SumOperation;
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

    @Test (expected = UnrecognizedOperationException.class)
    public void testRunOperationOnNoOperation() throws Exception {
        c.runOperation(stack, "hello");
    }

    @Test
    public void testRunOperationOnSignInversion() throws Exception {
        int size = stack.size();
        SignInversionOperation operation = new SignInversionOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // sign invertion. Top inverts its sign, size does not change.
        c.runOperation(stack, "+-");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
        assertEquals(size, stack.size());
    }

    @Test
    public void testRunOperationOnSquareRoot() throws Exception {
        int size = stack.size();
        SquareRootOperation operation = new SquareRootOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // square root. Top gets square rooted, size does not change.
        c.runOperation(stack, "sqrt");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
        assertEquals(size, stack.size());
    }

    @Test
    public void testRunOperationOnSum() throws Exception {
        int size = stack.size();
        SumOperation operation = new SumOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // Sum. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "+");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnDifference() throws Exception {
        int size = stack.size();
        DifferenceOperation operation = new DifferenceOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // Difference. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "-");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnMultiplication() throws Exception {
        int size = stack.size();
        MultiplicationOperation operation = new MultiplicationOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // Multiplication. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "*");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
        assertEquals(size - 1, stack.size());
    }

    @Test
    public void testRunOperationOnDivision() throws Exception {
        int size = stack.size();
        DivisionOperation operation = new DivisionOperation();
        Stack<ComplexNumber> stack2 = new Stack<>();
        stack2.addAll(stack);
        // Division. Top 2 elements are removed and result pushed to the stack.
        c.runOperation(stack, "/");
        operation.execute(stack2);
        assertEquals(stack2.peek(), stack.peek());
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
