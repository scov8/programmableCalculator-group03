package src.main.java.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import src.main.java.userOperations.UserOperation;

public class SaveTextFile implements SaveFileStrategy {

    @Override
    public void execute(File file, UserOperation[] operations) {
        if (!file.getAbsolutePath().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }

        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (UserOperation op : operations) {
                p.print(op.toString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Write Text Exception: " + e);
        }
    }

}
