package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    @Test
    public void testConstrutorComParametros() {
        Endereco endereco = new Endereco(
                "1860000",
                "001",
                "Apto.");

        Aluno aluno = new Aluno(
                "Pedro",
                endereco,
                29);

        assertEquals("Pedro", aluno.getNome());
        assertEquals(endereco, aluno.getEndereco());
        assertEquals(29, aluno.getIdade());
        assertTrue(aluno.getMatricula() > 0 && aluno.getMatricula() < 10000);
    }

    @Test
    public void testConstrutorSemParametros() {
        Endereco endereco = new Endereco(
                "1860000",
                "001",
                "Apto.");
        Aluno aluno = new Aluno();
        aluno.setNome("Pedro");
        aluno.setEndereco(endereco);
        aluno.setIdade(29);
        int matricula = aluno.gerarMatricula();
        aluno.setMatricula(matricula);

        assertEquals("Pedro", aluno.getNome());
        assertEquals(endereco, aluno.getEndereco());
        assertEquals(29, aluno.getIdade());
        assertTrue(aluno.getMatricula() > 0 && aluno.getMatricula() < 10000);
    }
}
