package ru.javabegin.training.fastjava2.javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class MainController {
    public  void showDialog(ActionEvent event){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Redacteaa inregistrarea");
            stage.setMinHeight(150);
            stage.setMinHeight(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            //ce huinea prosteasca de invocare...ebati
             stage.initOwner(((Node) event.getSource()).getScene().getWindow());
             stage.show();
        } catch (IOException e) {
            System.out.printf("Exc.", e.getLocalizedMessage() + e.getMessage());
        }
    }
}
