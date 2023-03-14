package br.com.motos.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import br.com.motos.modelo.Moto;
import br.com.motos.servelet.ListaMotos;
import br.com.motos.util.JdbcFactory;

public class MotoDao {

	public void cadastra(Moto moto) {

		try {

			Connection conn = JdbcFactory.getConnection();

			String sql = "insert into motos (marca, modelo, ano) value (?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, moto.getMarca());
			st.setString(2, moto.getModelo());
			st.setInt(3, moto.getAno());

			st.execute();

			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public List<Moto> lista() {
		List<Moto> motos = new ArrayList<>();

		try {
			Connection conn = JdbcFactory.getConnection();
			String sql = "select * from motos";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Moto moto = new Moto(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano")

				);
				motos.add(moto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return motos;
	}

	public Moto buscaPor(Integer idMoto) {
		Moto moto = null;
		try {
			Connection conn = JdbcFactory.getConnection();
			String sql = "select * from motos where id =?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idMoto);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");

				moto = new Moto(idMoto, marca, modelo, ano);

			               }
		    } catch (SQLException e) {
		    	e.printStackTrace();

		}
		return moto;
	}

}
