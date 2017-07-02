package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zaduzenjefilma database table.
 * 
 */
@Entity
@NamedQuery(name="Zaduzenjefilma.findAll", query="SELECT z FROM Zaduzenjefilma z")
public class Zaduzenjefilma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZaduzenjaFilma;

	@Temporal(TemporalType.DATE)
	private Date datumVracanjaFilma;

	@Temporal(TemporalType.DATE)
	private Date datumZaduzenjaFIlma;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="Zaduzenje_Clan")
	private Clan clan;

	//bi-directional many-to-one association to Primerakfilm
	@ManyToOne
	@JoinColumn(name="Zaduzenje_PrimerakFilm")
	private Primerakfilm primerakfilm;

	public Zaduzenjefilma() {
	}

	public int getIdZaduzenjaFilma() {
		return this.idZaduzenjaFilma;
	}

	public void setIdZaduzenjaFilma(int idZaduzenjaFilma) {
		this.idZaduzenjaFilma = idZaduzenjaFilma;
	}

	public Date getDatumVracanjaFilma() {
		return this.datumVracanjaFilma;
	}

	public void setDatumVracanjaFilma(Date datumVracanjaFilma) {
		this.datumVracanjaFilma = datumVracanjaFilma;
	}

	public Date getDatumZaduzenjaFIlma() {
		return this.datumZaduzenjaFIlma;
	}

	public void setDatumZaduzenjaFIlma(Date datumZaduzenjaFIlma) {
		this.datumZaduzenjaFIlma = datumZaduzenjaFIlma;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Primerakfilm getPrimerakfilm() {
		return this.primerakfilm;
	}

	public void setPrimerakfilm(Primerakfilm primerakfilm) {
		this.primerakfilm = primerakfilm;
	}

}