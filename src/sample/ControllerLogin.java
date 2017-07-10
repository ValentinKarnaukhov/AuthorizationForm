package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.SQLException;


public class ControllerLogin {


    public Button btnLogin;
    public Button btnSingup;
    public PasswordField txtPass;
    public TextField txtLogin;
    public Label errMsg;


    public void login(ActionEvent actionEvent) throws SQLException, IOException {
        AuthoForm authoForm=new AuthoForm();

        if(authoForm.isRight(txtLogin.getText(),txtPass.getText())){

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Welcome.fxml"));
            Parent root1 =loader.load();
            Main.primaryStage.setTitle("Welcome");
            Main.primaryStage.setScene(new Scene(root1, 600, 400));
            ControllerWelc controllerWelc=loader.getController();
            controllerWelc.Welcome.setText("Welcome, "+authoForm.returnName(txtLogin.getText())+"!");
            Main.primaryStage.show();
        }else errMsg.setText("Pair login/password if not found!");

    }

    public void singup(ActionEvent actionEvent) throws IOException {

        Parent root1= FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Main.primaryStage.setTitle("Authorization");
        Main.primaryStage.setScene(new Scene(root1, 300, 400));
        Main.primaryStage.show();
    }



}
