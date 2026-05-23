package DAO;

import Model.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DB.ConexaoDB;


public class ClienteDAO {

    public void criar(Cliente cliente) {
        // seu código aqui
    
        String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ? , ?)"; 
        try (Connection conn = ConexaoDB.conectar(); 
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar ao banco de dados: " + e.getMessage());
        }
    }

    public List<Cliente> listar() {
        // seu código aqui
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                    Cliente c = new Cliente (
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                clientes.add(c);
            }  
        }  catch (SQLException e) {
            System.err.println("Erro ao selecionar: " + e.getMessage());
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        // seu código aqui
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEmail());
                stmt.setString(3, cliente.getTelefone());
                stmt.setInt(4, cliente.getId());
                stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        }
    } 


    public void deletar(int id) {
        // seu código aqui
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setInt(1, id);
                stmt.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Erro ao deletar: " + e.getMessage());
        }   
    }
}