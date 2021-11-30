package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file MultiplicationOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class MultiplicationOperation extends MathOperation {
    public MultiplicationOperation() {
        super(2);
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber right = stack.pop();
        ComplexNumber left = stack.pop();
        ComplexNumber result = new ComplexNumber(
            left.getReal() * right.getReal() - left.getImaginary() * right.getImaginary(),
            left.getImaginary() * right.getReal() + left.getReal() * right.getImaginary()
        );
        stack.push(result);
    }

}
