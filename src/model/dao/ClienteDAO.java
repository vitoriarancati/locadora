package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;

public class ClienteDAO {
	
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (cpf, nomecompleto, idade, email) VALUES(?,?,?,?)");
			stmt.setString(1,c.getCpf());
			stmt.setString(2, c.getNomecompleto());
			stmt.setInt(3, c.getIdade());
			stmt.setString(4, c.getEmail());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso: ");

		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
			}
		}
	
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("idCliente"));
				c.setCpf(rs.getString("cpf"));
				c.setNomecompleto(rs.getString("nomecompleto"));
				c.setIdade(rs.getInt("idade"));
				c.setEmail(rs.getString("email"));
				clientes.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar informações no Banco de Dados: " + e);
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;  
	}
	public Cliente read(int idCliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente c = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setIdCliente(rs.getInt("idCliente"));
				c.setCpf(rs.getString("cpf"));
				c.setNomecompleto(rs.getString("nomecompleto"));
				c.setIdade(rs.getInt("idade"));
				c.setEmail(rs.getString("email"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}
	public void update(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("UPDATE cliente SET cpf=?, nomeCompleto=?, idade=?, email=? WHERE idCliente=?;");
			stmt.setString(1,c.getCpf());
			stmt.setString(2, c.getNomecompleto());
			stmt.setInt(3, c.getIdade());
			stmt.setString(4, c.getEmail());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException e) { 
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
}
}


