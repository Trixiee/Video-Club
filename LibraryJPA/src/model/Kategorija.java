package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorija;

	private String nazivKategorije;

	//bi-directional many-to-one association to Clan
	@OneToMany(mappedBy="kategorija")
	private List<Clan> clans;

	public Kategorija() {
	}

	public int getIdKategorija() {
		return this.idKategorija;
	}

	public void setIdKategorija(int idKategorija) {
		this.idKategorija = idKategorija;
	}

	public String getNazivKategorije() {
		return this.nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

	public Clan addClan(Clan clan) {
		getClans().add(clan);
		clan.setKategorija(this);

		return clan;
	}

	public Clan removeClan(Clan clan) {
		getClans().remove(clan);
		clan.setKategorija(null);

		return clan;
	}

}