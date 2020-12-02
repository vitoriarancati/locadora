package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.Filme;

public class FilmeDAO {
	
	public void create(Filme f) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	try {
		stmt = con.prepareStatement("INSERT INTO FILME (titulo, duracao, sinopse, categoria, dublado) VALUES(?,?,?,?,?)");
		stmt.setString(1,f.getTitulo());
		stmt.setInt(2, f.getDuracao());
		stmt.setString(3, f.getSinopse());
		stmt.setString(4, f.getCategoria());
		stmt.setBoolean(5, f.isDublado());
		
		stmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "Filme salvo com sucesso: ");

	}catch(SQLException e) {
		JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
	}finally{
		ConnectionFactory.closeConnection(con, stmt);
		}
	
	}

	public List<Filme> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Filme> filmes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM filme;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Filme f = new Filme();
				f.setIdFilme(rs.getInt("idFilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setDuracao(rs.getInt("duracao"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
				f.setDublado(rs.getBoolean("dublado"));
				filmes.add(f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar informações no Banco de Dados: " + e);
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return filmes;  
	}
	
}
