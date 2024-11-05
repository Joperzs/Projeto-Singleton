//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import banco.Cliente;
import banco.AccountManager;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = AccountManager.getInstance();

        Cliente cliente1 = new Cliente("001", "José");
        Cliente cliente2 = new Cliente("002", "Beto");

        accountManager.registrarConta(cliente1, 500);
        accountManager.registrarConta(cliente2, 300);

        accountManager.depositar(cliente1.getId(), 200);
        System.out.println("Saldo de José: R$" + accountManager.verSaldo(cliente1.getId()));

        accountManager.depositar(cliente2.getId(), 150);
        System.out.println("Saldo de Beto: R$" + accountManager.verSaldo(cliente2.getId()));

        // Cliente 1 tenta sacar um valor.
        accountManager.sacar(cliente1.getId(), 100);
        System.out.println("Saldo de José após saque: R$" + accountManager.verSaldo(cliente1.getId()));

        accountManager.sacar(cliente2.getId(), 600);
        System.out.println("Saldo de Beto após tentativa de saque: R$" + accountManager.verSaldo(cliente2.getId()));

        accountManager.listarContasAtivas();

        AccountManager novoGerenciador = AccountManager.getInstance();
        System.out.println("Verificando se é a mesma instância de AccountManager:");
        System.out.println("Instance 1 hash: " + System.identityHashCode(accountManager));
        System.out.println("Instance 2 hash: " + System.identityHashCode(novoGerenciador));
    }
}