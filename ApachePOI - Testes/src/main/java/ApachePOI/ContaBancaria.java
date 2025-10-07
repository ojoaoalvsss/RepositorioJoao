package ApachePOI;

public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular, Double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(Double valor) {
        saldo += valor;
    }

    public boolean sacar(Double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean transferir(ContaBancaria destino, Double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
