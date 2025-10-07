package ApachePOI;

public class Main {

    public static void main(String[] args) {

        // Criando duas contas
        ContaBancaria conta1 = new ContaBancaria("001", "João", 1000.0);
        ContaBancaria conta2 = new ContaBancaria("002", "Maria", 500.0);

        // Exibindo saldos iniciais
        System.out.println("Saldo inicial João: " + conta1.getSaldo());
        System.out.println("Saldo inicial Maria: " + conta2.getSaldo());

        // João deposita 300
        conta1.depositar(300.0);
        System.out.println("João depositou 300. Novo saldo: " + conta1.getSaldo());

        // Maria saca 200
        conta2.sacar(200.0);
        System.out.println("Maria sacou 200. Novo saldo: " + conta2.getSaldo());

        // João transfere 400 para Maria
        conta1.transferir(conta2, 400.0);
        System.out.println("\nApós transferência de 400:");
        System.out.println("Saldo João: " + conta1.getSaldo());
        System.out.println("Saldo Maria: " + conta2.getSaldo());


        Banco banco = new Banco();

        banco.adicionarConta(new ContaBancaria("001", "João", 900.0));
        banco.adicionarConta(new ContaBancaria("002", "Maria", 700.0));

        // Caminho onde o arquivo será salvo
        String caminho = "C:\\Users\\joaoj\\Documents\\contas.xlsx";  // <-- aqui você altera!

        banco.salvarContasExcel(caminho);
    }

}
