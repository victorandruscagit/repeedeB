package ru.javabegin.training.fastjava2.javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;

public class MainController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnEdit;

    @FXML
    private  Button btnDelete;

    @FXML
    private TableView tableAdressBook;

    @FXML
    private Label labelCount;

    @FXML
    private TextField txtSearch;








    public void showDialog(ActionEvent event) {
        try {
            btnAdd.setText("apasat");
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
