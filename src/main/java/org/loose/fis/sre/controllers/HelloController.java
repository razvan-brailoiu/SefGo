package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UserNotInDatabaseException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;


public class HelloController {

    public int counter = 0;
    public int daysToWork = 10;
    private final String username = User.getLast_username();
    private final String password = User.getLast_pasword();
    private int[] list = new int[32];
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
    Button b01;
    @FXML
    Button b02;
    @FXML
    Button b03;
    @FXML
    Button b04;
    @FXML
    Button b05;
    @FXML
    Button b06;
    @FXML
    Button b07;
    @FXML
    Button b08;
    @FXML
    Button b09;
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
    private Parent root;
    @FXML
    Label test;

    @FXML
    private void markSelectedDays(int[] array)
    {
        for(int i = 1; i <= 31; i++){
            if(i == 1 && array[i] == 1)
                button01();
            if(i == 2 && array[i] == 1)
                button02();
            if(i == 3 && array[i] == 1)
                button03();
            if(i == 4 && array[i] == 1)
                button04();
            if(i == 5 && array[i] == 1)
                button05();
            if(i == 5 && array[i] == 1)
                button05();
            if(i == 6 && array[i] == 1)
                button06();
            if(i == 7 && array[i] == 1)
                button07();
            if(i == 7 && array[i] == 1)
                button07();
            if(i == 8 && array[i] == 1)
                button08();
            if(i == 9 && array[i] == 1)
                button09();
            if(i == 10 && array[i] == 1)
                button10();
            if(i ==11 && array[i] == 1)
                button11();
            if(i == 12 && array[i] == 1)
                button12();
            if(i == 13 && array[i] == 1)
                button13();
            if(i == 14 && array[i] == 1)
                button14();
            if(i == 15 && array[i] == 1)
                button15();
            if(i == 15 && array[i] == 1)
                button15();
            if(i == 16 && array[i] == 1)
                button16();
            if(i == 17 && array[i] == 1)
                button17();
            if(i == 18 && array[i] == 1)
                button18();
            if(i == 19 && array[i] == 1)
                button19();
            if(i == 20 && array[i] == 1)
                button20();
            if(i == 21 && array[i] == 1)
                button21();
            if(i == 22 && array[i] == 1)
                button22();
            if(i == 23 && array[i] == 1)
                button23();
            if(i == 24 && array[i] == 1)
                button24();
            if(i == 25 && array[i] == 1)
                button25();
            if(i == 26 && array[i] == 1)
                button26();
            if(i == 27 && array[i] == 1)
                button27();
            if(i == 28 && array[i] == 1)
                button28();
            if(i == 29 && array[i] == 1)
                button29();
            if(i == 30 && array[i] == 1)
                button30();
            if(i == 31 && array[i] == 1)
                button31();
        }
    }

    @FXML
    public void initialize() throws UserNotInDatabaseException {
        LocalDate currentGlobalDate = LocalDate.now();
        dSelect.setText(String.valueOf(counter));
        tDays.setText(String.valueOf(daysToWork));
        currentDate.setText(currentGlobalDate.getMonth() + "/" + currentGlobalDate.getYear());
        tDays.setText(String.valueOf(daysToWork));
        System.out.println(username);
        String userList = UserService.getListByUsername(username);
        if(!Objects.equals(userList, "not selected")) {
            String[] stringArray = userList.split(",");
            for (int i = 0; i < stringArray.length; i++) {
                list[Integer.valueOf(stringArray[i])] = 1;
            }
            markSelectedDays(list);
        }

    }

    @FXML
    public void saveAction() throws UsernameAlreadyExistsException {
        String newList = "";
        for (int i = 0; i < 32; i++)
        {
            if(list[i] == 1)
                newList = newList + i + ",";
        }
        UserService.deleteByUsername(username);
        UserService.addUser( username, password, "Developer", newList);

    }

