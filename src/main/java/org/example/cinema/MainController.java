package org.example.cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.cinema.utilitarios.processamento.Arquivos;

import java.io.IOException;

public class MainController {

    @FXML
    public void abrirAcentos(ActionEvent evento) throws IOException {
        Button botao = (Button) evento.getSource();
        String nome = botao.getText();
        String caminho = "dados/filmes/"+Arquivos.nomeFilme(nome)+"-assentos.txt";
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("assentos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AssentosController controller = fxmlLoader.getController();
        controller.setCaminho(caminho);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Assentos");
        stage.initOwner(((Node) evento.getSource()).getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
