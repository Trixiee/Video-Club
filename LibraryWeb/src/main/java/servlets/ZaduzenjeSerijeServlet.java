package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SerijaManager;

/**
 * Servlet implementation class ZaduzenjeSerijeServlet
 */
public class ZaduzenjeSerijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZaduzenjeSerijeServlet() {
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
		SerijaManager sm = new SerijaManager();
		sm.saveZaduzenjeSerija(idClana, invBroj);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/zaduzenja/ZaduziSeriju.jsp");
		rd.forward(request, response);
	}

}
