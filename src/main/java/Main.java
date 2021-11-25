/**
 * @file Main.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */

package src.main.java;
import src.main.java.resources.*;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
        // create an object of Stack class
        Stack<String> animals= new Stack<>();

        // push elements to top of stack
        animals.push("Dog");
        animals.push("Horse");
        animals.push("Cat");
        System.out.println("Stack: " + animals);

        // pop element from top of stack
        animals.pop();
        System.out.println("Stack after pop: " + animals);
        animals.push("Cavallo pazzo");
        System.out.println("Stack after pop-push: " + animals);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLDocumentController.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Programmable Calculator");
        stage.show();
    }
}
