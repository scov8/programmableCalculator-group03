package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DivisionOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class DivisionOperation extends MathOperation {
    public DivisionOperation() {
        super(2);
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) throws IndeterminateFormException {
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
