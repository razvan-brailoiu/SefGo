package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    @FXML
    private Button backToAdminButton;
    @FXML
    private ChoiceBox role;

    private Parent root;

    @FXML
    public void initialize() {
        role.getItems().addAll("Developer", "Admin");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void iniateBackToAdmin(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminStart.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) backToAdminButton.getScene().getWindow();
            window.setTitle("InApp");
            window.setScene(new Scene(root, 634, 428));
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

}
