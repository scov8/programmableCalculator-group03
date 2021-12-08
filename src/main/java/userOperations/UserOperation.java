package src.main.java.userOperations;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.*;
import src.main.java.resources.TextRecognizer;
import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;
import src.main.java.resources.ComplexNumber;

import java.io.Serializable;
import java.util.Stack;

/**
 * @file UserOperation.java
 * @author Francesco Tortora
 * @date 07 Dec 2021
 */

public class UserOperation implements Serializable {
    private String name;
    private String sequence;
    private String[] algorithm;

    public UserOperation(String name, String sequence, OperationsMap operationsMap) {
        this.name = name;
        this.sequence = sequence;
        makeQueue();
    }

    /**
     * @return the sequence
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the numberOfOperands
     */
    public int getNumOperands() {
        return numberOfOperands;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
        makeQueue();
    }

    private void makeQueue() {
        algorithm = sequence.split(" ");
    }

    @Override
    public String toString() {
        return "USER DEFINED '" + name + "': " + sequence;
    }
}
