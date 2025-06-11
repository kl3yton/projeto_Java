package src.dao;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
