package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DifferenceOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class DifferenceOperation extends MathOperation {
    public DifferenceOperation() {
        super(2);
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber right = stack.pop();
        ComplexNumber left = stack.pop();
        ComplexNumber result = new ComplexNumber(
            left.getReal() - right.getReal(),
            left.getImaginary() - right.getImaginary()
        );
        stack.push(result);
    }

}
