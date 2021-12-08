/**
 * @file InputParser.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package src.main.java.resources;

import java.io.Serializable;

import src.main.java.operations.OperationsMap;

/**
 * @brief This class contains static methods to parse the user input.
 */
public class TextRecognizer implements Serializable {
    // TODO: use map for every operation
    /** All recognized operations on the numbers stack. */
    private final String[] stackOperations = { "+", "-", "*", "/", "+-", "sqrt",
            "clear", "dup", "swap", "over", "drop" };

    /** All recognized operations on the variables stack. */
    private final String[] variableStorageOperations = { "save", "restore" };

    OperationsMap operationsMap;

    /**
     * @brief Constructor.
     */
    public TextRecognizer(OperationsMap operationsMap) {
        this.operationsMap = operationsMap;
    }

    /**
     * @brief Format given text by removing spaces and turning all letters to
     *        lowercase.
     * @param text The text to format.
     * @return The formatted version of text.
     */
    public String formatText(String text) {
        return text.strip().toLowerCase();
    }

    /**
     * @brief Scan the given text to return the corresponding complex number.
     * @param text The string to parse.
     * @return A `ComplexNumber` instance or `null` if the string is incorrect.
     */
    public ComplexNumber extractNumber(String text) {
        text = formatText(text);

        // Real: 'a'
        if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*$"))
            // Complex: 'a+bi', 'a+i', 'a+bj', 'a+j'
            if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*[+-]([0-9]+[.]?[0-9]*)?[ij]$"))
                // Imaginary: 'bi', 'i', 'bj', 'j'
                if (!text.matches("^[+-]?([0-9]+[.]?[0-9]*)?[ij]$"))
                    return null;

        // Uniform every string with 'i' instead of 'j'.
        text = text.replaceAll("j", "i");

        String a, b;

        // Look for the imaginary part sign's position in the string.
        int signPos = text.indexOf("+", 1);
        if (signPos < 0)
            signPos = text.indexOf("-", 1);
        // If no sign to divide real and imaginary part is found it means only
        // one of them is present in the string.
        if (signPos < 0) {
            // If the entire string is simply "i".
            if (text.compareTo("i") == 0) {
                a = "0";
                b = "1";
            }
            // If 'i' is in the string the number is imaginary.
            else if (text.indexOf("i") > 0) {
                a = "0";
                b = text.substring(0, text.length() - 1);
            }
            // Real number.
            else {
                a = text;
                b = "0";
            }
        } else {
            // Get substring representing real part of the number, sign included.
            a = text.substring(0, signPos);
            // Get substring representing imaginary part of the number, sign
            // included, i/j excluded.
            b = text.substring(signPos, text.length() - 1);
            if (b.length() == 1)
                b += "1";
        }

        return new ComplexNumber(Double.parseDouble(a), Double.parseDouble(b));
    }

    /**
     * @brief Check whether the given string is a valid operation that can be
     *        executed on the main numbers stack.
     * @param text The string to validate.
     * @return `true` if the string matches one of the operations; `false`
     *         otherwise.
     */
    public boolean isStackOperation(String text) {
        text = formatText(text);
        for (String op : stackOperations)
            if (text.compareTo(op) == 0)
                return true;
        return false;
    }

    /**
     * @brief Check whether the given string is a valid operation that can be
     *        executed on one of the variables.
     * @param text The string to validate.
     * @return `true` if the string matches the pattern; `false` otherwise.
     */
    public boolean isVariableOperation(String text) {
        text = formatText(text);
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
        text = formatText(text);
        for (String op : variableStorageOperations)
            if (text.compareTo(op) == 0)
                return true;
        return false;
    }

    public boolean existsUserDefinedOperation(String name) {
        name = formatText(name);
        return operationsMap.getUserDefinedOperation(name) != null;
    }

    public boolean isUserDefinedOperation(String sequence) {
        String[] values = sequence.split(" ");

        for (String value : values) {
            if (!isStackOperation(value))
                if (!isVariableOperation(value))
                    if (!isVariableStorageOperation(value))
                        if (!existsUserDefinedOperation(value))
                            if (extractNumber(value) == null)
                                return false;
        }
        return true;
    }
}
