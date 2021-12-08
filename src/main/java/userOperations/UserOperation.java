package src.main.java.userOperations;

import src.main.java.operations.*;

import java.io.Serializable;

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
