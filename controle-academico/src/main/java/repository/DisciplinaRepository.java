package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Disciplina;

public class DisciplinaRepository {
     private static final String ARQUIVO_TXT = "disciplina.txt";

    // Injeção de Dependência
    public static void salvar(Disciplina d) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT,true))) {
            if(new File(ARQUIVO_TXT).length() == 0) {
                out.println("id,nome,cargaHoraria,categoria");
            }
            out.printf(
                "%d,%s,%d,%s%n",
                d.getId(),
                d.getNome(),
                d.getCargaHoraria(),
                d.getCategoria()
            );
        } catch(IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }

    
}
