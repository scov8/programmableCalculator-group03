package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DifferenceOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to execute the difference between two
 *        complex numbers contained in the stack.
 */
public class DifferenceOperation extends Operation {
    public DifferenceOperation() {
        super(2);
    }

    /**
     * @brief Execute the difference operation on the top two elements of the given
     *        stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber right = stack.pop();
        ComplexNumber left = stack.pop();
        ComplexNumber result = new ComplexNumber(
                left.getReal() - right.getReal(),
                left.getImaginary() - right.getImaginary());
        stack.push(result);
    }

}
