package Entities;

public class Conta {

    public String titular;
    public int numeroDaConta;
    public double saldo;

    public double depositar(double valor) {
        return saldo += valor;
    }

    public double sacar(double valor) {
        return saldo -= valor;
    }

    public String toString() {
        return "Titular: " + titular
                + "\nNúmero da conta: " + numeroDaConta
                + "\nR$: " + String.format("%.2f", saldo);
    }

}
