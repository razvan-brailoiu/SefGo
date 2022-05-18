package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.IncorrectCredentials;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> departmentList;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize(){
        departmentList.getItems().addAll("Developer","Admin");
    }


    @FXML
    public void handleLogin(){
        try {
            String role = departmentList.getValue();
            UserService.VerifyUserCredentials(userField.getText(), passwordField.getText(), role);
            User.setLast_username(userField.getText());
            User.setLast_pasword(passwordField.getText());
            messageLabel.setText("Login was succesful");
            Parent root;
            if (Objects.equals(role, "Admin")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminStart.fxml"));
                root = (Parent) loader.load();
                Stage window = (Stage) loginButton.getScene().getWindow();
                window.setTitle("InApp");
                window.setScene(new Scene(root, 634,428));
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/DevStart.fxml"));
                root = (Parent) loader.load();
                Stage window = (Stage) loginButton.getScene().getWindow();
                window.setTitle("InApp");
                window.setScene(new Scene(root, 634,428));
            }
        }catch(IOException | IncorrectCredentials exception){
            messageLabel.setText(exception.getMessage());
//            System.out.printf(exception.getMessage());
        }
    }
}
