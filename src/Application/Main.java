package Application;

import Entities.Conta;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        Conta conta = new Conta();

        System.out.println("Seja Bem-vindo ao banco... Informe as seguintes informações: ");

        System.out.print("Nome do titular: ");
        conta.titular = sc.nextLine();
        System.out.print("Informe o número da sua conta: ");
        conta.numeroDaConta = sc.nextInt();
        System.out.print("Saldo da Conta: ");
        conta.saldo = sc.nextDouble();

        System.out.println(conta);

        System.out.println();
        System.out.println("Os dados estão corretor? (S/N)");
        sc.nextLine(); //Limpar buffer
        String confirmar = sc.nextLine();

        if (confirmar.equalsIgnoreCase("S")) {
            System.out.println("Otimo! Vamos continuar com as operações...");
        }
        else {
            System.out.println("ERRO! Encerrando programa...");
            sc.close();
            return;
        }

        System.out.println();
        System.out.println("DESEJA: \n1-Depositar\n2-Sacar\n3-Ver cadastro\n4-Sair");
        int opcao = sc.nextInt();

        while(opcao != 4) {

            switch(opcao){
                case 1:
                    System.out.print("Quanto deseja depositar?: ");
                    double valor = sc.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Operação realizada com sucesso!");
                    System.out.println("Saldo atual: " + String.format("%.2f", conta.saldo));
                    break;
                case 2:
                    System.out.print("Quanto deseja sacar?: ");
                    valor = sc.nextDouble();
                    conta.sacar(valor);
                    System.out.println("Operação realizada com sucesso!");
                    System.out.println("Saldo atual: " + String.format("%.2f", conta.saldo));
                    break;
                case 3:
                    System.out.println(conta);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.println("Escolha outra opção: ");
            System.out.println("DESEJA: \n1-Depositar\n2-Sacar\n3-Ver cadastro\n4-Sair");
            opcao = sc.nextInt();
        }

        sc.close();
    }
}
