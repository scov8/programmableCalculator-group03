package src.main.java.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file RestoreObjFile.java
 * @author Francesco Tortora
 * @date 10 Dec 2021
 */

/**
 * Concrete implementation of the `RestoreFileStrategy` interface, according to
 * the Strategy Design Pattern, to load data from an object file.
 */
public class RestoreObjFile implements RestoreFileStrategy {

    /**
     * @brief Choose a file to open.
     * @param window Main application window.
     * @return File chosen; it can be `null`.
     */
    private File chooseFile(Window window) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Load from...");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Object files (*.dat)", "*.dat"));
        File file = fc.showOpenDialog(window);
        if (file == null)
            return null;
        if (!file.getAbsolutePath().endsWith(".dat"))
            file = new File(file.getAbsolutePath() + ".dat");
        return file;
    }

    @Override
    public UserOperation[] execute(Window window) {
        File file = chooseFile(window);
        if (file == null)
            return null;

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            UserOperation[] operations = (UserOperation[]) ois.readObject();
            return operations;
        } catch (Exception ex) {
            System.out.println("Restore from object file exception: " + ex);
            return null;
        }
    }
}
