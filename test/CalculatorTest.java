/**
 * @file CalculatorTest.java
 * @author Gerardo Rosa
 * @date 27 Nov 2021
 */

package test;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedInputException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.exceptions.UserOperationExecutionException;
import src.main.java.operations.OperationsMap;
import src.main.java.resources.Calculator;
import src.main.java.resources.ComplexNumber;
import src.main.java.userOperations.UserOperation;

public class CalculatorTest {
    private static Calculator c;
    private static List<ComplexNumber> list;
    private static ComplexNumber a;
    private static ComplexNumber b;

    @BeforeClass
    public static void setUp() {
        c = new Calculator();
        list = new LinkedList<>();
        a = new ComplexNumber(1, 3.5);
        b = new ComplexNumber(2.4, -8.024);
    }

    @Before
    public void initStack() {
        c.run("1+3.5i");
        c.run("2.4-8.024i");
    }

    @Test
    public void testGetTopKNumbers() {
        list = c.getTopKNumbers(2);
        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
    }

    @Test
    public void testRunOperationOnStackOperation() throws Exception {
        ComplexNumber number = new ComplexNumber(-2.4, +8.024);
        // sign invertion. Top inverts its sign, size does not change.
        c.run("+-");
        list = c.getTopKNumbers(1);
        assertEquals(number, list.get(0));
    }

    @Test
    public void testRunOperationOnVariables() throws Exception {
        c.run(">a");
        assertEquals(b, c.getVariable('a'));
        c.run("drop");
        c.run(">b");
        assertEquals(a, c.getVariable('b'));
        c.run("clear");
        c.run("<b");
        list = c.getTopKNumbers(1);
        assertEquals(a, list.get(0));
    }

    @Test
    public void testRunOperationOnUserDefined() throws Exception {
        c.run("1+j");
        UserOperation op = new UserOperation("hello", "+ -");
        OperationsMap map = OperationsMap.getInstance();
        map.addUserDefinedOperation(op);
        c.run("hello");
        list = c.getTopKNumbers(1);
        ComplexNumber x = new ComplexNumber(-2.4, 10.524);
        assertEquals(x, list.get(0));
    }

    @Test
    public void testUnrecognizedInputException() throws Exception {

        assertThrows(UnrecognizedInputException.class, () -> c.run("blablabla"));
        assertThrows(UnrecognizedInputException.class, () -> c.run("topolino"));
        assertThrows(UnrecognizedInputException.class, () -> c.run("pippo"));
        assertThrows(UnrecognizedInputException.class, () -> c.run("pluto"));
        assertThrows(UnrecognizedInputException.class, () -> c.run("franco126"));
    }

    @Test
    public void testNotEnoughOperandsException() throws Exception {
        c.run("clear");
        c.run("1+3i");
        // only 1 item in the stack.
        assertThrows(NotEnoughOperandsException.class, () -> c.run("+"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("*"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("/"));

        // no items in the stack.
        c.run("clear");

        assertThrows(NotEnoughOperandsException.class, () -> c.run("+"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("*"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("/"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("+-"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("sqrt"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("drop"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("dup"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("swap"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run("over"));
        assertThrows(NotEnoughOperandsException.class, () -> c.run(">a"));
    }

    @Test
    public void testIndeterminateFormException() throws Exception {
        c.run("0");
        c.run("0");
        assertThrows(IndeterminateFormException.class, () -> c.run("/"));
    }

    @Test
    public void testVariableWithoutValueException() throws Exception {
        assertThrows(VariableWithoutValueException.class, () -> c.run("<d"));
        assertThrows(VariableWithoutValueException.class, () -> c.run("+e"));
        assertThrows(VariableWithoutValueException.class, () -> c.run("-f"));
    }

    @Test
    public void testUserOperationExecutionException() throws Exception {
        c.run("clear");
        c.run("1+3i");
        c.run("4-2i");
        UserOperation op = new UserOperation("hello", "+ - * /");
        OperationsMap map = OperationsMap.getInstance();
        map.addUserDefinedOperation(op);
        assertThrows(UserOperationExecutionException.class, () -> c.run("hello"));
    }
}
