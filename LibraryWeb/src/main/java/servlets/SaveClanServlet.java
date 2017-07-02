package servlets;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Clan;

/**
 * Servlet implementation class SaveClanServlet
 */

public class SaveClanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveClanServlet() {
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
		try{
			String ime=request.getParameter("ime");
			String prezime=request.getParameter("prezime");
			String adresa=request.getParameter("adresa");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date datumRodjenja=sdf.parse(request.getParameter("datumRodjenja"));
			Date datumUpisa=sdf.parse(request.getParameter("datumUpisa"));
			int idKategorije=Integer.parseInt(request.getParameter("kategorija"));
			ClanManager cm=new ClanManager();
			Clan c=cm.saveClan(ime, prezime, adresa, datumRodjenja, datumUpisa, idKategorije);
			String poruka="";
			if(c!=null)
				poruka="Clan je uspesno sacuvan. Clanski broj je "+c.getIdClan();
			else
				poruka="Doslo je do greske. Clan nije sacuvan";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/unos/SaveClan.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}