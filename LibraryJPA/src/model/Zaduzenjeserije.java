package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zaduzenjeserije database table.
 * 
 */
@Entity
@NamedQuery(name="Zaduzenjeserije.findAll", query="SELECT z FROM Zaduzenjeserije z")
public class Zaduzenjeserije implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZaduzenjaSerije;

	@Temporal(TemporalType.DATE)
	private Date datumVracanjaSerije;

	@Temporal(TemporalType.DATE)
	private Date datumZaduzenja;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="Zaduzenje_Clan")
	private Clan clan;

	//bi-directional many-to-one association to Primerakserija
	@ManyToOne
	@JoinColumn(name="Zaduzenje_PrimerakSerija")
	private Primerakserija primerakserija;

	public Zaduzenjeserije() {
	}

	public int getIdZaduzenjaSerije() {
		return this.idZaduzenjaSerije;
	}

	public void setIdZaduzenjaSerije(int idZaduzenjaSerije) {
		this.idZaduzenjaSerije = idZaduzenjaSerije;
	}

	public Date getDatumVracanjaSerije() {
		return this.datumVracanjaSerije;
	}

	public void setDatumVracanjaSerije(Date datumVracanjaSerije) {
		this.datumVracanjaSerije = datumVracanjaSerije;
	}

	public Date getDatumZaduzenja() {
		return this.datumZaduzenja;
	}

	public void setDatumZaduzenja(Date datumZaduzenja) {
		this.datumZaduzenja = datumZaduzenja;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Primerakserija getPrimerakserija() {
		return this.primerakserija;
	}

	public void setPrimerakserija(Primerakserija primerakserija) {
		this.primerakserija = primerakserija;
	}

}