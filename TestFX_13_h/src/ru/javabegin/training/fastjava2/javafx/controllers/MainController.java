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
import javafx.stage.Window;
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
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    @FXML
    private void initialize() {
        //tableAdressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        collectionAddressBook.getPersonlist()
                .addListener(((ListChangeListener) c -> updateCountLabel()));
        collectionAddressBook.feedTestData();
        tableAdressBook.setItems(collectionAddressBook.getPersonlist());

        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void updateCountLabel() {
        labelCount.setText("Numar de inregistrari: " + collectionAddressBook.getPersonlist().size());
    }

    public void actionButtonPressed(ActionEvent event) {
        Object source = event.getSource();
        if (!(source instanceof Button)) {
            return;
        }
        Button clickedButton = (Button) source;
        Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) event.getSource()).getScene().getWindow();
        editDialogController.setPerson(selectedPerson);

        switch (clickedButton.getId()) {
            case "btnAdd":
                break;
            case "btnEdit":
                showDialog(parentWindow);
                break;
            case "btnDelete":
                break;
        }
    }

    private void showDialog(Window parentWindow) {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Redacteza  inregistrarea");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinHeight(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(parentWindow);
            editDialogStage.show();
        }

    }
}








































































































































































































































































