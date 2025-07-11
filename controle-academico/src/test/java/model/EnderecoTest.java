package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    @Test
    public void testConstructorComParametros() {
        Endereco endereco = new Endereco("12345-678", "123", "Apto 1");

        // Dados da API (simulados)
        endereco.setLogradouro("Rua A");
        endereco.setBairro("Centro");
        endereco.setLocalidade("Cidade X");
        endereco.setUf("SP");

        assertEquals("Rua A", endereco.getLogradouro());
        assertEquals("Centro", endereco.getBairro());
        assertEquals("Cidade X", endereco.getLocalidade());
        assertEquals("SP", endereco.getUf());
        assertEquals("12345-678", endereco.getCep());
        assertEquals("123", endereco.getNumero());
        assertEquals("Apto 1", endereco.getComplemento());
    }

    @Test
    public void testConstructorSemParametros() {
        Endereco endereco = new Endereco();
        endereco.setCep("98765-432");
        endereco.setNumero("456");
        endereco.setComplemento("Fundos");
        endereco.setLogradouro("Rua B");
        endereco.setBairro("Bairro Y");
        endereco.setLocalidade("Cidade Z");
        endereco.setUf("RJ");

        assertEquals("Rua B", endereco.getLogradouro());
        assertEquals("Bairro Y", endereco.getBairro());
        assertEquals("Cidade Z", endereco.getLocalidade());
        assertEquals("RJ", endereco.getUf());
        assertEquals("98765432", endereco.getCep());
        assertEquals("456", endereco.getNumero());
        assertEquals("Fundos", endereco.getComplemento());
    }

    @Test
    public void testToString() {
        Endereco endereco = new Endereco("12345-678", "789", "Sala 2");
        endereco.setLogradouro("Rua C");
        endereco.setBairro("Bairro W");
        endereco.setLocalidade("Cidade V");
        endereco.setUf("MG");

        String expected = "Rua C, nº 789 - Sala 2 - Bairro W - Cidade V/MG (CEP: 12345-678)";
        assertEquals(expected, endereco.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Endereco endereco = new Endereco();
        endereco.setCep("45678-123");
        endereco.setNumero("101");
        endereco.setComplemento("Apto 5");
        endereco.setLogradouro("Rua D");
        endereco.setBairro("Bairro U");
        endereco.setLocalidade("Cidade T");
        endereco.setUf("PR");

        assertEquals("Rua D", endereco.getLogradouro());
        assertEquals("Bairro U", endereco.getBairro());
        assertEquals("Cidade T", endereco.getLocalidade());
        assertEquals("PR", endereco.getUf());
        assertEquals("45678123", endereco.getCep());
        assertEquals("101", endereco.getNumero());
        assertEquals("Apto 5", endereco.getComplemento());
    }
}