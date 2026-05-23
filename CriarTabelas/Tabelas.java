package CriarTabelas;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

// Classe responsável por criar as tabelas no banco de dados
public class Tabelas {

    // Cria a tabela de clientes se ela não existir
    public static void criarTabelaClientes(Connection conexao) {
        String sql = """
            CREATE TABLE IF NOT EXISTS CLIENTES ( 
                id INTEGER PRIMARY KEY NOT NULL,
                nome TEXT NOT NULL,
                email TEXT NOT NULL,
                telefone TEXT NOT NULL 
            )""";
        try {
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            System.out.println("Tabela criada");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}