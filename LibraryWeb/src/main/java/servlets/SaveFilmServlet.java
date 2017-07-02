package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.FilmManager;
import managers.ZanrManager;
import model.Film;

/**
 * Servlet implementation class SaveFilmServlet
 */
public class SaveFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFilmServlet() {
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
			String naslov=request.getParameter("naslov");
			String autor=request.getParameter("autor");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date datumProizvodnjeFilma=sdf.parse(request.getParameter("datumProizvodnjeFilma"));
			String produkcijskaKuca=request.getParameter("produkcijskaKuca");
			int zanrId=Integer.parseInt(request.getParameter("zanr"));
		
			Film film = new Film();
			film.setAutor(autor);
			film.setNaslov(naslov);
			film.setDatumProizvodnjeFilma(datumProizvodnjeFilma);
			film.setProdukcijskaKuca(produkcijskaKuca);
			
			FilmManager fm=new FilmManager();
			ZanrManager zm = new ZanrManager();
			
			Film f=fm.dodajFilm(film,zm.getZanrForId(zanrId));
			String poruka="";
			if(f!=null)
				poruka="Film je uspesno sacuvan. Id filma  je "+f.getIdFilma();
			else
				poruka="Doslo je do greske. Film nije sacuvan";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/unos/UnosFilma.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
