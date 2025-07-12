package view;

import javax.swing.JOptionPane;

import model.Disciplina;
import repository.DisciplinaRepository;

public class DisciplinaView {
    public static void executar() throws Exception {
        String nome = JOptionPane.showInputDialog("Digite o nome da Disciplina:");
        String cargaHorariaString = JOptionPane.showInputDialog("Digite a CH da Disciplina:");
        int cargaHoraria = Integer.parseInt(cargaHorariaString);
        String categoria = JOptionPane.showInputDialog("Digite a categoria da Disciplina:");

        Disciplina d = new Disciplina(nome, cargaHoraria, categoria);
        DisciplinaRepository.salvar(d);
    }
}
