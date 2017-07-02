package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Clan;

/**
 * Servlet implementation class GetClanoveZaKategoriju
 */
public class GetClanoveZaKategoriju extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClanoveZaKategoriju() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ClanManager cm = new ClanManager();
		int idKategorije=Integer.parseInt(request.getParameter("kategorija"));
		List<Clan> clanovi = cm.getClanoviZaKategorije(idKategorije);
		request.setAttribute("clanovi", clanovi);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazClanaZaKategoriju.jsp");
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
