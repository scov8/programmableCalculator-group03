package src.main.java.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveRestoreObjFile.java
 * @author Marco Plaitano
 * @date 12 Dec 2021
 */

/**
 * Concrete implementation of the `SaveFileStrategy` interface, according to the
 * Strategy Design Pattern, to save data on an object file.
 */
public class SaveRestoreObjFile extends SaveRestoreFile {

    public SaveRestoreObjFile() {
        super(".dat");
    }

    @Override
    public void executeSave(Window window, UserOperation[] operations) {
        File file = chooseFile(window, true);
        if (file == null)
            return;

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(operations);
        } catch (Exception ex) {
            System.out.println("Save to object file exception: " + ex);
        }
    }

    @Override
    public UserOperation[] executeRestore(Window window) {
        File file = chooseFile(window, false);
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
