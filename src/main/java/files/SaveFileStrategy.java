package src.main.java.files;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveFileStrategy.java
 * @author Marco Plaitano
 * @date 10 Dec 2021
 */

/**
 * This interface declares a method to save a collection of user-defined
 * operations on a generic file.
 */
public interface SaveFileStrategy {
    /**
     * @brief Save the collection of user-defined operations in a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     */
    public void execute(Window window, UserOperation[] operations);
}
