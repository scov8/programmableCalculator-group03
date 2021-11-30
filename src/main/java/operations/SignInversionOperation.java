package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file SignInversionOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to execute the Sign Inversion of a
 *        complex number contained in a stack.
 */
public class SignInversionOperation extends MathOperation {
    public SignInversionOperation() {
        super(1);
    }

    /**
     * @brief Execute the sign inversion operation on the given stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber num = stack.pop();
        ComplexNumber result = new ComplexNumber(-num.getReal(), -num.getImaginary());
        stack.push(result);
    }
}
