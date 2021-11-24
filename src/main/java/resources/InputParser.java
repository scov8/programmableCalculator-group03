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
