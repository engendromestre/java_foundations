package ui;

import java.io.PrintWriter;
import javax.swing.JOptionPane;
import model.Aluno;

public class CadastroAlunoGUI {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome do Aluno:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do aluno:");
        String idadeString = JOptionPane.showInputDialog("Digite a idade do aluno:");
        int idade = Integer.parseInt(idadeString);
        String matriculaString = JOptionPane.showInputDialog("Digite a matricula do aluno");
        int matricula = Integer.parseInt(matriculaString);

        Aluno aluno = new Aluno(nome, endereco, idade, matricula);
        // aluno.visualizar();

        // Persistência de dados em arquivo - .txt
        PrintWriter saida = new PrintWriter("alunos.txt");
        saida.println("nome, endereco, idade, matricula");
        saida.println(
            aluno.getNome() + ", " + 
            aluno.getEndereco() + ", " + 
            aluno.getIdade() + ", " + 
            aluno.getMatricula()
        );
        saida.close();
    }
}
