package beans;

import java.io.Serializable;
import java.util.List;

import managers.FilmManager;
import model.Film;



public class GetSveFilmoveBean implements Serializable {
	private List<Film> sviFilmovi;
	
	
	public GetSveFilmoveBean(){
		sviFilmovi=new FilmManager().sviFilmovi();
	}

	public List<Film> getSviFilmovi() {
		return sviFilmovi;
	}

	public void setSviFilmovi(List<Film> sviFilmovi) {
		this.sviFilmovi = sviFilmovi;
	}
}
