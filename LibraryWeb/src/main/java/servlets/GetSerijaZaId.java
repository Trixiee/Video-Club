package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SerijaManager;
import model.Serija;

/**
 * Servlet implementation class GetSerijaZaId
 */
public class GetSerijaZaId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSerijaZaId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Serija s = new Serija();
		SerijaManager sm = new SerijaManager();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idSerija  = Integer.parseInt(request.getParameter("idSerija"));
		s= sm.getSerijaForId(idSerija);
		request.setAttribute("s",s);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazSerijePoId.jsp");
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
