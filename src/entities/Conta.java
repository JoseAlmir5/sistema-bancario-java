package entities;

public class Conta {

    private Integer numero;
    private String nome;
    private Double saldo;

    public Conta(Integer numero, String nome, Double initialDeposit) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = 0.0;
        addSaldo(initialDeposit);
    }

    public Conta(Integer numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = 0.0;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void addSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void removeSaldo(Double saldo) {
            this.saldo -= saldo + 5;
    }

    public String toString() {
     return "Número: "
             + numero
             + " | Titular: "
             + nome
             + " | Saldo: "
             + String.format("%.2f", saldo);
    }
}
