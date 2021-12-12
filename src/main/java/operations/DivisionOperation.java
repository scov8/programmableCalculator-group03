package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DivisionOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to execute the division of two complex
 *        numbers contained in the stack.
 */
public class DivisionOperation extends Operation {
    public DivisionOperation() {
        super(2);
    }

    /**
     * @brief Execute the division operation on the given stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     * @throws IndeterminateFormException if the division results in an
     *                                    indeterminate form.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack)
            throws NotEnoughOperandsException, IndeterminateFormException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber right = stack.pop();
        ComplexNumber left = stack.pop();
        ComplexNumber result;

        double denominator = Math.pow(right.getReal(), 2) + Math.pow(right.getImaginary(), 2);
        double numeratorA = left.getReal() * right.getReal() +
                left.getImaginary() * right.getImaginary();
        double numeratorB = left.getImaginary() * right.getReal() -
                left.getReal() * right.getImaginary();

        if (denominator == 0) {
            if (left.getReal() == 0 && left.getImaginary() == 0)
                throw new IndeterminateFormException();
            else if (left.getImaginary() == 0)
                result = new ComplexNumber(Double.POSITIVE_INFINITY, 0);
            else if (left.getReal() == 0)
                result = new ComplexNumber(0, Double.POSITIVE_INFINITY);
            else
                result = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        } else {
            result = new ComplexNumber(numeratorA / denominator, numeratorB / denominator);
        }

        stack.push(result);
    }
}
