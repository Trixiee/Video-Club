package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SerijaManager;
import model.Serija;

/**
 * Servlet implementation class azurirajSeriju
 */
public class azurirajSeriju extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public azurirajSeriju() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SerijaManager sm = new SerijaManager();
		String produkcijskaKuca = request.getParameter("produkcijskaKuca");
		int idSerija = Integer.parseInt(request.getParameter("idSerija"));
		sm.updateSerija(idSerija,produkcijskaKuca);
		request.setAttribute("idSerija", idSerija);
		request.setAttribute("produkcijskaKuca", produkcijskaKuca);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/update/AzurirajSeriju.jsp");
		rd.forward(request, response);
	
		
		
	}

}
