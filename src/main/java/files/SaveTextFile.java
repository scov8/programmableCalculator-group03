package src.main.java.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveTextFile.java
 * @author Marco Plaitano
 * @date 10 Dec 2021
 */

/**
 * Concrete implementation of the `SaveFileStrategy` interface, according to the
 * Strategy Design Pattern, to save data on a text file.
 */
public class SaveTextFile implements SaveFileStrategy {

    /**
     * @brief Choose a file to open in save mode.
     * @param window Main application window.
     * @return File chosen; it can be `null`.
     */
    private File chooseFile(Window window) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save to...");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File file = fc.showSaveDialog(window);
        if (file == null)
            return null;
        if (!file.getAbsolutePath().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }
        return file;
    }

    @Override
    public void execute(Window window, UserOperation[] operations) {
        File file = chooseFile(window);
        if (file == null)
            return;

        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (UserOperation op : operations)
                p.print(op.toString() + "\n");
        } catch (Exception e) {
            System.out.println("Write Text Exception: " + e);
        }
    }

}
