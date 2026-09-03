package org.example.cinema;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.cinema.utilitarios.processamento.Arquivos;

import java.io.IOException;
import java.util.List;

public class LoginController {
    @FXML
    private TextField campoUserLogin;
    @FXML private PasswordField campoSenhaLogin;
    @FXML
    public void login(ActionEvent evento) throws IOException {
        List<List<String>> usuarios = Arquivos.obterLinhaDoArquivo("dados/usuarios.txt");
        boolean deuCerto = false;
        for (List<String> i : usuarios){
            if (campoUserLogin.getText().equals(i.get(0)) && campoSenhaLogin.getText().equals(i.get(1))){
                deuCerto = true;
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                stage.setScene(scene);
                stage.setFullScreen(false);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
                stage.show();
                }

        }
        if (!deuCerto){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro!");
            alerta.setHeaderText("Usuário ou Senha incorretos!");
            alerta.setContentText("Seu usuário ou senha estão incorretos!");
            alerta.initOwner(((Node) evento.getSource()).getScene().getWindow());
            alerta.show();
        }
    }
    @FXML
    public void cadastrarPagina(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cadastrar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }


}
