package br.com.motos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.motos.modelo.Moto;

public class MotoDao {
	
	
	
	public void cadastra(Moto moto) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoweb","root","BB2360");
		System.out.println("Banco de Dados Conectado!");
		
		String sql= "insert into motos (marca, modelo, ano) value (?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, moto.getMarca());
		st.setString(2, moto.getModelo());
		st.setInt(3, moto.getAno());
		
		st.execute();
		
		
		st.close();
		conn.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
			
	}
	
	public List<Moto> lista(){
		return null;	
	}
	
	
	

}
