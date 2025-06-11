package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import src.model.Colaborador;

public class ColaboradorDAO {

    public void inserir(Colaborador colaborador) {
        String sql = "INSERT INTO Colaborador (nome, email) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getEmail());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    colaborador.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir colaborador", e);
        }
    }

    public List<Colaborador> listar() {
        List<Colaborador> colaboradores = new ArrayList<>();
        String sql = "SELECT * FROM Colaborador";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rs.getInt("idColaborador"));
                colaborador.setNome(rs.getString("nome"));
                colaborador.setEmail(rs.getString("email"));
                colaboradores.add(colaborador);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar colaboradores", e);
        }

        return colaboradores;
    }
}
