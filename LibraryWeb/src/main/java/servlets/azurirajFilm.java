package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.FilmManager;

/**
 * Servlet implementation class azurirajFilm
 */
public class azurirajFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public azurirajFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmManager fm = new FilmManager();
		String produkcijskaKuca = request.getParameter("produkcijskaKuca");
		int idFilma = Integer.parseInt(request.getParameter("idFilm"));
		fm.updateFilm(idFilma,produkcijskaKuca);
		request.setAttribute("idFilma", idFilma);
		request.setAttribute("produkcijskaKuca", produkcijskaKuca);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/update/AzurirajFilm.jsp");
		rd.forward(request, response);
	
	
	}

}
