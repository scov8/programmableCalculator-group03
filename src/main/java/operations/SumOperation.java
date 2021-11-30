package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file SumOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class SumOperation implements Operation {
    private int numOperands;

    public SumOperation() {
        this.numOperands = 2;
    }

    public SumOperation(int numOperands) {
        this.numOperands = numOperands;
    }

    /**
     * @return the numOperands
     */
    public int getNumOperands() {
        return numOperands;
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber right = stack.pop();
        ComplexNumber left = stack.pop();
        ComplexNumber result = new ComplexNumber(
            left.getReal() + right.getReal(),
            left.getImaginary() + right.getImaginary()
        );
        stack.push(result);
    }
}
