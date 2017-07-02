package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.FilmManager;

/**
 * Servlet implementation class ZaduzenjeFilmaServlet
 */
public class ZaduzenjeFilmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZaduzenjeFilmaServlet() {
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
		int idClana =Integer.parseInt( request.getParameter("idClana"));
		int invBroj = Integer.parseInt(request.getParameter("invBroj"));
		FilmManager fm = new FilmManager();
		fm.saveZaduzenjeFilm(idClana, invBroj);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/zaduzenja/ZaduziFilm.jsp");
		rd.forward(request, response);
	
		
	}

}
