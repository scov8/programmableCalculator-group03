package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file MathOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public abstract class MathOperation implements Operation {
    private int numOperands;

    public MathOperation() {
        this.numOperands = 2;
    }

    public MathOperation(int numOperands) {
        this.numOperands = numOperands;
    }

    /**
     * @return the numOperands
     */
    public int getNumOperands() {
        return numOperands;
    }

    @Override
    public abstract void execute(Stack<ComplexNumber> stack);

}
