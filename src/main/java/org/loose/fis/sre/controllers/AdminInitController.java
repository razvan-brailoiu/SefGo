package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminInitController {

    @FXML
    private Button addNewEmployeeButton;

    private Parent root;

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
}
