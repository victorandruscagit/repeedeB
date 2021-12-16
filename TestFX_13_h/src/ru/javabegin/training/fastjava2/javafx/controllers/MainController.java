package ru.javabegin.training.fastjava2.javafx.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.javabegin.training.fastjava2.javafx.interfaces.impls.CollectionAddressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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

    private Stage mainStage;


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

    private ResourceBundle resourceBundle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        initListner();
        feedData();
        initLoader();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void initListner() {
        collectionAddressBook.getPersonlist().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });
        tableAdressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.
                            setPerson(((Person) tableAdressBook.getSelectionModel().getSelectedItem()));
                    showDialog();
                }
            }
        });
    }

    private void feedData() {
        collectionAddressBook.feedTestData();
        tableAdressBook.setItems(collectionAddressBook.getPersonlist());
    }

    public void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void updateCountLabel() {
        labelCount.setText(resourceBundle.getString("count") + ": " + collectionAddressBook.getPersonlist().size());
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
                editDialogController.setPerson(new Person());
                showDialog();
                collectionAddressBook.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                editDialogController.setPerson(((Person) tableAdressBook.getSelectionModel().getSelectedItem()));
                showDialog();
                break;
            case "btnDelete":
                collectionAddressBook.delete(((Person) tableAdressBook.getSelectionModel().getSelectedItem()));
                break;
        }
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Redacteaza  inregistrarea");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinHeight(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait();

    }


}








































































































































































































































































