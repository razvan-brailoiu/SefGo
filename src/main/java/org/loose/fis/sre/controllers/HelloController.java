package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.OneOrMoreEmptyFieldsException;
import org.loose.fis.sre.exceptions.UserNotInDatabaseException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameLengthException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;


public class HelloController {

    public int counter = 0;
    public int daysToWork = 10;
    private final String username = User.getLast_username();
    private final String password = User.getLast_pasword();
    private final int[] list = new int[32];
    private final int maxDays = 9;

    @FXML
    TextField dSelect;
    @FXML
    TextField tDays;
    @FXML
    TextField currentDate;
    @FXML
    Button deselectDays;
    @FXML
    Button exitButton;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;
    @FXML
    Button b10;
    @FXML
    Button b11;
    @FXML
    Button b12;
    @FXML
    Button b13;
    @FXML
    Button b14;
    @FXML
    Button b15;
    @FXML
    Button b16;
    @FXML
    Button b17;
    @FXML
    Button b18;
    @FXML
    Button b19;
    @FXML
    Button b20;
    @FXML
    Button b21;
    @FXML
    Button b22;
    @FXML
    Button b23;
    @FXML
    Button b24;
    @FXML
    Button b25;
    @FXML
    Button b26;
    @FXML
    Button b27;
    @FXML
    Button b28;
    @FXML
    Button b29;
    @FXML
    Button b30;
    @FXML
    Button b31;
    @FXML
    private List<Button> buttonList;

    @FXML
    private void markSelectedDays() {
        buttonList.stream()
                .filter((button) -> list[Integer.parseInt(button.getId().substring(1))] == 1)
                .forEach(this::markRed);
    }

    @FXML
    public void initialize() throws UserNotInDatabaseException {
        buttonList = List.of(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31);
        LocalDate currentGlobalDate = LocalDate.now();
        dSelect.setText(String.valueOf(counter));
        tDays.setText(String.valueOf(daysToWork));
        currentDate.setText(currentGlobalDate.getMonth() + "/" + currentGlobalDate.getYear());
        tDays.setText(String.valueOf(daysToWork));
        String userList = UserService.getListByUsername(username);

        if(!Objects.equals(userList, "not selected")) {
            String[] stringArray = userList.split(",");
            for (String s : stringArray) {
                list[Integer.parseInt(s)] = 1;
            }
        }
        markSelectedDays();
        dSelect.setText(String.valueOf(counter));
    }

    @FXML
    public void saveAction() throws UsernameAlreadyExistsException, OneOrMoreEmptyFieldsException, UsernameLengthException {
        StringBuilder newList = new StringBuilder();
        for (int i = 0; i < 32; i++)
        {
            if(list[i] == 1)
                newList.append(i).append(",");
        }
        UserService.deleteByUsername(username);
        UserService.addUser(username, password, "Developer", newList.toString());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save");
        alert.setHeaderText("Your changes has been saved!");
        alert.setContentText("Press ok to continue!");
        if (alert.showAndWait().get() == ButtonType.OK);

    }

    @FXML
    public void deselectAllDays() {
        counter = 0;
        for(int i = 0; i <= 31; i++)
            list[i] = 0;
        buttonList.forEach((button) -> button.setStyle("-fx-background-color: #03AC13"));
        counter = 0;
        dSelect.setText(String.valueOf(counter));
    }

    public void markRed(Button button) {
        button.setStyle("-fx-background-color: Red");
        counter++;
    }

    @FXML
    public void handleButton(ActionEvent ae) {
        Button button = ((Button) ae.getSource());
        int id = Integer.parseInt(button.getId().substring(1));
        if (list[id] == 1) {
            button.setStyle("-fx-background-color: #03AC13");
            list[id] = 0;
            counter--;
        }
        else if (counter <= maxDays) {
            button.setStyle("-fx-background-color: Red");
            counter++;
            list[id] = 1;
        }
        dSelect.setText(String.valueOf(counter));
    }

    @FXML
    public void exitButtonAction(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DevStart.fxml"));
        try {
            Parent root = loader.load();
            Stage window = (Stage) exitButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            if(counter == maxDays + 1) {
                alert.setHeaderText("You are about to go back to DEV application!");
                alert.setContentText("Leave for sure ? ");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    window.setTitle("Login");
                    window.setScene(new Scene(root, 634, 428));
                }
            }
            else {
                int remainDays = maxDays - counter + 1;
                alert.setHeaderText("You have to select more " + remainDays + "days!");
                alert.setContentText("Press OK to continue!");
                if(alert.showAndWait().get() == ButtonType.OK);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}