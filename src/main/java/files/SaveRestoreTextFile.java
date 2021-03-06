package src.main.java.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveRestoreTextFile.java
 * @author Marco Plaitano
 * @date 12 Dec 2021
 */

/**
 * Concrete implementation of the `SaveFileStrategy` interface, according to the
 * Strategy Design Pattern, to save data on a text file.
 */
public class SaveRestoreTextFile extends SaveRestoreFile {

    /**
     * @brief Constructor.
     */
    public SaveRestoreTextFile() {
        super(".txt");
    }

    /**
     * @brief Save the collection of user-defined operations on a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     */
    @Override
    public void executeSave(Window window, UserOperation[] operations) {
        File file = chooseFile(window, true);
        if (file == null)
            return;

        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (UserOperation op : operations)
                p.print(op.toString() + "\n");
        } catch (Exception e) {
            System.out.println("Write Text Exception: " + e);
        }
    }

    /**
     * @brief Load the collection of user-defined operations from a file.
     * @param window     Main application window.
     * @return Array of `UserOperation`.
     */
    @Override
    public UserOperation[] executeRestore(Window window) {
        File file = chooseFile(window, false);
        if (file == null)
            return null;

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            List<UserOperation> operations = new ArrayList<>();
            sc.useLocale(Locale.US);
            sc.useDelimiter("\n");

            while (sc.hasNext()) {
                String name = sc.next();
                String sequence = sc.next();
                operations.add(new UserOperation(name, sequence));
            }
            return operations.toArray(new UserOperation[0]);

        } catch (Exception e) {
            System.out.println("Read Text Exception: " + e);
            return null;
        }
    }
}
