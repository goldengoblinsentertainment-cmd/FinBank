package view;

import controller.ClienteController;
import model.Cliente;
import java.util.Scanner;

public class MenuView {

    private Scanner teclado;
    private ClienteController controller;

    public MenuView() {
        teclado = new Scanner(System.in);
        controller = new ClienteController();
    }

    public void iniciar() {

        int opcao;

        do {

            System.out.println("\n1-Cadastrar");
            System.out.println("2-Listar");
            System.out.println("3-Buscar");
            System.out.println("4-Alterar");
            System.out.println("5-Excluir");
            System.out.println("0-Sair");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    alterar();
                    break;

                case 5:
                    excluir();
                    break;
            }

        } while (opcao != 0);
    }

    private void cadastrar() {

        System.out.print("Código: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();

        controller.cadastrar(codigo,
                nome,
                telefone);
    }

    private void listar() {

        for (Cliente cliente : controller.listar()) {
            System.out.println(cliente);
        }
    }

    private void buscar() {

        System.out.print("Código: ");
        int codigo = teclado.nextInt();

        Cliente cliente =
                controller.buscar(codigo);

        System.out.println(cliente);
    }

    private void alterar() {

        System.out.print("Código: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Novo Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Novo Telefone: ");
        String telefone = teclado.nextLine();

        controller.alterar(codigo,
                nome,
                telefone);
    }

    private void excluir() {

        System.out.print("Código: ");
        int codigo = teclado.nextInt();

        controller.excluir(codigo);
    }
}

