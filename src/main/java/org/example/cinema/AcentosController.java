package org.example.cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import org.example.cinema.utilitarios.processamento.Arquivos;
import org.example.cinema.utilitarios.processamento.Matriz;

import java.util.ArrayList;
import java.util.List;

public class AcentosController {
    @FXML
    private GridPane cadeiras;
    List<String> cadeirasSelecionadas;
    @FXML
    public void initialize() {
        cadeiras.getColumnConstraints().clear();
        cadeiras.getRowConstraints().clear();
        cadeiras.setAlignment(Pos.CENTER);
        cadeirasSelecionadas = new ArrayList<>();
        List<String> cadeirasOcupadas = Arquivos.obterCadeiras("dados/filmes/assentos.txt");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String nome = letra(i) + (j + 1);
                Circle circle = new Circle(15);
                circle.setId(nome);
                if (Matriz.verificarCadeira(cadeirasOcupadas, circle.getId())) {
                    circle.getStyleClass().add("disponivel");
                } else {
                    circle.getStyleClass().add("ocupada");
                }

                circle.setOnMouseClicked(event -> {
                    if (circle.getStyleClass().contains("ocupada")) {
                        circle.setMouseTransparent(true);
                    }

                    if (circle.getStyleClass().contains("disponivel")) {

                        circle.getStyleClass().remove("disponivel");
                        circle.getStyleClass().add("selecionada");
                        cadeirasSelecionadas.add(nome);

                    } else {
                        circle.getStyleClass().remove("selecionada");
                        circle.getStyleClass().add("disponivel");
                        cadeirasSelecionadas.remove(nome);
                    }
                });
                cadeiras.add(circle, i, j);
            }
        }

    }
    @FXML
    public void comprar(ActionEvent event) {

        if (!cadeirasSelecionadas.isEmpty()) {

            for (String cadeira : cadeirasSelecionadas) {

                Arquivos.registrarCadeira(cadeira, "dados/assentos.txt");
                for (var node : cadeiras.getChildren()) {
                    if (node instanceof Circle circle &&
                            circle.getId().equals(cadeira)) {
                        circle.getStyleClass().remove("selecionada");
                        circle.getStyleClass().add("ocupada");
                    }
                }
            }
            cadeirasSelecionadas.clear();
        }
    }
    public static String letra(int i) {
        switch (i) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            default:
                return "Flamengo";
        }
    }
}
