package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Zaduzenjeserije;

/**
 * Servlet implementation class PrikazZaduzenjaSerijaServlet
 */
public class PrikazZaduzenjaSerijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazZaduzenjaSerijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClanManager cm = new ClanManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idClan  = Integer.parseInt(request.getParameter("idClana"));
		List<Zaduzenjeserije> zf=cm.prikazZaduzenjaSerijaZaClana(idClan);
		request.setAttribute("zaduzenjaserija", zf);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikaziZaduzenjaSerije.jsp");
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
