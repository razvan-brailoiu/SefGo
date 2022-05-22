package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UserNotInDatabaseException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.Objects;


public class ComingControlle {

    @FXML
    private Button backButton;
    @FXML
    private TableView<User> table1;
    @FXML
    private TableColumn<User, String> user_col;
    @FXML
    private TableView<User> table2;
    @FXML
    private TableView<User> table3;
    @FXML
    private TableView<User> table4;
    @FXML
    private TableView<User> table5;
    @FXML
    private TableView<User> table6;
    @FXML
    private TableView<User> table7;
    @FXML
    private TableView<User> table8;
    @FXML
    private TableView<User> table9;
    @FXML
    private TableView<User> table10;
    @FXML
    private TableView<User> table11;
    @FXML
    private TableView<User> table12;
    @FXML
    private TableView<User> table13;
    @FXML
    private TableView<User> table14;
    @FXML
    private TableView<User> table15;
    @FXML
    private TableView<User> table16;
    @FXML
    private TableView<User> table17;
    @FXML
    private TableView<User> table18;
    @FXML
    private TableView<User> table19;
    @FXML
    private TableView<User> table20;
    @FXML
    private TableView<User> table21;
    @FXML
    private TableView<User> table22;
    @FXML
    private TableView<User> table23;
    @FXML
    private TableView<User> table24;
    @FXML
    private TableView<User> table25;
    @FXML
    private TableView<User> table26;
    @FXML
    private TableView<User> table27;
    @FXML
    private TableView<User> table28;
    @FXML
    private TableView<User> table29;
    @FXML
    private TableView<User> table30;
    @FXML
    private TableView<User> table31;
    @FXML
    private TableColumn<User, String> user_col1;
    @FXML
    private TableColumn<User, String> user_col2;
    @FXML
    private TableColumn<User, String> user_col3;
    @FXML
    private TableColumn<User, String> user_col4;
    @FXML
    private TableColumn<User, String> user_col5;
    @FXML
    private TableColumn<User, String> user_col6;
    @FXML
    private TableColumn<User, String> user_col7;
    @FXML
    private TableColumn<User, String> user_col8;
    @FXML
    private TableColumn<User, String> user_col9;
    @FXML
    private TableColumn<User, String> user_col10;
    @FXML
    private TableColumn<User, String> user_col11;
    @FXML
    private TableColumn<User, String> user_col12;
    @FXML
    private TableColumn<User, String> user_col13;
    @FXML
    private TableColumn<User, String> user_col14;
    @FXML
    private TableColumn<User, String> user_col15;
    @FXML
    private TableColumn<User, String> user_col16;
    @FXML
    private TableColumn<User, String> user_col17;
    @FXML
    private TableColumn<User, String> user_col18;
    @FXML
    private TableColumn<User, String> user_col19;
    @FXML
    private TableColumn<User, String> user_col20;
    @FXML
    private TableColumn<User, String> user_col21;
    @FXML
    private TableColumn<User, String> user_col22;
    @FXML
    private TableColumn<User, String> user_col23;
    @FXML
    private TableColumn<User, String> user_col24;
    @FXML
    private TableColumn<User, String> user_col25;
    @FXML
    private TableColumn<User, String> user_col26;
    @FXML
    private TableColumn<User, String> user_col27;
    @FXML
    private TableColumn<User, String> user_col28;
    @FXML
    private TableColumn<User, String> user_col29;
    @FXML
    private TableColumn<User, String> user_col30;






    private static ObjectRepository<User> userObjectRepository = UserService.getUserRepository();


