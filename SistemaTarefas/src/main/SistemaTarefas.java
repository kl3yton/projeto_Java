package app;

import dao.CategoriaDao;
import dao.ColaboradorDAO;
import dao.TarefaDAO;
import model.Categoria;
import model.Colaborador;
import model.Tarefa;

import java.time.LocalDate;
import java.util.List;

public class SistemaTarefas {
    public static void main(String[] args) {
        CategoriaDao categoriaDao = new CategoriaDao();
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        TarefaDAO tarefaDao = new TarefaDAO();

        // Inserir categoria
        Categoria cat = new Categoria("Estudo");
        categoriaDao.inserir(cat);

        // Inserir colaborador
        Colaborador col = new Colaborador("João", "joao@email.com");
        colaboradorDao.inserir(col);

        // Inserir tarefa
        Tarefa tarefa = new Tarefa("Revisar Java", "Estudar JDBC e DAO", "Pendente", LocalDate.now(), null, cat, col);
        tarefaDao.inserir(tarefa);

        // Listar tarefas
        List<Tarefa> tarefas = tarefaDao.listar();
        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }
}
