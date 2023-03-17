package br.com.motos.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleta")
public class DeletaMoto extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id =Integer.valueOf(req.getParameter("id"));
		
		MotoDao dao = new MotoDao();
		Moto moto = dao.buscaPor(id);
		
		
		dao.deleta(id);
		
		PrintWriter saida = resp.getWriter();

		saida.println("<html><body>");
		
		
		saida.println("Moto " + moto.getModelo()+ " deletada com sucesso!");
		
		saida.println("</body></html>");
		saida.println("<br />");
		saida.println("<a href='/motos/lista'>Voltar</a>");
		
		
	}

}