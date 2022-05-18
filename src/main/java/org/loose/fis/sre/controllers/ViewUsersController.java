package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class ViewUsersController {

    @FXML
    private TableColumn<User, String> user_col;

    @FXML
    private TableColumn<User, String> role_col;

    @FXML
    private  TableColumn<User, ArrayList<Integer>> dates_col;

    @FXML
    private Button backButton;

    @FXML
    private TableView<User> userTableView;

    @FXML
    private Label textLabel;

    private Parent root;

    private static ObjectRepository<User> userObjectRepository = UserService.getUserRepository();

    @FXML
    public void initialize() {
        textLabel.setText("Hello, Admin!");
        loadData();
    }

    private void loadData(){
        user_col.setCellValueFactory(new PropertyValueFactory<>("username"));
        role_col.setCellValueFactory(new PropertyValueFactory<>("role"));
        dates_col.setCellValueFactory(new PropertyValueFactory<>("list"));

        ObservableList<User> usersList = FXCollections.observableArrayList();

        for(User user: userObjectRepository.find()){
            usersList.add(user);
        }
        userTableView.setItems(usersList);

    }

    @FXML
    public void iniateBackToAdmin(){
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

    @FXML
    public void initiateDeleteUserProcedure() {
        for(User user: userTableView.getSelectionModel().getSelectedItems()){
            UserService.deleteUser(user);
        }
        userTableView.getItems().removeAll(userTableView.getSelectionModel().getSelectedItems());
    }


}
