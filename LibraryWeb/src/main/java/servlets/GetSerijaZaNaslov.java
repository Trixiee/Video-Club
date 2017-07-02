package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SerijaManager;
import model.Film;
import model.Serija;

/**
 * Servlet implementation class GetSerijaZaNaslov
 */
public class GetSerijaZaNaslov extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSerijaZaNaslov() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Serija> serije = new ArrayList<Serija>();
		SerijaManager sm = new SerijaManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String naslov = request.getParameter("naslov");
		serije= sm.getSerijeForNaslov(naslov);
		request.setAttribute("serije",serije);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazSerijeZaNaslov.jsp");
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
