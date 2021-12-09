package src.main.java.userOperations;

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

    /**
     * @brief Constructor.
     * @param name Name of the operation.
     * @param sequence Sequence of operations contained in this.
     */
    public UserOperation(String name, String sequence) {
        this.name = name;
        setSequence(sequence);
    }

    /**
     * @brief Get the name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Get the sequence of operations.
     * @return The sequence.
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * @brief Get the array of operations to execute.
     * @return The algorithm.
     */
    public String[] getAlgorithm() {
        return algorithm;
    }

    /**
     * @brief Set the name.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @brief Set the sequence.
     * @param sequence The sequence to set.
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
        makeArray();
    }

    /**
     * @brief Create an array of operations from the sequence string.
     */
    private void makeArray() {
        algorithm = sequence.split(" ");
    }

    /**
     * @brief Return a string representation of this object.
     * @return `String` representation of this object.
     */
    @Override
    public String toString() {
        return "USER DEFINED '" + name + "': " + sequence;
    }
}
