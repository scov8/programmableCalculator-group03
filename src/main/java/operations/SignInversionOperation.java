package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file SignInversionOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class SignInversionOperation extends MathOperation {
    public SignInversionOperation() {
        super(1);
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber num = stack.pop();
        ComplexNumber result = new ComplexNumber(-num.getReal(), -num.getImaginary());
        stack.push(result);
    }
}
