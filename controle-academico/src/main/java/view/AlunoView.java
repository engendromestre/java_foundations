package view;



import javax.swing.JOptionPane;

import model.Aluno;
import model.Endereco;
import repository.AlunoRepository;
import service.EnderecoService;

public class AlunoView {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Nome do aluno:");
        String idadeStr = JOptionPane.showInputDialog("Idade:");
        int idade = Integer.parseInt(idadeStr);

        String cep = JOptionPane.showInputDialog("CEP:");
        String numero = JOptionPane.showInputDialog("Número:");
        String complemento = JOptionPane.showInputDialog("Complemento (opcional):");

        Endereco endereco = new Endereco(cep, numero, complemento);
        EnderecoService.completarEnderecoViaCEP(endereco);

        Aluno aluno = new Aluno(nome, endereco, idade);
        
        // Persistência de dados em arquivo - .txt
        AlunoRepository.salvar(aluno);

        // Exportar para CSV
        AlunoRepository.exportarParaCSV();
    }
}
