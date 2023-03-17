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

@WebServlet("/editar")
public class editarMoto extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id =Integer.valueOf(req.getParameter("id"));
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		Integer ano =Integer.valueOf(req.getParameter("ano"));
		
		Moto moto = new Moto(id, marca, modelo, ano);
		MotoDao dao = new MotoDao();
		dao.editar(moto);

		PrintWriter saida = resp.getWriter();

		saida.println("<html><body>");
		saida.println("Moto editada, 100% atualizado Bomba Patch Virou moda e todo mundo quer jogar");
		saida.println("<br />");
		saida.println("<a href='/motos/lista'>Voltar</a>");
		
		saida.println("</body></html>");
		
		
	}
}
