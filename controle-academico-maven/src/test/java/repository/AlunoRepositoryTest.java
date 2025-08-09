package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;

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
            txtField.set(null,txtFile.toString());
        } catch(Exception e) {
            throw new RuntimeException("Falha ao redefinir caminho de arquivo", e);
        }
    }
}
