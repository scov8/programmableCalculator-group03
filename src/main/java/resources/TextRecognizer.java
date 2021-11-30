/**
 * @file InputParser.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package src.main.java.resources;

/**
 * @brief This class contains static methods to parse the user input.
 */
public class TextRecognizer {
    /**
     * All recognized operations on the numbers stack.
     */
    private final String[] stackOperations = { "+", "-", "*", "/", "+-", "sqrt",
            "clear", "dup", "swap", "over", "drop" };

    /**
     * @brief Constructor.
     */
    public TextRecognizer() {
    }

    public String formatText(String text) {
        return text.strip().replace(" ", "").toLowerCase();
    }

    /**
     * @brief Parse the given text to return the corresponding complex number.
     *
     *        The string has to be in the form 'a+bi' to be correctly parsed.
     * @param text The string to parse.
     * @return A `Number` instance or `null` if the string is incorrect.
     */
    public ComplexNumber extractNumber(String text) {
        text = formatText(text);

        // real: 'a'
        if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*$"))
            // complex: 'a+bi', 'a+i', 'a+bj', 'a+j'
            if (!text.matches("^[+-]?[0-9]+[.]?[0-9]*[+-]([0-9]+[.]?[0-9]*)?[ij]$"))
                // complex: 'bi', 'i', 'bj', 'j'
                if (!text.matches("^[+-]?([0-9]+[.]?[0-9]*)?[ij]$"))
                    return null;

        // uniform every string with i instead of j.
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
     *        executed on the variables stack.
     * @param text The string to validate.
     * @return `true` if the string matches the pattern; `false` otherwise.
     */
    public boolean isVariableOperation(String text) {
        text = formatText(text);
        return text.matches("^[+\\-><][a-z]$");
    }
}
