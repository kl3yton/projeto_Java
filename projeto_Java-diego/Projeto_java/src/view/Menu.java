package view;

import model.Categoria;
import model.Colaborador;
import model.Tarefa;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private Colaborador[] colaboradores = new Colaborador[10];
    private Categoria[] categorias = new Categoria[10];
    private Tarefa[] tarefas = new Tarefa[10];

    private int qtdColaboradores = 0;
    private int qtdCategorias = 0;
    private int qtdTarefas = 0;

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("\n===== Sistema de Controle de Tarefas =====\n");
            System.out.println("1. Cadastrar Colaborador");
            System.out.println("2. Listar Colaboradores");
            System.out.println("3. Cadastrar Categoria");
            System.out.println("4. Listar Categorias");
            System.out.println("5. Cadastrar Tarefa");
            System.out.println("6. Listar Tarefas");
            System.out.println("7. Excluir Colaborador");
            System.out.println("8. Excluir Tarefa");
            System.out.println("9. Excluir Categoria");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            String entrada = scanner.nextLine();

            if (!entrada.matches("\\d+")) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1: cadastrarColaborador(); break;
                case 2: listarColaboradores(); break;
                case 3: cadastrarCategoria(); break;
                case 4: listarCategorias(); break;
                case 5: cadastrarTarefa(); break;
                case 6: listarTarefas(); break;
                case 7: excluirColaborador(); break;
                case 8: excluirTarefa(); break;
                case 9: excluirCategoria(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida, tente novamente."); break;
            }
        } while (opcao != 0);
    }

    private void cadastrarColaborador() {
        if (qtdColaboradores >= colaboradores.length) {
            System.out.println("Limite de colaboradores atingido!");
            return;
        }

        System.out.print("ID do colaborador: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome do colaborador: ");
        String nome = scanner.nextLine();

        colaboradores[qtdColaboradores++] = new Colaborador(id, nome);

        System.out.println("\nColaborador cadastrado com sucesso!");
    }

    private void listarColaboradores() {
        if (qtdColaboradores == 0) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("\nLista de Colaboradores:");
        for (int i = 0; i < qtdColaboradores; i++) {
            Colaborador c = colaboradores[i];
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
        }
    }

    private void cadastrarCategoria() {
        if (qtdCategorias >= categorias.length) {
            System.out.println("Limite de categorias atingido!");
            return;
        }

        System.out.print("ID da categoria: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();

        categorias[qtdCategorias++] = new Categoria(id, nome);

        System.out.println("Categoria cadastrada com sucesso!");
    }

    private void listarCategorias() {
        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }
        System.out.println("\nLista de Categorias:");
        for (int i = 0; i < qtdCategorias; i++) {
            Categoria cat = categorias[i];
            System.out.println("ID: " + cat.getId() + " | Nome: " + cat.getNome());
        }
    }

    private void cadastrarTarefa() {
        if (qtdTarefas >= tarefas.length) {
            System.out.println("Limite de tarefas atingido!");
            return;
        }

        System.out.print("ID da tarefa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.print("Status da tarefa (Pendente, Em andamento, Concluída): ");
        String status = scanner.nextLine();

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada. Cadastre uma categoria primeiro.");
            return;
        }
        listarCategorias();
        System.out.print("Informe o ID da categoria para associar: ");
        int idCategoria = Integer.parseInt(scanner.nextLine());
        Categoria categoria = buscarCategoriaPorId(idCategoria);
        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        if (qtdColaboradores == 0) {
            System.out.println("Nenhum colaborador cadastrado. Cadastre um colaborador primeiro.");
            return;
        }
        listarColaboradores();
        System.out.print("Informe o ID do colaborador responsável: ");
        int idColaborador = Integer.parseInt(scanner.nextLine());
        Colaborador colaborador = buscarColaboradorPorId(idColaborador);
        if (colaborador == null) {
            System.out.println("Colaborador não encontrado.");
            return;
        }

        tarefas[qtdTarefas++] = new Tarefa(id, titulo, descricao, status, categoria, colaborador);

        System.out.println("Tarefa cadastrada com sucesso!");
    }

    private void listarTarefas() {
        if (qtdTarefas == 0) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\nLista de Tarefas:");
        for (int i = 0; i < qtdTarefas; i++) {
            Tarefa t = tarefas[i];
            System.out.println("ID: " + t.getId() + " | Título: " + t.getTitulo() + " | Status: " + t.getStatus()
                + " | Categoria: " + t.getCategoria().getNome() + " | Colaborador: " + t.getColaborador().getNome());
        }
    }

    private Categoria buscarCategoriaPorId(int id) {
        for (int i = 0; i < qtdCategorias; i++) {
            if (categorias[i].getId() == id) {
                return categorias[i];
            }
        }
        return null;
    }

    private Colaborador buscarColaboradorPorId(int id) {
        for (int i = 0; i < qtdColaboradores; i++) {
            if (colaboradores[i].getId() == id) {
                return colaboradores[i];
            }
        }
        return null;
    }

    private void excluirColaborador() {
        if (qtdColaboradores == 0) {
            System.out.println("Nenhum colaborador cadastrado para excluir.");
            return;
        }
        listarColaboradores();
        System.out.print("Digite o ID do colaborador que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        int pos = -1;
        for (int i = 0; i < qtdColaboradores; i++) {
            if (colaboradores[i].getId() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Colaborador não encontrado.");
            return;
        }

        // Remover colaborador deslocando o array
        for (int i = pos; i < qtdColaboradores - 1; i++) {
            colaboradores[i] = colaboradores[i + 1];
        }
        colaboradores[--qtdColaboradores] = null;
        System.out.println("Colaborador excluído com sucesso!");
    }

    private void excluirTarefa() {
        if (qtdTarefas == 0) {
            System.out.println("Nenhuma tarefa cadastrada para excluir.");
            return;
        }
        listarTarefas();
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        int pos = -1;
        for (int i = 0; i < qtdTarefas; i++) {
            if (tarefas[i].getId() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        // Remover tarefa deslocando o array
        for (int i = pos; i < qtdTarefas - 1; i++) {
            tarefas[i] = tarefas[i + 1];
        }
        tarefas[--qtdTarefas] = null;
        System.out.println("Tarefa excluída com sucesso!");
    }

    private void excluirCategoria() {
        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada para excluir.");
            return;
        }
        listarCategorias();
        System.out.print("Digite o ID da categoria que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        int pos = -1;
        for (int i = 0; i < qtdCategorias; i++) {
            if (categorias[i].getId() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        // Verificar se alguma tarefa está associada a essa categoria
        for (int i = 0; i < qtdTarefas; i++) {
            if (tarefas[i].getCategoria().getId() == id) {
                System.out.println("Não é possível excluir esta categoria pois está associada a uma tarefa.");
                return;
            }
        }

        // Remover categoria deslocando o array
        for (int i = pos; i < qtdCategorias - 1; i++) {
            categorias[i] = categorias[i + 1];
        }
        categorias[--qtdCategorias] = null;
        System.out.println("Categoria excluída com sucesso!");
    }
}
