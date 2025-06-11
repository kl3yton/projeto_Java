package src.dao;

import model.Tarefa;
import model.Categoria;
import model.Colaborador;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void inserir(Tarefa tarefa) {
        String sql = "INSERT INTO Tarefa (titulo, descricao, status, dataCriacao, dataConclusao, categoria_id, colaborador_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao()));
            stmt.setDate(5, tarefa.getDataConclusao() != null ? Date.valueOf(tarefa.getDataConclusao()) : null);
            stmt.setInt(6, tarefa.getCategoria().getId());
            stmt.setInt(7, tarefa.getColaborador().getId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tarefa.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir tarefa", e);
        }
    }

    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = """
            SELECT t.*, c.nome AS categoria_nome, co.nome AS colaborador_nome, co.email
            FROM Tarefa t
            JOIN Categoria c ON t.categoria_id = c.idCategoria
            JOIN Colaborador co ON t.colaborador_id = co.idColaborador
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));

                Colaborador colaborador = new Colaborador();
                colaborador.setId(rs.getInt("colaborador_id"));
                colaborador.setNome(rs.getString("colaborador_nome"));
                colaborador.setEmail(rs.getString("email"));

                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idTarefa"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                Date dataConclusao = rs.getDate("dataConclusao");
                if (dataConclusao != null) {
                    tarefa.setDataConclusao(dataConclusao.toLocalDate());
                }
                tarefa.setCategoria(categoria);
                tarefa.setColaborador(colaborador);

                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar tarefas", e);
        }

        return tarefas;
    }
}
