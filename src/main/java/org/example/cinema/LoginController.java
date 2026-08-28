package org.example.cinema;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    public void login(ActionEvent evento) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }
    public void cadastrarPagina(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cadastrar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }


}
