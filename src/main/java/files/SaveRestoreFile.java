package src.main.java.files;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import src.main.java.userOperations.UserOperation;

/**
 * @file SaveRestoreFile.java
 * @author Marco Plaitano
 * @date 12 Dec 2021
 */

public abstract class SaveRestoreFile implements SaveRestoreFileStrategy {
    private String extension;
    private ExtensionFilter filter;

    public SaveRestoreFile(String extension) {
        this.extension = extension;
        this.filter = new ExtensionFilter("(*" + extension + ")", "*" + extension);
    }

    /**
     * @brief Choose a file to open.
     * @param window Main application window.
     * @param saveMode `true` if the file has to be opened to save data in it.
     * @return File chosen; it can be `null` if none has been chosen.
     */
    protected File chooseFile(Window window, boolean saveMode) {
        FileChooser fc = new FileChooser();

        // change the title based on the intentions.
        String fileChooserTitle = saveMode ? "Save to..." : "Load from...";
        fc.setTitle(fileChooserTitle);

        // add a filter to only permit a certain extension type to be chosen.
        fc.getExtensionFilters().add(filter);

        File file;
        // open different dialog based on whether the file has to be open in
        // saveMode or not.
        if (saveMode)
            file = fc.showSaveDialog(window);
        else
            file = fc.showOpenDialog(window);

        if (file == null)
            return null;

        // add extension to file if user gives none.
        if (!file.getAbsolutePath().endsWith(extension))
            file = new File(file.getAbsolutePath() + extension);

        return file;
    }

    @Override
    public abstract void executeSave(Window window, UserOperation[] operations);

    @Override
    public abstract UserOperation[] executeRestore(Window window);
}