    @FXML
    public void deselectAllDays() {
        counter = 0;
        for(int i = 0; i <= 31; i++)
            list[i] = 0;
        b01.setDisable(false);
        b01.setStyle("-fx-background-color: Green");
        b02.setDisable(false);
        b02.setStyle("-fx-background-color: Green");
        b03.setDisable(false);
        b03.setStyle("-fx-background-color: Green");
        b04.setDisable(false);
        b04.setStyle("-fx-background-color: Green");
        b05.setDisable(false);
        b05.setStyle("-fx-background-color: Green");
        b06.setDisable(false);
        b06.setStyle("-fx-background-color: Green");
        b07.setDisable(false);
        b07.setStyle("-fx-background-color: Green");
        b08.setDisable(false);
        b08.setStyle("-fx-background-color: Green");
        b09.setDisable(false);
        b09.setStyle("-fx-background-color: Green");
        b10.setDisable(false);
        b10.setStyle("-fx-background-color: Green");
        b11.setDisable(false);
        b11.setStyle("-fx-background-color: Green");
        b12.setDisable(false);
        b12.setStyle("-fx-background-color: Green");
        b13.setDisable(false);
        b13.setStyle("-fx-background-color: Green");
        b14.setDisable(false);
        b14.setStyle("-fx-background-color: Green");
        b15.setDisable(false);
        b15.setStyle("-fx-background-color: Green");
        b16.setDisable(false);
        b16.setStyle("-fx-background-color: Green");
        b17.setDisable(false);
        b17.setStyle("-fx-background-color: Green");
        b18.setDisable(false);
        b18.setStyle("-fx-background-color: Green");
        b19.setDisable(false);
        b19.setStyle("-fx-background-color: Green");
        b20.setDisable(false);
        b20.setStyle("-fx-background-color: Green");
        b21.setDisable(false);
        b21.setStyle("-fx-background-color: Green");
        b22.setDisable(false);
        b22.setStyle("-fx-background-color: Green");
        b23.setDisable(false);
        b23.setStyle("-fx-background-color: Green");
        b24.setDisable(false);
        b24.setStyle("-fx-background-color: Green");
        b25.setDisable(false);
        b25.setStyle("-fx-background-color: Green");
        b26.setDisable(false);
        b26.setStyle("-fx-background-color: Green");
        b27.setDisable(false);
        b27.setStyle("-fx-background-color: Green");
        b28.setDisable(false);
        b28.setStyle("-fx-background-color: Green");
        b29.setDisable(false);
        b29.setStyle("-fx-background-color: Green");
        b30.setDisable(false);
        b30.setStyle("-fx-background-color: Green");
        b31.setDisable(false);
        b31.setStyle("-fx-background-color: Green");
        counter = 0;
        dSelect.setText(String.valueOf(counter));
    }

    @FXML
    public void button01()  {
        if(counter <= maxDays) {
            b01.setStyle("-fx-background-color: Red");
            b01.setDisable(true);
            b01.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[1] = 1;
        }
    }

    @FXML
    public void button02()  {
            if(counter <= maxDays) {
                b02.setStyle("-fx-background-color: Red");
                b02.setDisable(true);
                b02.setOpacity(1);
                counter++;
                dSelect.setText(String.valueOf(counter));
                list[2] = 1;
            }
    }

    @FXML
    public void button03()  {
        if(counter <= maxDays) {
                 b03.setStyle("-fx-background-color: Red");
                 b03.setDisable(true);
                 b03.setOpacity(1);
                 counter++;
                 dSelect.setText(String.valueOf(counter));
                 list[3] = 1;
        }
    }

    @FXML
    public void button04()  {
        if(counter <= maxDays) {
            b04.setStyle("-fx-background-color: Red");
            b04.setDisable(true);
            b04.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[4] = 1;
        }
    }

    @FXML
    public void button05()  {
        if(counter <= maxDays) {
            b05.setStyle("-fx-background-color: Red");
            b05.setDisable(true);
            b05.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[5] = 1;
        }
    }

    @FXML
    public void button06()  {
        if(counter <= maxDays) {
            b06.setStyle("-fx-background-color: Red");
            b06.setDisable(true);
            b06.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[6] = 1;
        }
    }

    @FXML
    public void button07()  {
        if(counter <= maxDays) {
            b07.setStyle("-fx-background-color: Red");
            b07.setDisable(true);
            b07.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[7] = 1;
        }
    }

    @FXML
    public void button08()  {
        if(counter <= maxDays) {
            b08.setStyle("-fx-background-color: Red");
            b08.setDisable(true);
            b08.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[8] = 1;
        }
    }

    @FXML
    public void button09()  {
        if(counter <= maxDays) {
            b09.setStyle("-fx-background-color: Red");
            b09.setDisable(true);
            b09.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[9] = 1;
        }
    }

    @FXML
    public void button10()  {
        if(counter <= maxDays) {
            b10.setStyle("-fx-background-color: Red");
            b10.setDisable(true);
            b10.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[10] = 1;
        }
    }

    @FXML
    public void button11()  {
        if(counter <= maxDays) {
            b11.setStyle("-fx-background-color: Red");
            b11.setDisable(true);
            b11.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[11] = 1;
        }
    }

    @FXML
    public void button12()  {
        if(counter <= maxDays) {
            b12.setStyle("-fx-background-color: Red");
            b12.setDisable(true);
            b12.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[12] = 1;
        }
    }


