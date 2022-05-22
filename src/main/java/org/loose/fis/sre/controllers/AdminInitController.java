package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class AdminInitController {

    @FXML
    private Button addNewEmployeeButton;

    @FXML
    private Button generateReportButton;

    @FXML
    private Button editEmployeesButton;
    @FXML
    private Button logOutButton;

    @FXML
    private Button changePassButton;

    @FXML
    private Label helloAdminLabel;

    private Parent root;

    @FXML
    public void initialize(){
        helloAdminLabel.setText("Hello, "+User.getLast_username());
    }

    @FXML
    public void iniateAddNewEmployee(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/register.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) addNewEmployeeButton.getScene().getWindow();
            window.setTitle("InApp");
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

    @FXML
    public void iniateEditEmployees(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewEmployees.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) editEmployeesButton.getScene().getWindow();
            window.setTitle("InApp");
            window.setScene(new Scene(root, 634, 428));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void iniateChangePasswordProcedure(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChangePassWindow.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) changePassButton.getScene().getWindow();
            window.setTitle("InApp");
            window.setScene(new Scene(root, 634, 428));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void GenerateReportAction(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WhoComingAdmin.fxml"));
            root = (Parent) loader.load();
            Stage window = (Stage) generateReportButton.getScene().getWindow();
            window.setTitle("InApp");
            window.setScene(new Scene(root, 709, 400));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
