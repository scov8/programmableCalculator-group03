package src.main.java.files;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveRestoreFileStrategy.java
 * @author Marco Plaitano
 * @date 12 Dec 2021
 */

/**
 * @brief This interface declares two methods, one to save a collection of
 *        user-defined operations on a file and one to load it back.
 *
 *        This follows the strategy design pattern.
 */
public interface SaveRestoreFileStrategy {
    /**
     * @brief Save the collection of user-defined operations on a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     */
    public void executeSave(Window window, UserOperation[] operations);

    /**
     * @brief Load the collection of user-defined operations from a file.
     * @param window     Main application window.
     * @return Array of `UserOperation`.
     */
    public UserOperation[] executeRestore(Window window);
}
