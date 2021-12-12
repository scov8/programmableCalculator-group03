package src.main.java.resources;

import src.main.java.operations.OperationsMap;

/**
 * @file TextRecognizer.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

/**
 * @brief This class contains methods to parse and recognize the user input.
 */
public class TextRecognizer {
    /** Maps containing all the operations supported by this application. */
    private OperationsMap operationsMap;

    /**
     * @brief Constructor.
     */
    public TextRecognizer() {
        this.operationsMap = OperationsMap.getInstance();
    }

    /**
     * @brief Format given text by removing extra spaces and turning all letters
     *        to lowercase.
     * @param text The text to format.
     * @return The formatted version of text.
     */
    public String formatText(String text) {
        text = text.trim().replaceAll("\\s{2,}", " ");
        text = text.toLowerCase();
        return text;
    }

    /**
     * @brief Scan the given text to check whether it represents a number.
     * @param text The string to validate.
     * @return `true` if the string can be parsed into a ComplexNumber; `false`
     *         otherwise.
     */
    public boolean isComplexNumber(String text) {
        // Real: 'a'
        if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*$"))
            // Complex: 'a+bi', 'a+i', 'a+bj', 'a+j'
            if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*[+-]([0-9]+[.]?[0-9]*)?[ij]$"))
                // Imaginary: 'bi', 'i', 'bj', 'j'
                if (!text.matches("^[+-]?([0-9]+[.]?[0-9]*)?[ij]$"))
                    return false;
        return true;
    }

    /**
     * @brief Check whether the given string is a valid operation that can be
     *        executed on the main numbers stack.
     * @param text The string to validate.
     * @return `true` if the string matches one of the operations; `false`
     *         otherwise.
     */
    public boolean isStackOperation(String text) {
        return operationsMap.getStackOperation(text) != null;
    }

    /**
     * @brief Check whether the given string is a valid operation that can be
     *        executed on one of the variables.
     * @param text The string to validate.
     * @return `true` if the string matches the pattern; `false` otherwise.
     */
    public boolean isVariableOperation(String text) {
        return text.matches("^[+\\-><][a-z]$");
    }

    /**
     * @brief Check whether the given string is a valid operation that can be
     *        executed on the stack of variables' values.
     * @param text The string to validate.
     * @return `true` if the string matches one of the operations; `false`
     *         otherwise.
     */
    public boolean isVariableStorageOperation(String text) {
        return operationsMap.getVariableStorageOperation(text) != null;
    }

    /**
     * @brief Check whether the given string is an existing user-defined
     *        operation.
     * @param text The string to validate.
     * @return `true` if the string matches one of the operations; `false`
     *         otherwise.
     */
    public boolean isUserDefinedOperation(String text) {
        return operationsMap.getUserDefinedOperation(text) != null;
    }

    /**
     * @brief Check whether given text is a valid name for a user-defined
     *        operation.
     * @param name Name of the operation.
     * @return boolean.
     */
    public boolean isValidUserDefinedOperationName(String name) {
        if (!name.matches("^[a-z_A-Z]+[0-9]*[a-z_A-Z]*$"))
            return false;
        if (isStackOperation(name))
            return false;
        return true;
    }

    /**
     * @brief Check whether given text is a valid sequence for a user-defined
     *        operation.
     * @param name     Name of the operation.
     * @param sequence Sequence of the operation.
     * @return boolean.
     */
    public boolean isValidUserDefinedOperationSequence(String name, String sequence) {
        String[] values = sequence.split(" ");

        for (String value : values) {
            if (value.length() == 0)
                return false;

            if (isStackOperation(value))
                continue;
            if (isVariableOperation(value))
                continue;
            if (isVariableStorageOperation(value))
                continue;
            if (operationsMap.getUserDefinedOperation(value) != null &&
                    operationsMap.getUserDefinedOperation(value).getName() != name)
                continue;
            if (isComplexNumber(value))
                continue;
            return false;
        }

        return true;
    }
}
