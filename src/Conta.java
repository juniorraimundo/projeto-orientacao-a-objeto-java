import java.util.List;

public abstract class Conta implements IConta {

    // atribuição automática da conta e sequencial
    protected static int SEQUENCIAL = 1;
    protected static int AGENCIA_PADRAO = 1;

    // declaração das variáveis
    protected int agencia;
    protected int numero;
    protected double saldo = 0.00;

    List<Clientes> clientes;

    //Construtor
    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    //Getters
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    // Importação dos métodos da Interface
    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