    @FXML
    public void button13()  {
        if(counter <= maxDays) {
            b13.setStyle("-fx-background-color: Red");
            b13.setDisable(true);
            b13.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[13] = 1;
        }
    }

    @FXML
    public void button14()  {
        if(counter <= maxDays) {
            b14.setStyle("-fx-background-color: Red");
            b14.setDisable(true);
            b14.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[14] = 1;
        }
    }

    @FXML
    public void button15()  {
        if(counter <= maxDays) {
            b15.setStyle("-fx-background-color: Red");
            b15.setDisable(true);
            b15.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[15] = 1;
        }
    }

    @FXML
    public void button16()  {
        if(counter <= maxDays) {
            b16.setStyle("-fx-background-color: Red");
            b16.setDisable(true);
            b16.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[16] = 1;
        }
    }

    @FXML
    public void button17()  {
        if(counter <= maxDays) {
            b17.setStyle("-fx-background-color: Red");
            b17.setDisable(true);
            b17.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[17] = 1;
        }
    }

    @FXML
    public void button18()  {
        if(counter <= maxDays) {
            b18.setStyle("-fx-background-color: Red");
            b18.setDisable(true);
            b18.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[18] = 1;
        }
    }

    @FXML
    public void button19()  {
        if(counter <= maxDays) {
            b19.setStyle("-fx-background-color: Red");
            b19.setDisable(true);
            b19.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[19] = 1;
        }
    }

    @FXML
    public void button20()  {
        if(counter <= maxDays) {
            b20.setStyle("-fx-background-color: Red");
            b20.setDisable(true);
            b20.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[20] = 1;
        }
    }

    @FXML
    public void button21()  {
        if(counter <= maxDays) {
            b21.setStyle("-fx-background-color: Red");
            b21.setDisable(true);
            b21.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[21] = 1;
        }
    }

    @FXML
    public void button22()  {
        if(counter <= maxDays) {
            b22.setStyle("-fx-background-color: Red");
            b22.setDisable(true);
            b22.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[22] = 1;
        }
    }

    @FXML
    public void button23()  {
        if(counter <= maxDays) {
            b23.setStyle("-fx-background-color: Red");
            b23.setDisable(true);
            b23.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[23] = 1;
        }
    }

    @FXML
    public void button24()  {
        if(counter <= maxDays) {
            b24.setStyle("-fx-background-color: Red");
            b24.setDisable(true);
            b24.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[24] = 1;
        }
    }

    @FXML
    public void button25()  {
        if(counter <= maxDays) {
            b25.setStyle("-fx-background-color: Red");
            b25.setDisable(true);
            b25.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[25] = 1;
        }
    }

    @FXML
    public void button26()  {
        if(counter <= maxDays) {
            b26.setStyle("-fx-background-color: Red");
            b26.setDisable(true);
            b26.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[26] = 1;
        }
    }

    @FXML
    public void button27()  {
        if(counter <= maxDays) {
            b27.setStyle("-fx-background-color: Red");
            b27.setDisable(true);
            b27.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[27] = 1;
        }
    }

    @FXML
    public void button28()  {
        if(counter <= maxDays) {
            b28.setStyle("-fx-background-color: Red");
            b28.setDisable(true);
            b28.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[28] = 1;
        }
    }

    @FXML
    public void button29()  {
        if(counter <= maxDays) {
            b29.setStyle("-fx-background-color: Red");
            b29.setDisable(true);
            b29.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[29] = 1;
        }
    }

    @FXML
    public void button30()  {
        if(counter <= maxDays) {
            b30.setStyle("-fx-background-color: Red");
            b30.setDisable(true);
            b30.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[30] = 1;
        }
    }

    @FXML
    public void button31()  {
        if(counter <= maxDays + 1) {
            b31.setStyle("-fx-background-color: Red");
            b31.setDisable(true);
            b31.setOpacity(1);
            counter++;
            dSelect.setText(String.valueOf(counter));
            list[31] = 1;
        }
    }


    @FXML
    public void exitButtonAction(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DevStart.fxml"));
        try {
            root = (Parent) loader.load();
            Stage window = (Stage) exitButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            if(counter == maxDays + 1) {
                alert.setHeaderText("You are about to go back to DEV aplication!");
                alert.setContentText("Leave for sure ? ");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    window.setTitle("Login");
                    window.setScene(new Scene(root, 634, 428));
                }
            }
            else{
                int remainDays = maxDays-counter + 1;
                alert.setHeaderText("You have to select more " + remainDays + "days!");
                alert.setContentText("Press OK to continue!");
                if (alert.showAndWait().get() == ButtonType.OK);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}