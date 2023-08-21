package Lecture_4.Exercicio_Restaurante.Controller;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import Lecture_4.Exercicio_Restaurante.Domain.*;
import Lecture_4.Exercicio_Restaurante.Service.*;

public class Controller {

    private RestauranteService restauranteService;
    private PratoService pratoService;
    private PedidoService pedidoService;
    private ClienteService clienteService;
    private Scanner scanner;

    public Controller() {
        this.restauranteService = new RestauranteService();
        this.pratoService = new PratoService();
        this.pedidoService = new PedidoService();
        this.clienteService = new ClienteService();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n------------ Menu Principal ------------");
            System.out.println("1- Criar Restaurante.");
            System.out.println("2- Criar Prato.");
            System.out.println("3- Criar Cliente.");
            System.out.println("4- Fazer Pedido.");
            System.out.println("5- Exibir todos os Restaurantes, e ver cardápio.");
            System.out.println("6- Exibir Clientes.");
            System.out.println("7- Sair.");
            System.out.println("\nDigite a opção desejada:");
            opcao = scanner.nextInt();

            scanner.nextLine();
            switch (opcao) {
                case 1:
                    this.cadastroRestaurante();
                    break;
                case 2:
                    cadastroPrato();
                    break;
                case 3:
                    cadastroCliente();
                    break;
                case 4:
                    realizarPedido();
                    break;
                case 5:
                    alternativasRestaurantes();
                    break;
                case 6:
                    exibirClientes();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida, escolha entre 1 a 7!");
                    break;
            }
        }

    }

    public void cadastroRestaurante() {
        System.out.println("\n------------ Cadastro Restaurante ------------\n");
        System.out.println("Digite o nome do Restaurante:");
        String nomeRest = scanner.nextLine();
        System.out.println("Digite o endereco do Restaurante:");
        String enderecoRest = scanner.nextLine();

        Restaurante restCriado = restauranteService.criarRestaurante(nomeRest, enderecoRest);

        if (!pratoService.getLista().getListaPratos().isEmpty()) {
            System.out.println("\nDeseja inserir algum prato ao cardápio do Restaurante? (S/N)");
            String opcaoRest = scanner.nextLine();

            if (opcaoRest.equalsIgnoreCase("S")) {
                adicionarPrato(restCriado);
            }
        }

    }

    public void cadastroPrato() {
        System.out.println("\n------------ Cadastro Prato ------------\n");
        System.out.println("Digite o nome do Prato:");
        String nomePrato = scanner.nextLine();
        System.out.println("Digite uma descrição para o Prato:");
        String descPrato = scanner.nextLine();
        System.out.println("Digite o preço do Prato:");
        double precoPrato = scanner.nextDouble();

        Prato pratoCriado = pratoService.criarPrato(nomePrato, descPrato, precoPrato);

        scanner.nextLine();

        if (!restauranteService.getLista().getListaRestaurantes().isEmpty()) {
            System.out.println("Deseja adicionar este prato ao cardápio de um Restaurante? (S/N)");
            String opcaoPrato = scanner.nextLine();

            if (opcaoPrato.equalsIgnoreCase("S")) {
                alternativasRestaurantes();
            }
        }
    }

    public void cadastroCliente() {
        System.out.println("\n------------ Cadastro Cliente ------------\n");
        System.out.println("Digite o nome do Cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite o CPF do Cliente:");
        String cpfCliente = scanner.nextLine();
        System.out.println("Digite o Endereço Padrão para envio:");
        String endPadraoCliente = scanner.nextLine();

        clienteService.criarCliente(nomeCliente, cpfCliente, endPadraoCliente);

        System.out.println("Deseja Realizar um pedido? (S/N)");
        String opcaoCliente = scanner.nextLine();

        if (opcaoCliente.equalsIgnoreCase("S")) {
            realizarPedido();
        }
    }

    public void realizarPedido() {
        System.out.println("\n------------ Pedido ------------\n");
        System.out.println("Cliente já cadastrado? (S/N)");
        String opcaoCadastro = scanner.nextLine();

        if (opcaoCadastro.equalsIgnoreCase("N")) {

            cadastroCliente();

        } else {

            System.out.println("Digite o CPF do Cliente:");
            String cpfPedido = scanner.nextLine();

            Cliente clientePedido = clienteService.buscarCliente(cpfPedido);

            while (clientePedido.equals(null)) {
                System.out.println("CPF não encontrado! Digite Novamente:");
                cpfPedido = scanner.nextLine();

                clientePedido = clienteService.buscarCliente(cpfPedido);
            }

            System.out.println("\nCliente encontrado:\n->" + clientePedido.toString());

            System.out.println("\nEscolha um dos restaurantes abaixo para realizar o Pedido: ");

            exibirRestaurantes();

            System.out.println("\nOpção: ");
            int opcaoRest = scanner.nextInt();

            Restaurante restaurantePedido = restauranteService.buscarRestaurante(opcaoRest);

            scanner.nextLine();

            System.out.println("Utilizar endereço padrão para entregar pedido? (S/N)");
            String opcaoEntrega = scanner.nextLine();

            String enderecoPedido;

            if (opcaoEntrega.equalsIgnoreCase("S")) {
                enderecoPedido = clientePedido.getEnderecoPadrao();
            } else {
                System.out.println("Digite o enderço para a entrega:");
                enderecoPedido = scanner.nextLine();
            }

            Pedido pedido = pedidoService.criarPedido(clientePedido, restaurantePedido, enderecoPedido);

            clienteService.addPedido(clientePedido, pedido);
            restauranteService.addPedido(restaurantePedido, pedido);

            adicionarPrato(restaurantePedido, pedido);

            System.out.println("----- Resumo do Pedido -----");
            System.out.println("->" + pedido.toString());

        }

    }

    public void alternativasRestaurantes() {
        exibirRestaurantes();
        System.out.println("\n1- Escolher um Restaurante para adicionar pratos.");
        System.out.println("2- Escolher um Restaurante para ver pedidos.");
        System.out.println("3- Voltar");
        System.out.println("\nDigite a opção desejada:");
        int opcaoRestaurante = scanner.nextInt();

        if (opcaoRestaurante == 1) {
            System.out.println("Digite o número do Restaurante desejado:");
            int escolhaRestaurante = scanner.nextInt();

            Restaurante restEscolhido = restauranteService.buscarRestaurante(escolhaRestaurante);

            exibirCardapio(restEscolhido);
            System.out.println();
            adicionarPrato(restEscolhido);

        } else if (opcaoRestaurante == 2) {
            System.out.println("Digite o número do Restaurante desejado:");
            int escolhaRestaurante = scanner.nextInt();

            Restaurante restEscolhido = restauranteService.buscarRestaurante(escolhaRestaurante);

            exibirPedidosRestaurante(restEscolhido);

        }
    }

    public void adicionarPrato(Restaurante restaurante) {

        while (true) {
            exibirPratos();

            System.out.println("\nQual prato você deseja adicionar?");
            int opcaoPrato = scanner.nextInt();
            Prato pratoAdd = pratoService.buscarPrato(opcaoPrato);

            if (pratoAdd.equals(null)) {
                continue;
            }

            restauranteService.addPrato(restaurante, pratoAdd);

            scanner.nextLine();

            System.out.println("Deseja adicionar mais algum prato? (S/N)");
            String continuarAdd = scanner.nextLine();
            if (continuarAdd.equalsIgnoreCase("N")) {
                break;
            }
        }

    }

    public void adicionarPrato(Restaurante restaurante, Pedido pedido) {

        while (true) {
            exibirCardapio(restaurante);

            if (restaurante.getPratos().isEmpty()) {
                System.out.println("Restaurante sem cardápio. Escolha outro restaurante!");
            } else {

                System.out.println("\nQual prato você deseja adicionar?");
                int opcaoPrato = scanner.nextInt();
                Prato pratoAdd = restaurante.getPratos().get(opcaoPrato - 1);

                if (pratoAdd.equals(null)) {
                    continue;
                }

                pedidoService.addPrato(pedido, pratoAdd);

                scanner.nextLine();

                System.out.println("Deseja adicionar mais algum prato? (S/N)");
                String continuarAdd = scanner.nextLine();
                if (continuarAdd.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }

    }

    public void exibirClientes() {

        System.out.println("\n------------ Clientes Cadastrados ------------");
        System.out.println(clienteService.listarClientes());

    }

    public void exibirRestaurantes() {
        System.out.println("\n------------ Restaurantes Disponíveis ------------");
        System.out.println(restauranteService.listarRestaurantes());
    }

    public void exibirPratos() {
        System.out.println("\n------------ Pratos Cadastrados ------------");
        System.out.println(pratoService.listarPratos());
    }

    public void exibirCardapio(Restaurante restaurante) {
        System.out.println("\nInformações sobre o Restaurante:");
        System.out.print("->" + restaurante.toString());
    }

    public void exibirPedidosRestaurante(Restaurante restaurante) {
        System.out.printf("\nPedidos anteriores do Restaurante %s:", restaurante.getNome());
        System.out.print("\n->" + restaurante.listarPedidos());
    }

}
