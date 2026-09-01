package org.example.cinema.utilitarios.processamento;

import java.util.List;

public class Matriz {
    //Criação dos métodos para o gerenciamento da matriz de acentos
    public static boolean verificarCadeira (List<String> cadeirasOcupadas, String cadeiraSelecionada) {
        for (String texto : cadeirasOcupadas) {
            if (texto.equals(cadeiraSelecionada)) {
                return false;
            }
        }
        return true;
    }
}
