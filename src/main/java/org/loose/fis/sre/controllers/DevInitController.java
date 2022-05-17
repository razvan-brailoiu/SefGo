package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class DevInitController {

    Parent root;

    @FXML
    private Button logOutButton;

    @FXML
    private Button pickDatesButton;

    @FXML
    public void initPickDates(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUICalendar.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) pickDatesButton.getScene().getWindow();
            window.setTitle("Calendar");
            window.setScene(new Scene(root, 634, 428));


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void iniateLogOut(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        try {
            root = (Parent) loader.load();
            Stage window = (Stage) logOutButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You are about to log out of your account!");
            alert.setContentText("Leave for sure ? ");
            if(alert.showAndWait().get() == ButtonType.OK) {
                window.setTitle("Login");
                window.setScene(new Scene(root, 634, 428));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
