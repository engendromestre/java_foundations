package repository;

import java.io.*;
import java.util.ArrayList;

import interfaces.RepositoryInterface;
import model.Aluno;

public class AlunoRepository implements RepositoryInterface {
    private static final String ARQUIVO_TXT = "alunos.txt";
    private static final String ARQUIVO_CSV = "alunos.csv";
    // Exemplo de Array Fixo
    private static Aluno[] alunosArray = new Aluno[5];
    private static int contadorArray = 0;
    // Exemplo de Array Dinâmico
    private static ArrayList<Aluno> alunosArrayList = new ArrayList<>();

    // Adicionar Alunos usando Array Fixo
    public static void setAlunos(Aluno aluno) {
        if(contadorArray < alunosArray.length) {
            alunosArray[contadorArray] = aluno;
            contadorArray++;
        } else {
            System.err.println("Arquivo Cheio");
        }
    }

    // Adicionar Alunos usando Array Dinâmico
    public static void setAlunosArrayList(Aluno aluno) {
        alunosArrayList.add(aluno);
    }

    // Retornar a Lista de Alunos
    public static ArrayList<Aluno> getLista() {
        return alunosArrayList;
    }

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
