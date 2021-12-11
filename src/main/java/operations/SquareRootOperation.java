package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file SquareRootOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to execute the Square Root of a complex
 *        number contained in a stack.
 */
public class SquareRootOperation extends Operation {
    public SquareRootOperation() {
        super(1);
    }

    /**
     * @brief Execute the square root operation on the given stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber num = stack.peek();
        ModOperation modOp = new ModOperation();
        modOp.execute(stack);
        ComplexNumber mod = stack.pop();

        double r = Math.sqrt(mod.getReal());
        double theta = Math.atan2(num.getImaginary(), num.getReal()) / 2;
        ComplexNumber result = new ComplexNumber(r * Math.cos(theta), r * Math.sin(theta));
        stack.push(result);
    }
}
