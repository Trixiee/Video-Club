package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.FilmManager;
import model.Film;

/**
 * Servlet implementation class GetFilmZaId
 */
public class GetFilmZaId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilmZaId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Film f  = new Film();
		FilmManager fm = new FilmManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idFilma  = Integer.parseInt(request.getParameter("idFilm"));
		f= fm.getFilmForId(idFilma);
		request.setAttribute("f",f);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazFilmaPoId.jsp");
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
