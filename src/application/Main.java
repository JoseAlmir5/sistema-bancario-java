package application;

import entities.Conta;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    static List<Conta> list = new ArrayList<>();

    public static void main(String[] args) {


        System.out.println(">BEM VINDO AO MENU DO BANCO - PESCOBANK<");
        System.out.println();

        int opcao = 0;
        while (opcao != 6) {
            System.out.println(">Digite uma opção: ");
            System.out.println("> 1- Criar conta | 2- Depositar | 3- Sacar | 4- Transferir | 5- Listar contas | 6- Sair <");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;

                case 2:
                    depositar();
                    break;

                case 3:
                    sacar();
                    break;

                case 4:
                    transferir();
                    break;

                case 5:
                    listarConta();
                    break;


                case 6:
                    System.out.println("Encerrando sistema...");
                    break;


            }

        }

    }

    public static void criarConta() {

        System.out.println("Digite os seus dados para serem cadastrados: ");
        System.out.print("Numero da conta: ");
        Integer numeroConta = sc.nextInt();
        for (Conta cont : list) {
            if (cont.getNumero().equals(numeroConta)) {
                System.out.println("Conta ja cadastrada!");
                return;
            }
        }
        System.out.print("Nome do usuário: ");
        sc.nextLine();
        String nomeUsuario = sc.nextLine();
        System.out.print("Valor inicial? (s/n)");
        char resposta = sc.next().charAt(0);

        Conta conta;
        if (resposta == 's') {
            System.out.println("Digite um valor para adicionar a sua conta: ");
            Double initialDeposit = sc.nextDouble();
            conta = new Conta(numeroConta, nomeUsuario, initialDeposit);
        }
        else {
            conta = new Conta(numeroConta, nomeUsuario);
        }

        list.add(conta);

        System.out.println();
        System.out.println("DADOS DA CONTA: ");

        for (Conta cont : list) {
            System.out.println(cont);
        }
    }

    public static void depositar() {
        System.out.println("Digite o numero da conta:");
        Integer numConta = sc.nextInt();

        Conta conta = buscarConta(numConta);

        if (conta == null) {
            System.out.println("Conta nao existe!");
            return;
        }

        System.out.println("Digite a quantidade que deseja adicionar R$:");
        Double valor = sc.nextDouble();

        conta.addSaldo(valor);
    }

    public static void sacar() {
        System.out.println("Digite o numero da conta:");
        Integer numConta = sc.nextInt();

        Conta conta = buscarConta(numConta);

        if (conta == null) {
            System.out.println("Conta nao existe!");
            return;
        }

        System.out.println("Digite a quantidade que deseja remover R$:");
        Double valor = sc.nextDouble();

        conta.removeSaldo(valor);
    }

    public static void listarConta() {
        for (Conta cont : list) {
            System.out.println(cont);
        }
    }

    public static void transferir() {

        System.out.println("Qual conta vai enviar o dinheiro? ");
        Integer contaEnviarDinheiro = sc.nextInt();

        System.out.println("Qual conta ira receber o dinheiro? ");
        Integer contaReceberDinheiro = sc.nextInt();

        System.out.println("Qual o valor a ser enviado da Conta: " + contaEnviarDinheiro + " para a Conta: " + contaReceberDinheiro );
        Double valorEnviadoContas = sc.nextDouble();

        Conta origem = null;
        Conta destino = null;

        for (Conta cont : list) {

            if (cont.getNumero().equals(contaEnviarDinheiro)) {
                origem = cont;
            }

            if (cont.getNumero().equals(contaReceberDinheiro)) {
                destino = cont;
            }
        }

        if (origem == null || destino == null) {
            System.out.println("Uma das contas não existe!");
            return;
        }

        origem.removeSaldo(valorEnviadoContas);
        destino.addSaldo(valorEnviadoContas);

        System.out.println("Transferência realizada!");
    }

    public static Conta buscarConta(Integer numero) {

        for (Conta cont : list) {
            if (cont.getNumero().equals(numero)) {
                return cont;
            }
        }
        return null;
    }

}
