package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import managers.JPAUtil;
import model.Clan;
import model.Kategorija;

/**
 * Servlet implementation class GetClanZaKategorijuIDatumUpisa
 */
public class GetClanKategorijaDatum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClanKategorijaDatum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ClanManager cm = new ClanManager();
		Date datumUpisa = null;
		try {
			datumUpisa=sdf.parse(request.getParameter("datumUpisa"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int idKategorije=Integer.parseInt(request.getParameter("kategorija"));
		List<Clan> clanovi = cm.getClanoviZaDatumUpisaKategorija(datumUpisa, idKategorije);
		request.setAttribute("clanovi", clanovi);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/prikaz/PrikazClanaZaDatumKategorija.jsp");
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
