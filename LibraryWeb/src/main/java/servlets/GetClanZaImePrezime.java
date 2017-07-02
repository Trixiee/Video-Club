package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Clan;

/**
 * Servlet implementation class GetClanZaImePrezime
 */
public class GetClanZaImePrezime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClanZaImePrezime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Clan> c = new ArrayList<Clan>();
		ClanManager cm = new ClanManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		c= cm.getClanForImePrezime(ime, prezime);
		request.setAttribute("clan",c);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazClanaZaImePrezime.jsp");
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
