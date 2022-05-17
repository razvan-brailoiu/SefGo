package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.Month;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.User;


public class HelloController {

    private User user;
    public int counter = 0;
    public int daysToWork = 10;
    public int month = 1;
    public int year = 2022;

    @FXML
    TextField dSelect;

    @FXML
    TextField tDays;
    @FXML
    TextField currentDate;


    public void initialize(int month, int year, int daysToWork)
    {
        this.month = month;
        this.year = year;
        this.daysToWork = daysToWork;
        dSelect.setText(String.valueOf(counter));
        tDays.setText(String.valueOf(tDays));
        currentDate.setText(String.valueOf(month) + "/" + String.valueOf(year));
        tDays.setText(String.valueOf(daysToWork));
    }

    @FXML
    public void initialize()
    {
        LocalDate currentGlobalDate = LocalDate.now();
        dSelect.setText(String.valueOf(counter));
        tDays.setText(String.valueOf(daysToWork));
        currentDate.setText(String.valueOf(currentGlobalDate.getMonth()) + "/" + String.valueOf(currentGlobalDate.getYear()));
        tDays.setText(String.valueOf(daysToWork));
    }



    @FXML
    public void button01(ActionEvent event)  {
        Button b01 = (Button) event.getSource();
        b01.setStyle("-fx-background-color: Red");
        b01.setDisable(true);
        counter++;
        dSelect.setText(String.valueOf(counter));
    }

    @FXML
    public void button02(ActionEvent event)  {
        Button b01 = (Button) event.getSource();
        b01.setStyle("-fx-background-color: Red");
        b01.setDisable(true);
        counter++;
        dSelect.setText(String.valueOf(counter));
    }

    @FXML
    public void button03(ActionEvent event)  {

        System.out.println("apasat pe buton");
    }

    @FXML
    public void button04(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button05(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button06(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button07(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button08(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button09(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button10(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button11(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button12(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }


    @FXML
    public void button13(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button14(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button15(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button16(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button17(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button18(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button19(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button20(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button21(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button22(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button23(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button24(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button25(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button26(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button27(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button28(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button29(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button30(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }

    @FXML
    public void button31(ActionEvent event)  {
        System.out.println("apasat pe buton");
    }


}