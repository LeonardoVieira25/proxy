import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(1, "João", "Juiz de Fora", 1500.0f, 5000.0f));
        BD.addCliente(new Cliente(2, "Maria", "Juiz de Fora", 8000.0f, 20000.0f));
    }

    @Test
    void deveRetornarDadosCadastraisCliente() {
        ClienteProxy cliente = new ClienteProxy(1);

        assertEquals(Arrays.asList("João", "Juiz de Fora"), cliente.obterDadosCadastrais());
    }

    @Test
    void deveRetornarDadosFinanceirosCliente() {
        Funcionario funcionario = new Funcionario("Ana", true);
        ClienteProxy cliente = new ClienteProxy(2);

        assertEquals(Arrays.asList(8000.0f, 20000.0f), cliente.obterDadosFinanceiros(funcionario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarDadosFinanceirosCliente() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            ClienteProxy cliente = new ClienteProxy(2);

            cliente.obterDadosFinanceiros(funcionario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}
