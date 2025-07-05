package view;



import javax.swing.JOptionPane;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoView implements ContratosInterface {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome do Aluno:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do aluno:");
        String idadeString = JOptionPane.showInputDialog("Digite a idade do aluno:");
        int idade = Integer.parseInt(idadeString);

        Aluno aluno = new Aluno(nome, endereco, idade);
        
        // Persistência de dados em arquivo - .txt
        AlunoRepository.salvar(aluno);
    }

    public static void salvar() {};

}
