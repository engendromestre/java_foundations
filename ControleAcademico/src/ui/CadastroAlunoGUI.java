package ui;

import model.Aluno;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CadastroAlunoGUI {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Nome do aluno:");
        String matricula = JOptionPane.showInputDialog("Matrícula do aluno:");
        String idadeStr = JOptionPane.showInputDialog("Idade do aluno:");
        int idade = Integer.parseInt(idadeStr);
        Aluno aluno = new Aluno(nome, idade, matricula);
        aluno.exibirDados();

        // Escrevendo em arquivo Parte 1
        // PrintWriter out = new PrintWriter("aluno.txt");
        // out.println(nome);
        // out.println(idade);
        // out.println(matricula);
        // out.close();

        // Escrevendo em arquivo CSV com cabeçalho - Parte 2
        File arquivo = new File("alunos.csv");
        boolean novoArquivo = arquivo.createNewFile();
        FileWriter fw = new FileWriter(arquivo, true);
        PrintWriter out = new PrintWriter(fw);

        if (novoArquivo) {
            out.println("nome,idade,matricula,notaFinal");
        }
        out.println(nome + "," + idade + "," + matricula);
        out.close();

        // Lendo do arquivo
        System.out.println("\n--- Lido do arquivo ---");
        // Scanner sc = new Scanner(new File("aluno.txt")); - Parte 1
        Scanner sc = new Scanner(new File("alunos.csv"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
