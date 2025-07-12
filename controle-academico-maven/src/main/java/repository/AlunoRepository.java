package repository;

import java.io.*;

import interfaces.RepositoryInterface;
import model.Aluno;

public class AlunoRepository implements RepositoryInterface {
    private static final String ARQUIVO_TXT = "alunos.txt";
    private static final String ARQUIVO_CSV = "alunos.csv";

    // Injeção de Dependência
    public static void salvar(Aluno aluno) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT,true))) {
            if(new File(ARQUIVO_TXT).length() == 0) {
                out.println("nome,endereco,idade,matricula");
            }
            out.printf(
                "%s,%s,%d,%d%n",
                aluno.getNome(),
                aluno.getEndereco(),
                aluno.getIdade(),
                aluno.getMatricula()
            );
        } catch(IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }

    public static void exportarParaCSV() throws IOException {
       try(
         BufferedReader in = new BufferedReader(new FileReader(ARQUIVO_TXT));
         PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_CSV));
       ) {
        String linha;

        while((linha = in.readLine())!= null) {
            out.println(linha);
        }
       } catch (Exception e) {
        System.err.println("Erro ao exportar para CSV" + e.getMessage());
       }
    }
}
