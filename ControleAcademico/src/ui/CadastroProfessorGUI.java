package ui;

import java.io.PrintWriter;
import javax.swing.JOptionPane;
import model.Professor;

public class CadastroProfessorGUI {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome do Professor:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do Professor:");
        String idadeString = JOptionPane.showInputDialog("Digite a idade do Professor:");
        int idade = Integer.parseInt(idadeString);
        String matriculaString = JOptionPane.showInputDialog("Digite a matricula do Professor");
        int matricula = Integer.parseInt(matriculaString);
        String cpf = JOptionPane.showInputDialog("Digite o CPF do Professor:");
        String atuacao = JOptionPane.showInputDialog("Digite a Atuação do Professor:");

        Professor professor = new Professor(nome,endereco,idade,matricula,cpf,atuacao);
        // Persistência de dados em arquivo - .txt
        PrintWriter saida = new PrintWriter("professor.txt");
        saida.println("nome, endereco, idade, matricula, cpf, atuação");
        saida.println(
            professor.getNome() + ", " + 
            professor.getEndereco() + ", " + 
            professor.getIdade() + ", " + 
            professor.getMatricula() + ", " + 
            professor.getCpf() + ", " + 
            professor.getAtuacao()
        );
        saida.close();
    }
}
