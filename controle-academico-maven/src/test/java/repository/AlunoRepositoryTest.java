package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Aluno;
import model.Endereco;

public class AlunoRepositoryTest {
    private static Path tempDir;
    private static Path txtFile;
    private static Path csvFile;

    @BeforeAll
    static void setupDir() throws IOException {
        tempDir = Files.createTempDirectory("alunoRepoTest");
        txtFile = tempDir.resolve("aluno.txt");
        csvFile = tempDir.resolve("alunos.csv");

        // Redefinir caminhos para arquivos temporários
        try {
            var txtField = AlunoRepository.class.getDeclaredField("ARQUIVO_TXT");
            txtField.setAccessible(true);
            //txtField.set(null,txtFile.toString());
        } catch(Exception e) {
            throw new RuntimeException("Falha ao redefinir caminho de arquivo", e);
        }
    }

    @BeforeEach
    void limparLista() {
        AlunoRepository.getLista().clear();
    }

    @Test
    public void testSetNoArrayList() {
        Endereco endereco = new Endereco("01001-000","1","Apto");
        Aluno aluno = new Aluno("João",endereco, 40);
        AlunoRepository.setAlunosArrayList(aluno);

        List<Aluno> lista = AlunoRepository.getLista();
        assertEquals(1, lista.size());
        assertEquals("João",lista.get(0).getNome());
        assertEquals("01001-000",lista.get(0).getEndereco().getCep());

        Endereco endereco2 = new Endereco("18601-120","100","Casa");
        Aluno aluno2 = new Aluno("Pedrinho",endereco2, 12);
        AlunoRepository.setAlunosArrayList(aluno2);
        assertEquals(2, lista.size());
        assertEquals("Pedrinho",lista.get(1).getNome());
        assertEquals("18601-120",lista.get(1).getEndereco().getCep());
    }
}
