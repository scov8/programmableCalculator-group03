/**
 * @file InputParser.java
 * @author Marco Plaitano
 * @date 24 Nov 2021
 */

package src.main.java.resources;

/**
 * @brief This class contains static methods to parse the user input.
 */
public class InputParser {

    /**
     * @brief Parse the given text to return the corresponding complex number.
     *
     *        The string has to be in the form 'a+bi' to be correctly parsed.
     * @param text The string to parse.
     * @return A `Number` instance or `null` if the string is incorrect.
     */
    public static Number parseNumber(String text) {
        // Remove all spaces from the string.
        text = text.strip();
        text = text.replace(" ", "");
        text = text.replace("j", "i");

        // Check that the syntax is correct and follows the form: 'a+bj'.
        // In particular:
        // - a and/or b can be negative.
        // - i can be replaced with j.
        if (!text.matches("^[+-]?[0-9]\\d*(\\.\\d+)?$"))
            if (!text.matches("^[+-]?[0-9]\\d*(\\.\\d+)?([+-][0-9]\\d*(\\.\\d+)?i)?$"))
                if (!text.matches("^[+-]?[0-9]\\d*(\\.\\d+)?i$"))
                    return null;

        String a, b;

        // Look for the imaginary part sign's position in the string.
        int signPos = text.indexOf("+", 1);
        if (signPos < 0)
            signPos = text.indexOf("-", 1);
        // If no sign to divide real and imaginary part is found it means only
        // one of them is present in the string.
        if (signPos < 0) {
            // If 'i' is in the string the number is imaginary, otherwise it is
            // real.
            if (text.indexOf("i") > 0) {
                a = "0";
                b = text.substring(0, text.length() - 1);
            } else {
                a = text;
                b = "0";
            }
        } else {
            // Get substring representing real part of the number, sign included.
            a = text.substring(0, signPos);
            // Get substring representing imaginary part of the number, sign
            // included, i/j excluded.
            b = text.substring(signPos, text.length() - 1);
        }

        return new Number(Double.parseDouble(a), Double.parseDouble(b));
    }

    /**
     * @brief Check whether the given string is a valid operation.
     * @param text The string to validate.
     * @return `true` if the string matches one of the operations; `false`
     *         otherwise.
     */
    public static boolean isOperation(String text) {
        String[] operations = { "+", "-", "*", "/", "+-", "sqrt" };
        text = text.strip();

        for (String string : operations) {
            if (text.compareTo(string) == 0)
                return true;
        }
        return false;
    }
}
