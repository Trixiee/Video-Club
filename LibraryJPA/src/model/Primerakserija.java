package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the primerakserija database table.
 * 
 */
@Entity
@NamedQuery(name="Primerakserija.findAll", query="SELECT p FROM Primerakserija p")
public class Primerakserija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invBrojSerije;

	//bi-directional many-to-one association to Serija
	@ManyToOne
	private Serija serija;

	//bi-directional many-to-one association to Zaduzenjeserije
	@OneToMany(mappedBy="primerakserija")
	private List<Zaduzenjeserije> zaduzenjeserijes;

	public Primerakserija() {
	}

	public int getInvBrojSerije() {
		return this.invBrojSerije;
	}

	public void setInvBrojSerije(int invBrojSerije) {
		this.invBrojSerije = invBrojSerije;
	}

	public Serija getSerija() {
		return this.serija;
	}

	public void setSerija(Serija serija) {
		this.serija = serija;
	}

	public List<Zaduzenjeserije> getZaduzenjeserijes() {
		return this.zaduzenjeserijes;
	}

	public void setZaduzenjeserijes(List<Zaduzenjeserije> zaduzenjeserijes) {
		this.zaduzenjeserijes = zaduzenjeserijes;
	}

	public Zaduzenjeserije addZaduzenjeserije(Zaduzenjeserije zaduzenjeserije) {
		getZaduzenjeserijes().add(zaduzenjeserije);
		zaduzenjeserije.setPrimerakserija(this);

		return zaduzenjeserije;
	}

	public Zaduzenjeserije removeZaduzenjeserije(Zaduzenjeserije zaduzenjeserije) {
		getZaduzenjeserijes().remove(zaduzenjeserije);
		zaduzenjeserije.setPrimerakserija(null);

		return zaduzenjeserije;
	}

}