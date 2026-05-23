package Main;

import java.sql.Connection;
import java.sql.SQLException;

import CriarTabelas.Tabelas;
import DB.ConexaoDB;
import DAO.ClienteDAO;
import Model.Cliente;
import java.util.List;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        // seu código aqui
        Connection conn = ConexaoDB.conectar();
        Tabelas.criarTabelaClientes(conn);

        try {
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM clientes");
        } catch (SQLException e) { 
            System.out.println("Erro ao deletar: " + e.getMessage());
        }


        ClienteDAO dao = new ClienteDAO();
        Cliente cliente1  = new Cliente("Treino", "Treino01@gmai.com", "(11) 95555-5555");
        Cliente cliente2  = new Cliente("Teste", "Teste02@gmai.com", "(11) 96677-7777");
        Cliente cliente3  = new Cliente("Aleatorio", "Aleatorio03@gmai.com", "(11) 97788-8888");
        Cliente cliente4  = new Cliente("Bom dia", "bomdia04@gmai.com", "(11) 98899-9999");

        dao.criar(cliente1);
        dao.criar(cliente2);
        dao.criar(cliente3);
        dao.criar(cliente4);

        List<Cliente> clientes = dao.listar();
        for (Cliente c : clientes) {
             System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEmail());
        }
    
        cliente4.setNome("Boa dia Atualizado");
        dao.atualizar(cliente4);
        
        dao.deletar(3);

    }
}