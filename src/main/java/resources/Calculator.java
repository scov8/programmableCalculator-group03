package src.main.java.resources;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.operations.Operations;

/**
 * @file Calculator.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */
/**
 * @brief This class handles the operation and the operands in the stack.
 *
 */
public class Calculator {

    public Calculator() {

    }
    /**
    * @brief Run the given operation on the elements of the stack.
    * @param stack The stack of complex numbers.
    * @param op Operation to execute.
    *
    */
    public void runOperation(Stack<ComplexNumber> stack, String op) throws Exception {
        ComplexNumber result = null;
        ComplexNumber a, b;

        switch (op) {
            case "+":
                if (stack.size() < 2)
                    throw new NotEnoughOperandsException();
                b = stack.pop();
                a = stack.pop();
                result = Operations.sum(a, b);
                break;
            case "-":
                if (stack.size() < 2)
                    throw new NotEnoughOperandsException();
                b = stack.pop();
                a = stack.pop();
                result = Operations.difference(a, b);
                break;
            case "*":
                if (stack.size() < 2)
                    throw new NotEnoughOperandsException();
                b = stack.pop();
                a = stack.pop();
                result = Operations.multiplication(a, b);
                break;
            case "/":
                if (stack.size() < 2)
                    throw new NotEnoughOperandsException();
                b = stack.pop();
                a = stack.pop();
                result = Operations.division(a, b);
                break;
            case "+-":
                a = stack.pop();
                result = Operations.signInvertion(a);
                break;
            case "sqrt":
                a = stack.pop();
                result = Operations.squareRoot(a);
                break;
            default:
                break;
        }

        if (result != null)
            stack.push(result);
    }
}
