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

@WebServlet("/busca")
public class BuscaPorId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Moto moto = new MotoDao().buscaPor(Integer.valueOf(req.getParameter("id")));

		PrintWriter saida = resp.getWriter();

		saida.println("<html><body>");

		saida.println("<b>Marca: </b>" + moto.getMarca());
		saida.println("<br />");
		saida.println("<b>Modelo: </b>" + moto.getModelo());
		saida.println("<br />");
		saida.println("<b>Ano: </b>" + moto.getAno());

		saida.println("</body></html>");
	}

}
