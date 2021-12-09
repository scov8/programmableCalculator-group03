package src.main.java.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * @file Variables.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This class contains all the calculator Variables.
 *
 *        A Variable has a name (letter of the alphabet) and a value copied
 *        from/to the main numbers stack.
 *        The calculator has a total of 26 Variables, one for each letter of the
 *        alphabet.
 */
public class Variables implements Cloneable {
    /**
     * The variables are stored in a map. Their name is the key and the number
     * is the value.
     */
    Map<Character, ComplexNumber> map;

    /**
     * @brief Constructor.
     */
    public Variables() {
        map = new HashMap<Character, ComplexNumber>();

        // Each variable starts with a null value.
        for (char letter = 'a'; letter <= 'z'; letter++) {
            map.put(Character.valueOf(letter), null);
        }
    }

    /**
     * @brief Get value from variable named `name`.
     * @param name Name of the variable.
     * @return Value of the variable.
     */
    public ComplexNumber get(char name) {
        return map.get(Character.valueOf(name));
    }

    /**
     * @brief Set a new value for the variable named `name`.
     * @param name  Name of the variable.
     * @param value Value to set.
     */
    public void set(char name, ComplexNumber value) {
        map.put(Character.valueOf(name), value);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
