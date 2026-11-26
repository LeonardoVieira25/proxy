import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente {
    private Integer codigo;
    private String nome;
    private String cidade;
    private Float saldo;
    private Float limite;

    public Cliente(int codigo) {
        this.codigo = codigo;
        Cliente objeto = BD.getCliente(codigo);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.saldo = objeto.saldo;
        this.limite = objeto.limite;
    }

    public Cliente(Integer codigo, String nome, String cidade, Float saldo, Float limite) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterDadosFinanceiros(Funcionario funcionario) {
        return Arrays.asList(this.saldo, this.limite);
    }
}
