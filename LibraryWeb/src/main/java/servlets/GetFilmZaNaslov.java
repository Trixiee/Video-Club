package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.FilmManager;
import model.Film;

/**
 * Servlet implementation class GetFilmZaNaslov
 */
public class GetFilmZaNaslov extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilmZaNaslov() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> filmovi = new ArrayList<Film>();
		FilmManager fm = new FilmManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String naslov = request.getParameter("naslov");
		filmovi= fm.getFilmoviForNaslov(naslov);
		request.setAttribute("filmovi",filmovi);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazFilmaZaNaslov.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
