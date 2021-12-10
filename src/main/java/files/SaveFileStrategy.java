package src.main.java.files;

import java.io.File;

import src.main.java.userOperations.UserOperation;

/**
 * @file IOFileStrategy.java
 * @author Marco Plaitano
 * @date 10 Dec 2021
 */

public interface SaveFileStrategy {
    public void execute(File file, UserOperation[] operations);
}
