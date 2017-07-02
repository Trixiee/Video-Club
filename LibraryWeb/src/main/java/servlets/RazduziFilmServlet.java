package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;

/**
 * Servlet implementation class RazduziFilmServlet
 */
public class RazduziFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RazduziFilmServlet() {
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
		int idZaduzenja =Integer.parseInt( request.getParameter("idZaduzenja"));
		ClanManager cm = new ClanManager();
		cm.razduziFilm(idZaduzenja);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/razduzi/RazduziClanaZaFilm.jsp");
		rd.forward(request, response);

	}

}
