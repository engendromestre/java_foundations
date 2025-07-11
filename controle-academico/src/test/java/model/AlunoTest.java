package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    @Test
    public void testConstructorComParametros() {
        Aluno aluno = new Aluno("João", "Rua A, 123", 20);
        assertEquals("João", aluno.getNome());
        assertEquals("Rua A, 123", aluno.getEndereco());
        assertEquals(20, aluno.getIdade());
        assertTrue(aluno.getMatricula() > 0 && aluno.getMatricula() < 10000);
    }

    @Test
    public void testConstructorSemParametros() {
        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setEndereco("Rua B, 456");
        aluno.setIdade(22);
        int matricula = aluno.gerarMatricula();
        aluno.setMatricula(matricula);
        assertEquals("Maria", aluno.getNome());
        assertEquals("Rua B, 456", aluno.getEndereco());
        assertEquals(22, aluno.getIdade());
        assertTrue(aluno.getMatricula() > 0 && aluno.getMatricula() < 10000);
    }

    @Test
    public void testGerarMatricula() {
        Aluno aluno = new Aluno();
        int matricula = aluno.gerarMatricula();
        assertTrue(matricula > 0 && matricula < 10000);
    }

    @Test
    public void testToString() {
        Aluno aluno = new Aluno("Carlos", "Rua C, 789", 25);
        String expected = "Aluno [nome=Carlos, endereco=Rua C, 789, idade=25, matricula=" + aluno.getMatricula() + "]";
        assertEquals(expected, aluno.toString());
    }
}
