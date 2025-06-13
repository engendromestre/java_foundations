package main;

import ui.CadastroAlunoGUI;

public class App {
    public static void main(String[] args) throws Exception {
        // Inicia a interface gráfica para cadastro de aluno
        CadastroAlunoGUI.executar();
        
        // Exibe uma mensagem de encerramento
        System.out.println("Cadastro concluído. Pressione Enter para sair.");
        System.in.read(); // Aguarda o usuário pressionar Enter antes de fechar
        // Limpar a tela
        System.out.print("\033[H\033[2J"); // ANSI escape code para limpar a tela
        System.out.flush(); // Garante que o comando de limpeza seja executado
    }
}
