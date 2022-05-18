package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.DifferentPasswordsException;
import org.loose.fis.sre.exceptions.UserNotInDatabaseException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.Objects;

public class ChangePassForUserController {
    Parent root;
    @FXML
    private TextField userText;

    @FXML
    private PasswordField passText;

    @FXML
    private PasswordField confirmPassText;

    @FXML
    private Button confirmChangeButton;

    @FXML
    private Button backButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void iniateNewPasswordProcedure() {
        String pass_one = passText.getText();
        String pass_two = confirmPassText.getText();
        String user = userText.getText();
        try {
        if(!Objects.equals(pass_two,pass_one))
            throw new DifferentPasswordsException();
        UserService.deleteByUsername(user);
        UserService.addUser(user, pass_one, (String) "Developer");
        statusLabel.setText("Password changed succesfully");
        } catch (UsernameAlreadyExistsException | DifferentPasswordsException e) {
            statusLabel.setText("Passwords must be the same!");
        }
    }

    @FXML
    public void iniateBackToAdminProcedure(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminStart.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) backButton.getScene().getWindow();
            window.setTitle("InApp");
            window.setScene(new Scene(root, 634, 428));
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
