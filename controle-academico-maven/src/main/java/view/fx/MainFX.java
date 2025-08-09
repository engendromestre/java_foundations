package view.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Menu principal
        MenuBar menuBar = new MenuBar();

        Menu menuCadastro = new Menu("Cadastros");
        MenuItem menuAluno = new MenuItem("Alunos");

        menuCadastro.getItems().add(menuAluno);
        menuBar.getMenus().add(menuCadastro);

        // Layout Principal
        BorderPane painel = new BorderPane();
        painel.setTop(menuBar);

        Scene tela = new Scene(painel, 800, 600);
        stage.setTitle("Controle Acadêmico 1.0");
        stage.setScene(tela);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
