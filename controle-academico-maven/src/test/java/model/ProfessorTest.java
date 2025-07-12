package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {
    @Test
    public void testConstrutorComParametros() {
        Professor professor = new Professor(
                "Pedro",
                "Rua 1",
                45,
                "222.222.222-22",
                "Informática");
        
        assertEquals("Pedro", professor.getNome());
        assertEquals("Rua 1", professor.getEndereco());
        assertEquals(45, professor.getIdade());
        assertEquals("222.222.222-22", professor.getCpf());
        assertEquals("Informática",professor.getAtuacao());
        assertTrue(professor.getMatricula() > 0 && professor.getMatricula() < 10000);
    }

    @Test
    public void testConstrutorSemParametros() {
        Professor professor = new Professor();
        professor.setNome("Pedro");
        professor.setEndereco("Rua 1");
        professor.setIdade(45);
        professor.setCpf("222.222.222-22");
        professor.setAtuacao("Informática");
        int matricula = professor.gerarMatricula();
        professor.setMatricula(matricula);

        assertEquals("Pedro", professor.getNome());
        assertEquals("Rua 1", professor.getEndereco());
        assertEquals(45, professor.getIdade());
        assertEquals("222.222.222-22", professor.getCpf());
        assertEquals("Informática",professor.getAtuacao());
        assertTrue(professor.getMatricula() > 0 && professor.getMatricula() < 10000);
    }
}
