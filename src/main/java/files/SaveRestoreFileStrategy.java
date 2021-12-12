package src.main.java.files;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveRestoreFileStrategy.java
 * @author Marco Plaitano
 * @date 12 Dec 2021
 */

/**
 * This interface declares a method to save a collection of user-defined
 * operations on a generic file.
 */
public interface SaveRestoreFileStrategy {
    /**
     * @brief Save the collection of user-defined operations in a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     */
    public void executeSave(Window window, UserOperation[] operations);

    /**
     * @brief Load the collection of user-defined operations in a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     * @return Array of `UserOperation`.
     */
    public UserOperation[] executeRestore(Window window);
}
