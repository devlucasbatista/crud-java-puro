package DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

// Classe responsável por gerenciar a conexão com o banco de dados
public class ConexaoDB {

    // URL de conexão com o banco SQLite
    private static final String URL = "jdbc:sqlite:clientes.db";

    // Retorna uma conexão com o banco de dados
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}