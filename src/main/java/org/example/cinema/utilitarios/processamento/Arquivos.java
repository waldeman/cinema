package org.example.cinema.utilitarios.processamento;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arquivos {
    //Criação de métodos para o processamento dos dados dos arquivos
    public static List<List<String>> obterLinhaDoArquivo(String caminhoDoArquivo) {
        List<List<String>> listaPrincipal = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] usuarioSenha = linha.split(",");
                List<String> subLista = new ArrayList<>();
                subLista.add(usuarioSenha[0]);
                subLista.add(usuarioSenha[1]);
                listaPrincipal.add(subLista);
            }

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        return listaPrincipal;

    }
    public static List<String> obterCadeiras(String caminhoDoArquivo) {
        List<String> cadeiras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                cadeiras.add(linha);
            }

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        return cadeiras;
    }
    public static void registrarCadeira (String cadeiraSelecionada, String caminhoDoArquivo) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(caminhoDoArquivo, true))) {
            br.write(cadeiraSelecionada);
            br.newLine();

        } catch (IOException e) {
            System.err.println("Erro ao escrever com buffer: " + e.getMessage());
        }
    }
    public static void cadastrarUsuario(String caminho, String nome, String senha) {
        try {
            FileWriter arquivo = new FileWriter(caminho, true);
            BufferedWriter escritor = new BufferedWriter(arquivo);
            escritor.newLine();
            escritor.write(nome + "," + senha);
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao cadastrar usuario");
        }
    }
    public static boolean verificarSenha(String senha) {

        // Verifica se a senha tem letras maiusculas e minusculas e se a senha tem 8 caracter

        if (senha.length() < 8) {
            return false;
        }

        boolean temMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {

            char c = senha.charAt(i);

            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }
        }
        boolean temMinuscula = false;
        for (int i = 0; i < senha.length(); i++) {

            char c = senha.charAt(i);

            if (Character.isLowerCase(c)) {
                temMinuscula = true;
            }
        }
        return temMaiuscula && temMinuscula;
    }
    public static String nomeFilme(String filme){
        return filme.replace(" ", "");
    }
}
