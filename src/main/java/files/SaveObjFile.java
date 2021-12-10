package src.main.java.files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import src.main.java.userOperations.UserOperation;

public class SaveObjFile implements SaveFileStrategy {
    @Override
    public void execute(File file, UserOperation[] operations) {
        if (!file.getAbsolutePath().endsWith(".dat")) {
            file = new File(file.getAbsolutePath() + ".dat");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(operations);
        } catch (Exception ex) {
            System.err.println("Save obj exception: " + ex);
        }
    }

}
