/**
 * @file Main.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */

package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/view.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Programmable Calculator");
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
