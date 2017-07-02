package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SerijaManager;
import managers.ZanrManager;
import model.Serija;

/**
 * Servlet implementation class SaveSerijaServlet
 */
public class SaveSerijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSerijaServlet() {
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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String naslov=request.getParameter("naslov");
			String autor=request.getParameter("autor");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date  godinaProizvodnjeSerije=sdf.parse(request.getParameter("godinaProizvodnjeSerije"));
			String produkcijsaKuca=request.getParameter("produkcijsaKuca");
			int brojEpizodaSerije = Integer.parseInt(request.getParameter("brojEpizodaSerije"));
			int zanrId=Integer.parseInt(request.getParameter("zanr"));
		
			Serija s = new Serija();
			s.setAutor(autor);
			s.setNaslov(naslov);
			s.setGodinaProizvodnjeSerije(godinaProizvodnjeSerije);
			s.setProdukcijsaKuca(produkcijsaKuca);
			s.setBrojEpizodaSerije(brojEpizodaSerije);
			
			SerijaManager sm=new SerijaManager();
			ZanrManager zm = new ZanrManager();
			
			sm.dodajSeriju(s,zm.getZanrForId(zanrId));
			String poruka="";
			if(s!=null)
				poruka="Serija je uspesno sacuvan. Id serije  je "+s.getIdSerija();
			else
				poruka="Doslo je do greske. Serija nije sacuvan";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/unos/UnosSerija.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
