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

public class ControllerReg {


    public TextField email;
    public TextField reglogin;
    public PasswordField regpass;
    public TextField regfname;
    public TextField reglname;
    public Button createbtn;
    public Label errMsg;
    public Button cancel;


    RegForm regForm=new RegForm();


    private boolean isNoVoid(TextField a,TextField b, TextField c,TextField d, TextField e){
        if(a.getText().equals("")||b.getText().equals("")||c.getText().equals("")||d.getText().equals("")||e.getText().equals(""))return false;
        else return true;
    }

    public void createAcc(ActionEvent actionEvent) {

        if(isNoVoid(email,regfname,reglname,reglogin,regpass)){
            if(regForm.isCorrect(reglogin.getText(),email.getText())){
                regForm.addUser(email.getText(),reglogin.getText(),regpass.getText(),regfname.getText(),reglname.getText());
                errMsg.setText("Account is create!");
            }else{
                errMsg.setText("Already exists!");
            }
        }else{
            errMsg.setText("Give a full information!");
        }



    }

    public void cancelReg(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Logining.fxml"));
        Parent root1 =loader.load();

        Main.primaryStage.setTitle("Authorization");
        Main.primaryStage.setScene(new Scene(root1, 300, 300));
        ControllerLogin controllerLogin=loader.getController();
        controllerLogin.txtLogin.setText(reglogin.getText());
        controllerLogin.txtPass.setText(regpass.getText());
        Main.primaryStage.show();

    }
}
