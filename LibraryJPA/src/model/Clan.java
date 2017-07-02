package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clan database table.
 * 
 */
@Entity
@NamedQuery(name="Clan.findAll", query="SELECT c FROM Clan c")
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClan;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	@Temporal(TemporalType.DATE)
	private Date datumUpisa;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	//bi-directional many-to-one association to Zaduzenjefilma
	@OneToMany(mappedBy="clan")
	private List<Zaduzenjefilma> zaduzenjefilmas;

	//bi-directional many-to-one association to Zaduzenjeserije
	@OneToMany(mappedBy="clan")
	private List<Zaduzenjeserije> zaduzenjeserijes;

	public Clan() {
	}

	public int getIdClan() {
		return this.idClan;
	}

	public void setIdClan(int idClan) {
		this.idClan = idClan;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumUpisa() {
		return this.datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public List<Zaduzenjefilma> getZaduzenjefilmas() {
		return this.zaduzenjefilmas;
	}

	public void setZaduzenjefilmas(List<Zaduzenjefilma> zaduzenjefilmas) {
		this.zaduzenjefilmas = zaduzenjefilmas;
	}

	public Zaduzenjefilma addZaduzenjefilma(Zaduzenjefilma zaduzenjefilma) {
		getZaduzenjefilmas().add(zaduzenjefilma);
		zaduzenjefilma.setClan(this);

		return zaduzenjefilma;
	}

	public Zaduzenjefilma removeZaduzenjefilma(Zaduzenjefilma zaduzenjefilma) {
		getZaduzenjefilmas().remove(zaduzenjefilma);
		zaduzenjefilma.setClan(null);

		return zaduzenjefilma;
	}

	public List<Zaduzenjeserije> getZaduzenjeserijes() {
		return this.zaduzenjeserijes;
	}

	public void setZaduzenjeserijes(List<Zaduzenjeserije> zaduzenjeserijes) {
		this.zaduzenjeserijes = zaduzenjeserijes;
	}

	public Zaduzenjeserije addZaduzenjeserije(Zaduzenjeserije zaduzenjeserije) {
		getZaduzenjeserijes().add(zaduzenjeserije);
		zaduzenjeserije.setClan(this);

		return zaduzenjeserije;
	}

	public Zaduzenjeserije removeZaduzenjeserije(Zaduzenjeserije zaduzenjeserije) {
		getZaduzenjeserijes().remove(zaduzenjeserije);
		zaduzenjeserije.setClan(null);

		return zaduzenjeserije;
	}

}