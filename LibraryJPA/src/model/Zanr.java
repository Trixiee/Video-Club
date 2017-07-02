package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zanr database table.
 * 
 */
@Entity
@NamedQuery(name="Zanr.findAll", query="SELECT z FROM Zanr z")
public class Zanr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanr;

	private String nazivZanra;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="zanr")
	private List<Film> films;

	//bi-directional many-to-one association to Serija
	@OneToMany(mappedBy="zanr")
	private List<Serija> serijas;

	public Zanr() {
	}

	public int getIdZanr() {
		return this.idZanr;
	}

	public void setIdZanr(int idZanr) {
		this.idZanr = idZanr;
	}

	public String getNazivZanra() {
		return this.nazivZanra;
	}

	public void setNazivZanra(String nazivZanra) {
		this.nazivZanra = nazivZanra;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film addFilm(Film film) {
		getFilms().add(film);
		film.setZanr(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setZanr(null);

		return film;
	}

	public List<Serija> getSerijas() {
		return this.serijas;
	}

	public void setSerijas(List<Serija> serijas) {
		this.serijas = serijas;
	}

	public Serija addSerija(Serija serija) {
		getSerijas().add(serija);
		serija.setZanr(this);

		return serija;
	}

	public Serija removeSerija(Serija serija) {
		getSerijas().remove(serija);
		serija.setZanr(null);

		return serija;
	}

}