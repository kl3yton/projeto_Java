import model.Categoria;
import model.Colaborador;
import model.Tarefa;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        // Criando uma categoria
        Categoria categoria1 = new Categoria(1, "");

        // Criando um colaborador
        Colaborador colaborador1 = new Colaborador(1, "");

        // Criando uma tarefa associada à categoria e ao colaborador
        Tarefa tarefa1 = new Tarefa(1, " ", "", "", categoria1, colaborador1);

        // Criando um Menu
        Menu menu = new Menu();
        menu.exibirMenu();

        // Imprimindo dados da categoria
        System.out.println("Categoria:");
        System.out.println("ID: " + categoria1.getId());
        System.out.println("Nome: " + categoria1.getNome());

        System.out.println();

        // Imprimindo dados do colaborador
        System.out.println("Colaborador:");
        System.out.println("ID: " + colaborador1.getId());
        System.out.println("Nome: " + colaborador1.getNome());

        System.out.println();

        // Imprimindo dados da tarefa
        System.out.println("Tarefa:");
        System.out.println("ID: " + tarefa1.getId());
        System.out.println("Título: " + tarefa1.getTitulo());
        System.out.println("Descrição: " + tarefa1.getDescricao());
        System.out.println("Status: " + tarefa1.getStatus());
        System.out.println("Categoria: " + tarefa1.getCategoria().getNome());
        System.out.println("Colaborador Responsável: " + tarefa1.getColaborador().getNome());
    }
}
