package src.main.java.files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveFileStrategy.java
 * @author Marco Plaitano
 * @date 10 Dec 2021
 */

/**
 * Concrete implementation of the `SaveFileStrategy` interface, according to the
 * Strategy Design Pattern, to save data on an object file.
 */
public class SaveObjFile implements SaveFileStrategy {

    /**
     * @brief Choose a file to open in save mode.
     * @param window Main application window.
     * @return File chosen; it can be `null`.
     */
    private File chooseFile(Window window) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save to...");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Object files (*.dat)", "*.dat"));
        File file = fc.showSaveDialog(window);
        if (file == null)
            return null;
        if (!file.getAbsolutePath().endsWith(".dat"))
            file = new File(file.getAbsolutePath() + ".dat");
        return file;
    }

    @Override
    public void execute(Window window, UserOperation[] operations) {
        File file = chooseFile(window);
        if (file == null)
            return;

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(operations);
        } catch (Exception ex) {
            System.out.println("Save to object file exception: " + ex);
        }
    }

}
