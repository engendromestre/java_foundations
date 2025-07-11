package service;

import model.Endereco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoServiceTest {

    @Test
    public void testCompletamentoViaCEPValido() throws Exception {
        Endereco endereco = new Endereco("01001-000", "100", "Bloco A");
        EnderecoService.completarEnderecoViaCEP(endereco);

        assertEquals("01001-000", endereco.getCep());
        assertNotNull(endereco.getLogradouro());
        assertEquals("Sé", endereco.getBairro());
        assertEquals("São Paulo", endereco.getLocalidade());
        assertEquals("SP", endereco.getUf());
    }

    @Test
    public void testCEPInvalido() {
        Endereco endereco = new Endereco("00000-000", "10", null);
        assertDoesNotThrow(() -> EnderecoService.completarEnderecoViaCEP(endereco));
        assertNull(endereco.getLogradouro()); // ViaCEP retorna nulo
    }
}