    private void loadData(int day) throws UserNotInDatabaseException {
        user_col.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

            String userList = UserService.getListByDate(day);
        
            String[] allUsers = userList.split(",");
            for(int i = 0; i < allUsers.length; i++) {
                usersList.add(UserService.getUserbyUsername(allUsers[i]));
                table1.setItems(usersList);
            }
    }
    @FXML
    private void loadData1(int day) throws UserNotInDatabaseException {
        user_col1.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            System.out.println(allUsers[i]);
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table2.setItems(usersList);
        }
    }
    @FXML
    private void loadData2(int day) throws UserNotInDatabaseException {
        user_col2.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table3.setItems(usersList);
        }
    }
    @FXML
    private void loadData3(int day) throws UserNotInDatabaseException {
        user_col3.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table4.setItems(usersList);
        }
    }
    @FXML
    private void loadData4(int day) throws UserNotInDatabaseException {
        user_col4.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table5.setItems(usersList);
        }
    }
    @FXML
    private void loadData5(int day) throws UserNotInDatabaseException {
        user_col5.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table6.setItems(usersList);
        }
    }

    private void loadData6(int day) throws UserNotInDatabaseException {
        user_col6.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table7.setItems(usersList);
        }
    }

    private void loadData7(int day) throws UserNotInDatabaseException {
        user_col7.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table8.setItems(usersList);
        }
    }

    private void loadData8(int day) throws UserNotInDatabaseException {
        user_col8.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table9.setItems(usersList);
        }
    }

    private void loadData9(int day) throws UserNotInDatabaseException {
        user_col9.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table10.setItems(usersList);
        }
    }

    private void loadData10(int day) throws UserNotInDatabaseException {
        user_col10.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table11.setItems(usersList);
        }
    }

    private void loadData11(int day) throws UserNotInDatabaseException {
        user_col11.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table12.setItems(usersList);
        }
    }

    private void loadData12(int day) throws UserNotInDatabaseException {
        user_col12.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table13.setItems(usersList);
        }
    }

    private void loadData13(int day) throws UserNotInDatabaseException {
        user_col13.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table14.setItems(usersList);
        }
    }

    private void loadData14(int day) throws UserNotInDatabaseException {
        user_col14.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table15.setItems(usersList);
        }
    }

    private void loadData15(int day) throws UserNotInDatabaseException {
        user_col15.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table16.setItems(usersList);
        }
    }

    private void loadData16(int day) throws UserNotInDatabaseException {
        user_col16.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table17.setItems(usersList);
        }
    }

    private void loadData17(int day) throws UserNotInDatabaseException {
        user_col17.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table18.setItems(usersList);
        }
    }

    private void loadData18(int day) throws UserNotInDatabaseException {
        user_col18.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table19.setItems(usersList);
        }
    }

    private void loadData19(int day) throws UserNotInDatabaseException {
        user_col19.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table20.setItems(usersList);
        }
    }
    @FXML
    private void loadData20(int day) throws UserNotInDatabaseException {
        user_col20.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table21.setItems(usersList);
        }
    }
    @FXML
    private void loadData21(int day) throws UserNotInDatabaseException {
        user_col21.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table22.setItems(usersList);
        }
    }
    @FXML
    private void loadData22(int day) throws UserNotInDatabaseException {
        user_col22.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table23.setItems(usersList);
        }
    }
    @FXML
    private void loadData23(int day) throws UserNotInDatabaseException {
        user_col23.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table24.setItems(usersList);
        }
    }
    @FXML
    private void loadData24(int day) throws UserNotInDatabaseException {
        user_col24.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();
        String userList = UserService.getListByDate(day);
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table25.setItems(usersList);
        }
    }
    @FXML
    private void loadData25(int day) throws UserNotInDatabaseException {
        user_col25.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table26.setItems(usersList);
        }
    }
    @FXML
    private void loadData26(int day) throws UserNotInDatabaseException {
        user_col26.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table27.setItems(usersList);
        }
    }

    private void loadData27(int day) throws UserNotInDatabaseException {
        user_col27.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table28.setItems(usersList);
        }
    }

    private void loadData28(int day) throws UserNotInDatabaseException {
        user_col28.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table29.setItems(usersList);
        }
    }

    private void loadData29(int day) throws UserNotInDatabaseException {
        user_col29.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table30.setItems(usersList);
        }
    }

    private void loadData30(int day) throws UserNotInDatabaseException {
        user_col30.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        ObservableList<User> usersList = FXCollections.observableArrayList();

        String userList = UserService.getListByDate(day);
        
        String[] allUsers = userList.split(",");
        for(int i = 0; i < allUsers.length; i++) {
            usersList.add(UserService.getUserbyUsername(allUsers[i]));
            table31.setItems(usersList);
        }
    }



    @FXML
    public void tab1() throws UserNotInDatabaseException {
        loadData(1);
    }
    @FXML
    public void tab2() throws UserNotInDatabaseException {
        loadData1(2);
    }

    @FXML
    public void tab3() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData2(3);
    }

    @FXML
    public void tab4() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData3(4);
    }

    @FXML
    public void tab5() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData4(5);
    }

    @FXML
    public void tab6() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData5(6);
    }

    @FXML
    public void tab7() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData6(7);
    }

    @FXML
    public void tab8() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData7(8);
    }

    @FXML
    public void tab9() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData8(9);
    }

    @FXML
    public void tab10() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData9(10);
    }

    @FXML
    public void tab11() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData10(11);
    }

    @FXML
    public void tab12() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData11(12);
    }

    @FXML
    public void tab13() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData12(13);
    }

    @FXML
    public void tab14() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData13(14);
    }

    @FXML
    public void tab15() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData14(15);
    }

    @FXML
    public void tab16() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData15(16);
    }

    @FXML
    public void tab17() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData16(17);
    }

    @FXML
    public void tab18() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData17(18);
    }

    @FXML
    public void tab19() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData18(19);
    }

    @FXML
    public void tab20() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData19(20);
    }

    @FXML
    public void tab21() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData20(21);
    }

    @FXML
    public void tab22() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData21(22);
    }

    @FXML
    public void tab23() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData22(23);
    }

    @FXML
    public void tab24() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData23(24);
    }

    @FXML
    public void tab25() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData24(25);
    }

    @FXML
    public void tab26() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData25(26);
    }

    @FXML
    public void tab27() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData26(27);
    }

    @FXML
    public void tab28() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData27(28);
    }

    @FXML
    public void tab29() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData28(29);
    }

    @FXML
    public void tab30() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData29(30);
    }

    @FXML
    public void tab31() throws UserNotInDatabaseException {
        ObjectRepository<User> userObjectRepository = UserService.getUserRepository();
        loadData30(31);
    }

    @FXML
    public void backAction(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DevStart.fxml"));
        try {
            Parent root = loader.load();
            Stage window = (Stage) backButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");{
                alert.setHeaderText("You are about to go back to ADMIN application!");
                alert.setContentText("Leave for sure ? ");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    window.setTitle("Admin");
                    window.setScene(new Scene(root, 634, 428));
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}