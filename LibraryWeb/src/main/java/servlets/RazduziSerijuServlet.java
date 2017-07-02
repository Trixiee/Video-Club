package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;

/**
 * Servlet implementation class RazduziSerijuServlet
 */
public class RazduziSerijuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RazduziSerijuServlet() {
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
		cm.razduziSeriju(idZaduzenja);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/razduzi/RazduziClanaZaSeriju.jsp");
		rd.forward(request, response);

	}

}
