package banco;

import banco.Cliente;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instance;
    private final Map<String, Double> contas;

    private AccountManager() {
        contas = new HashMap<>();
    }

    public static synchronized AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public void registrarConta(Cliente cliente, double saldoInicial) {
        if (!contas.containsKey(cliente.getId())) {
            contas.put(cliente.getId(), saldoInicial);
            System.out.println("Conta criada para " + cliente.getNome() + " com saldo inicial de R$" + saldoInicial);
        } else {
            System.out.println("Conta já existente para " + cliente.getNome());
        }
    }

    public void depositar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            contas.put(contaId, contas.get(contaId) + valor);
            System.out.println("Depósito de R$" + valor + " na conta " + contaId + " realizado.");
        } else {
            System.out.println("Conta " + contaId + " não encontrada.");
        }
    }

    public void sacar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            if (saldoAtual >= valor) {
                contas.put(contaId, saldoAtual - valor);
                System.out.println("Saque de R$" + valor + " da conta " + contaId + " realizado.");
            } else {
                System.out.println("Saldo insuficiente para o saque de R$" + valor + " na conta " + contaId + ".");
            }
        } else {
            System.out.println("Conta " + contaId + " não encontrada.");
        }
    }

    public double verSaldo(String contaId) {
        return contas.getOrDefault(contaId, 0.0);
    }

    public void listarContasAtivas() {
        System.out.println("Contas ativas:");
        for (Map.Entry<String, Double> conta : contas.entrySet()) {
            System.out.println("Conta ID: " + conta.getKey() + ", Saldo: R$" + conta.getValue());
        }
    }
}
