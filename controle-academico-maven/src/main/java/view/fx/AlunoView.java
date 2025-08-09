package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Aluno;

public class AlunoView {
    private TableView<Aluno> tabela;

    public void start(Stage stage) {
        //Formulário de Cadastro
        TextField nomeField = new TextField();
        TextField idadeField = new TextField();
        TextField cepField = new TextField();
        TextField numeroField = new TextField();
        TextField complementoField = new TextField();

        Button btnCadastrar = new Button("Cadastrar");
        Label lblMensagem = new Label();

        GridPane form = new GridPane();
        form.setPadding(new Insets(10)); // Espaçamento Interno
        form.setHgap(10); //Espaçamento Horizontal
        form.setVgap(10); //Espaçamento Vertical

        form.add(new Label("Nome:"),0,0);
        form.add(nomeField,1,0);
        form.add(new Label("Idade"),0,1);
        form.add(idadeField,1,1);
        form.add(new Label("CEP"),0,2);
        form.add(cepField,1,2);
        form.add(new Label("Número"),0,3);
        form.add(numeroField,1,3);
        form.add(new Label("Complemento:"),0,4);
        form.add(complementoField,1,4);
        form.add(btnCadastrar,1,5);
        form.add(lblMensagem,1,6);

        // Tabela
        tabela = new TableView<>();
    }
}
