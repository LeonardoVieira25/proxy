import java.util.List;

public interface ICliente {
    List<String> obterDadosCadastrais();

    List<Float> obterDadosFinanceiros(Funcionario funcionario);
}
