package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the serija database table.
 * 
 */
@Entity
@NamedQuery(name="Serija.findAll", query="SELECT s FROM Serija s")
public class Serija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSerija;

	private String autor;

	private int brojEpizodaSerije;

	@Temporal(TemporalType.DATE)
	private Date godinaProizvodnjeSerije;

	private String naslov;

	private String produkcijsaKuca;

	//bi-directional many-to-one association to Primerakserija
	@OneToMany(mappedBy="serija")
	private List<Primerakserija> primerakserijas;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	private Zanr zanr;

	public Serija() {
	}

	public int getIdSerija() {
		return this.idSerija;
	}

	public void setIdSerija(int idSerija) {
		this.idSerija = idSerija;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getBrojEpizodaSerije() {
		return this.brojEpizodaSerije;
	}

	public void setBrojEpizodaSerije(int brojEpizodaSerije) {
		this.brojEpizodaSerije = brojEpizodaSerije;
	}

	public Date getGodinaProizvodnjeSerije() {
		return this.godinaProizvodnjeSerije;
	}

	public void setGodinaProizvodnjeSerije(Date godinaProizvodnjeSerije) {
		this.godinaProizvodnjeSerije = godinaProizvodnjeSerije;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getProdukcijsaKuca() {
		return this.produkcijsaKuca;
	}

	public void setProdukcijsaKuca(String produkcijsaKuca) {
		this.produkcijsaKuca = produkcijsaKuca;
	}

	public List<Primerakserija> getPrimerakserijas() {
		return this.primerakserijas;
	}

	public void setPrimerakserijas(List<Primerakserija> primerakserijas) {
		this.primerakserijas = primerakserijas;
	}

	public Primerakserija addPrimerakserija(Primerakserija primerakserija) {
		getPrimerakserijas().add(primerakserija);
		primerakserija.setSerija(this);

		return primerakserija;
	}

	public Primerakserija removePrimerakserija(Primerakserija primerakserija) {
		getPrimerakserijas().remove(primerakserija);
		primerakserija.setSerija(null);

		return primerakserija;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

}