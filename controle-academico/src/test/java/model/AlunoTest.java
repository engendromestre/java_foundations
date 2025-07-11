package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    public void testConstructorComParametros() {
        Endereco endereco = new Endereco("12345-678", "123", "Apto 1");
        Aluno aluno = new Aluno("João", endereco, 20);

        assertEquals("João", aluno.getNome());
        assertEquals(endereco, aluno.getEndereco());
        assertEquals(20, aluno.getIdade());
        assertTrue(aluno.getMatricula() > 0 && aluno.getMatricula() < 10000);
    }

    @Test
    public void testConstructorSemParametros() {
        Endereco endereco = new Endereco();
        endereco.setCep("98765-432");
        endereco.setNumero("456");
        endereco.setComplemento("Fundos");

        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setEndereco(endereco);
        aluno.setIdade(22);
        aluno.setMatricula(aluno.gerarMatricula());

        assertEquals("Maria", aluno.getNome());
        assertEquals(endereco, aluno.getEndereco());
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
        Endereco endereco = new Endereco("12345678", "789", "Sala 2");
        endereco.setLogradouro("Rua C");
        endereco.setBairro("Bairro W");
        endereco.setLocalidade("Cidade V");
        endereco.setUf("MG");

        Aluno aluno = new Aluno("Carlos", endereco, 25);
        String expected = "Aluno [nome=Carlos, endereco=" + endereco.toString() +
                ", idade=25, matricula=" + aluno.getMatricula() + "]";
        assertEquals(expected, aluno.toString());
    }
}