package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the primerakfilm database table.
 * 
 */
@Entity
@NamedQuery(name="Primerakfilm.findAll", query="SELECT p FROM Primerakfilm p")
public class Primerakfilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invBrojFilma;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Zaduzenjefilma
	@OneToMany(mappedBy="primerakfilm")
	private List<Zaduzenjefilma> zaduzenjefilmas;

	public Primerakfilm() {
	}

	public int getInvBrojFilma() {
		return this.invBrojFilma;
	}

	public void setInvBrojFilma(int invBrojFilma) {
		this.invBrojFilma = invBrojFilma;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public List<Zaduzenjefilma> getZaduzenjefilmas() {
		return this.zaduzenjefilmas;
	}

	public void setZaduzenjefilmas(List<Zaduzenjefilma> zaduzenjefilmas) {
		this.zaduzenjefilmas = zaduzenjefilmas;
	}

	public Zaduzenjefilma addZaduzenjefilma(Zaduzenjefilma zaduzenjefilma) {
		getZaduzenjefilmas().add(zaduzenjefilma);
		zaduzenjefilma.setPrimerakfilm(this);

		return zaduzenjefilma;
	}

	public Zaduzenjefilma removeZaduzenjefilma(Zaduzenjefilma zaduzenjefilma) {
		getZaduzenjefilmas().remove(zaduzenjefilma);
		zaduzenjefilma.setPrimerakfilm(null);

		return zaduzenjefilma;
	}

}