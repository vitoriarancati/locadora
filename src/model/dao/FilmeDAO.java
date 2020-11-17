package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
