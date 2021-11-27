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
    public static ComplexNumber parseNumber(String text) {
        // Remove all spaces from the string.
        text = text.strip().toLowerCase();
        text = text.replace(" ", "");
        text = text.replace("j", "i");

        // real: 'a', '+a' or '-a'
        if (!text.matches("^[+-]?[0-9]\\d*(\\.\\d+)?$"))
            // complex: 'a+bi', 'a-bi', '-a+bi', '-a-bi', '+a+bi', '+a-bi'
            if (!text.matches("^[+-]?[0-9]\\d*(\\.\\d+)?([+-][0-9]\\d*(\\.\\d+)?i)?$"))
                // complex: 'bi', '-bi', '+bi', 'i'
                if (!text.matches("^([+-]?[0-9]\\d*(\\.\\d+)?)?i$"))
                    return null;

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
        }

        return new ComplexNumber(Double.parseDouble(a), Double.parseDouble(b));
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
