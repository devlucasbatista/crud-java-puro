package DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:sqlite:clientes.db";

    public static Connection conectar() {
        // seu código aqui
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}