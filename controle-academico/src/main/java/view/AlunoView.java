package view;



import javax.swing.JOptionPane;

import model.Aluno;
import model.Endereco;
import repository.AlunoRepository;
import service.EnderecoService;

public class AlunoView {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome do Aluno:");
        // String endereco = JOptionPane.showInputDialog("Digite o endereço do aluno:");
        String cep = JOptionPane.showInputDialog("Digite o CEP do aluno:");
        Endereco endereco = EnderecoService.buscarEnderecoPorCEP(cep);
        String idadeString = JOptionPane.showInputDialog("Digite a idade do aluno:");
        int idade = Integer.parseInt(idadeString);

        Aluno aluno = new Aluno(nome, endereco.toString(), idade);
        
        // Persistência de dados em arquivo - .txt
        AlunoRepository.salvar(aluno);

        // Exportar para CSV
        AlunoRepository.exportarParaCSV();
    }
}
