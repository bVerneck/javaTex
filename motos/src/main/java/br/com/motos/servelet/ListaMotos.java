package br.com.motos.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Property;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class ListaMotos extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		MotoDao dao = new MotoDao();
//		List<Moto> motos = dao.lista();
		
		PrintWriter saida= resp.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		
//		saida.println("<ul>");
//		for(Moto moto : motos) {
//			saida.println("<li>" + moto + "</li>");
//			
//		}
		saida.println("</ul>");
		
		saida.println("</body>");
		saida.println("</html>");
		
		
	}

	
	
	
}
