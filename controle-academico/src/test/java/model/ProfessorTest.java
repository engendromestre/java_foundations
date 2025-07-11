package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {
    @Test
    public void testConstructorComParametros() {
        Professor professor = new Professor(
                "Ana",
                "Rua D, 101",
                20,
                "222.222.222-22", "Informática");
        assertEquals("Ana", professor.getNome());
        assertEquals("Rua D, 101", professor.getEndereco());
        assertEquals(20, professor.getIdade());
        assertTrue(professor.getMatricula() > 0 && professor.getMatricula() < 10000);
        assertEquals("222.222.222-22", professor.getCpf());
        assertEquals("Informática", professor.getAtuacao());
    }

    @Test
    public void testConstructorSemParametros() {
        Professor professor = new Professor();
        professor.setNome("Pedro");
        professor.setEndereco("Rua E, 202");
        professor.setIdade(30);
        professor.setCpf("333.333.333-33");
        professor.setAtuacao("Matemática");
        int matricula = professor.gerarMatricula();
        professor.setMatricula(matricula);
        assertEquals("Pedro", professor.getNome());
        assertEquals("Rua E, 202", professor.getEndereco());
        assertEquals(30, professor.getIdade());
        assertTrue(professor.getMatricula() > 0 && professor.getMatricula() < 10000);
        assertEquals("333.333.333-33", professor.getCpf());
        assertEquals("Matemática", professor.getAtuacao());
    }

    @Test
    public void testGerarMatricula() {
        Professor professor = new Professor();
        int matricula = professor.gerarMatricula();
        assertTrue(matricula > 0 && matricula < 10000);
    }

    @Test
    public void testToString() {
        Professor professor = new Professor("Luiz", "Rua F, 303", 40, "444.444.444-44", "Física");
        String expected = "Professor [nome=Luiz, endereco=Rua F, 303, idade=40, matricula=" + professor.getMatricula()
                + ", cpf=444.444.444-44, atuacao=Física]";
        assertEquals(expected, professor.toString());
    }
}
