package org.example.cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.cinema.utilitarios.processamento.Arquivos;

import java.io.IOException;
import java.util.List;

public class CadastroController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField campoTextoCadastro;
    @FXML
    private PasswordField campoSenhaCadastro;
    @FXML
    public void cadastrar(ActionEvent evento) throws IOException {
        boolean usuarioExiste = false;
        if (campoTextoCadastro.getText().isBlank()){
            usuarioExiste = true;
        }else {
            List<List<String>> usuarios = Arquivos.obterLinhaDoArquivo("dados/usuarios.txt");
            for (List<String> i : usuarios) {
                if (campoTextoCadastro.getText().equals(i.get(0)) && Arquivos.verificarSenha(campoSenhaCadastro.getText())) {
                    usuarioExiste = true;
                }
            }
        }

        if (!usuarioExiste) {
            Arquivos.cadastrarUsuario("dados/usuarios.txt",campoTextoCadastro.getText(), campoSenhaCadastro.getText());
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
    public void entrarPagina(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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
