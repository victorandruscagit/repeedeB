package ru.javabegin.training.fastjava2.javafx.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javabegin.training.fastjava2.javafx.interfaces.impls.CollectionAddressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.io.IOException;

public class MainController {

    private CollectionAddressBook collectionAddressBook = new CollectionAddressBook();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView tableAdressBook;

    @FXML
    private Label labelCount;

    @FXML
    private TextField txtSearch;
    @FXML
    private TableColumn<Person, String> columnFio;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private void initialize() {
        //tableAdressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        collectionAddressBook.getPersonlist().addListener(((ListChangeListener) c -> updateCountLabel()));
        collectionAddressBook.feedTestData();
        tableAdressBook.setItems(collectionAddressBook.getPersonlist());


    }


    private void updateCountLabel() {
        labelCount.setText("Numar de inregistrari: " + collectionAddressBook.getPersonlist().size());
    }

    public void showDialog(ActionEvent event) {
        Object source = event.getSource();
        if (!(source instanceof Button)) {
            return;
        }
        Button clickedButton = (Button) source;
        Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();

        switch (clickedButton.getId()) {
            case "btnAdd":
                System.out.println("add " + selectedPerson);
                break;
            case "btnEdit":
                System.out.println("edit  " + selectedPerson);
                break;
            case "btnDelete":
                System.out.println("delete  " + selectedPerson);
                break;

        }


        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Redactarea inregistrarea");
            stage.setMinHeight(150);
            stage.setMinHeight(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            //ce huinea prosteasca de invocare...ebati
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
