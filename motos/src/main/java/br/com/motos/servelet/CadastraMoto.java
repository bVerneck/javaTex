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

@WebServlet("/cadastra")
public class CadastraMoto extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
	
		Moto moto= new Moto(marca, modelo, ano);
		
		MotoDao motoDao = new MotoDao();
		
		motoDao.cadastra(moto);

		
		//		System.out.println("numero de motos "+ motoDao.numeroDeMotos());
		
     	PrintWriter saida = resp.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		
		saida.println("moto: "+ modelo + " cadastro feito");
		
		saida.println("<a href='/motos/lista'>Ir Para Lista</a>");
		
		saida.println("</body>");
		saida.println("</html>");
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
