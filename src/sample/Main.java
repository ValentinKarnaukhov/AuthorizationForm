package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Logining.fxml"));
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();





    }


    public static void main(String[] args) {launch(args);}
}
