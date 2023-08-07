package Lecture_2;

import java.math.BigDecimal;
import java.util.Scanner;

public class A_02_EX_02 {

    public static void main(String[] args) {
        int opcao = 0;

        Scanner scanner = new Scanner(System.in);
        Conta contaUtilizada;
        Banco listaBanco = new Banco();
        BigDecimal valor = new BigDecimal("0");

        while (opcao != 5) {
            System.out.println("\n---------Menu---------\n");
            System.out.println("1- Criar conta.");
            System.out.println("2- Depositar.");
            System.out.println("3- Sacar.");
            System.out.println("4- Exibir dados da Conta.");
            System.out.println("5- Finalizar.");

            System.out.println("Escolha as opções de 1 a 5:");
            opcao = scanner.nextInt();

            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o seu nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o seu CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o seu email:");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, email);
                    System.out.println("Digite o número da conta:");
                    String numeroConta = scanner.nextLine();

                    contaUtilizada = new Conta(cliente, numeroConta);
                    System.out.println("\nCriando conta...");
                    System.out.println("Conta Criada!");

                    listaBanco.criarConta(contaUtilizada);
                    break;

                case 2:
                    do {
                        System.out.println("Digite o número da conta:");
                        String numeroContaDeposito = scanner.nextLine();
                        contaUtilizada = listaBanco.buscarConta(numeroContaDeposito);

                    } while (contaUtilizada == null);

                    System.out.println("Digite o valor a ser depositado:");
                    valor = scanner.nextBigDecimal();

                    System.out.println("\n" + listaBanco.depositar(contaUtilizada, valor));
                    break;
                case 3:
                    do {
                        System.out.println("Digite o número da conta:");
                        String numeroContaSaque = scanner.nextLine();
                        contaUtilizada = listaBanco.buscarConta(numeroContaSaque);
                    } while (contaUtilizada == null);

                    System.out.println("Digite o valor a ser sacado:");
                    valor = scanner.nextBigDecimal();

                    System.out.println("\n" + listaBanco.sacar(contaUtilizada, valor));
                    break;
                case 4:
                    do {
                        System.out.println("Digite o número da conta:");
                        String numeroContaBuscar = scanner.nextLine();
                        contaUtilizada = listaBanco.buscarConta(numeroContaBuscar);
                    } while (contaUtilizada == null);

                    System.out.println("\nInformações do Cliente:\n");
                    System.out.println(contaUtilizada.toString());
                    break;
                case 5:
                    System.out.println("\nOperação Cancelada! Saindo...");
                    break;
                default:
                    System.out.println("Opção digitada Incorretamente! Por favor digite a opção desejada (1 a 5).");
                    break;
            }

        }
        scanner.close();
    }

}
