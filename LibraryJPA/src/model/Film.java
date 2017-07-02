package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFilma;

	private String autor;

	@Temporal(TemporalType.DATE)
	private Date datumProizvodnjeFilma;

	private String naslov;

	private String produkcijskaKuca;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	private Zanr zanr;

	//bi-directional many-to-one association to Primerakfilm
	@OneToMany(mappedBy="film")
	private List<Primerakfilm> primerakfilms;

	public Film() {
	}

	public int getIdFilma() {
		return this.idFilma;
	}

	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDatumProizvodnjeFilma() {
		return this.datumProizvodnjeFilma;
	}

	public void setDatumProizvodnjeFilma(Date datumProizvodnjeFilma) {
		this.datumProizvodnjeFilma = datumProizvodnjeFilma;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getProdukcijskaKuca() {
		return this.produkcijskaKuca;
	}

	public void setProdukcijskaKuca(String produkcijskaKuca) {
		this.produkcijskaKuca = produkcijskaKuca;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public List<Primerakfilm> getPrimerakfilms() {
		return this.primerakfilms;
	}

	public void setPrimerakfilms(List<Primerakfilm> primerakfilms) {
		this.primerakfilms = primerakfilms;
	}

	public Primerakfilm addPrimerakfilm(Primerakfilm primerakfilm) {
		getPrimerakfilms().add(primerakfilm);
		primerakfilm.setFilm(this);

		return primerakfilm;
	}

	public Primerakfilm removePrimerakfilm(Primerakfilm primerakfilm) {
		getPrimerakfilms().remove(primerakfilm);
		primerakfilm.setFilm(null);

		return primerakfilm;
	}

}