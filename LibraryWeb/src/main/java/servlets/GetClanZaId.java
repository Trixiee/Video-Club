package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Clan;

/**
 * Servlet implementation class GetClanZaId
 */
public class GetClanZaId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClanZaId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Clan c = new Clan();
		ClanManager cm = new ClanManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idClan  = Integer.parseInt(request.getParameter("idClan"));
		c= cm.getClanForId(idClan);
		request.setAttribute("clan",c);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazClanZaId.jsp");
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
