package view;



import javax.swing.JOptionPane;

import model.Aluno;
import model.Endereco;
import repository.AlunoRepository;
import service.EnderecoService;

public class AlunoView implements ContratosInterface {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome do Aluno:");
        String idadeString = JOptionPane.showInputDialog("Digite a idade do aluno:");
        int idade = Integer.parseInt(idadeString);
        
        String cepString = JOptionPane.showInputDialog("Digite o CEP do aluno:");
        String numeroString = JOptionPane.showInputDialog("Digite o número do endereço do aluno:");
        String complementoString = JOptionPane.showInputDialog("Digite  complemento do endereço do aluno:");

        Endereco endereco = new Endereco(cepString, numeroString, complementoString);
        // retornar os dados do Endereco
        EnderecoService.completarEnderecoViaCep(endereco);
        
        Aluno aluno = new Aluno(nome, endereco, idade);
        
        // Persistência de dados em arquivo - .txt
        AlunoRepository.salvar(aluno);

        // Exportar para CSV
        AlunoRepository.exportarParaCSV();
    }
}
