import java.util.List;

public class ClienteProxy implements ICliente {

    private Cliente cliente;
    private Integer codigo;

    public ClienteProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.codigo);
        }
        return this.cliente.obterDadosCadastrais();
    }

    @Override
    public List<Float> obterDadosFinanceiros(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.cliente == null) {
            this.cliente = new Cliente(this.codigo);
        }
        return this.cliente.obterDadosFinanceiros(funcionario);
    }
}
