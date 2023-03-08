package br.com.motos;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")

public class HomeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String nome = request.getParameter("nome");
		String text= String.valueOf(request.getParameter("text"));
		
		PrintWriter saida = response.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		
		saida.println("<h2>");

		saida.println(nome);
		saida.println(text);
		saida.println("</h2>");
		
		saida.println("</body>");
		saida.println("</html>");
		
		
		
		
		
	}

}
