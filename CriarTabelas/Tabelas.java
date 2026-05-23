package CriarTabelas;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class Tabelas {

    public static void criarTabelaClientes(Connection conexao) {
        // seu código aqui
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