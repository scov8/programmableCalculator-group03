package src.main.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file RestoreTextFile.java
 * @author Francesco Tortora
 * @date 10 Dec 2021
 */

/**
 * Concrete implementation of the `RestoreFileStrategy` interface, according to
 * the Strategy Design Pattern, to load data from a text file.
 */
public class RestoreTextFile implements RestoreFileStrategy {

    /**
     * @brief Choose a file to open.
     * @param window Main application window.
     * @return File chosen; it can be `null`.
     */
    private File chooseFile(Window window) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Load from...");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File file = fc.showOpenDialog(window);
        if (file == null)
            return null;
        if (!file.getAbsolutePath().endsWith(".txt"))
            file = new File(file.getAbsolutePath() + ".txt");
        return file;
    }

    @Override
    public UserOperation[] execute(Window window) {
        File file = chooseFile(window);
        if (file == null)
            return null;

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            List<UserOperation> operations = new ArrayList<>();
            sc.useLocale(Locale.US);
            sc.useDelimiter("\n");
            String name;
            String sequence;
            while (sc.hasNext()) {
                name = sc.next();
                sequence = sc.next();
                operations.add(new UserOperation(name, sequence));
            }
            return operations.toArray(new UserOperation[0]);
        } catch (Exception e) {
            System.out.println("Read Text Exception: " + e);
            return null;
        }
    }

}
