package managers;

import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Clan;
import model.Kategorija;
import model.Primerakfilm;
import model.Zaduzenjefilma;
import model.Zaduzenjeserije;

public class ClanManager {

	public Clan saveClan(String ime, String prezime, String adresa, Date datumRodjenja, Date datumUpisa,
			int kat) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Clan c = new Clan();
			c.setIme(ime);
			c.setPrezime(prezime);
			c.setAdresa(adresa);
			c.setDatumRodjenja(datumRodjenja);
			c.setDatumUpisa(datumUpisa);
			c.setKategorija(em.find(Kategorija.class, kat));
			em.persist(c);
			em.getTransaction().commit();
			em.refresh(c);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Clan getClanForId(int idClan) {
		EntityManager em = JPAUtil.getEntityManager();
		Clan c = em.find(Clan.class, idClan);
		em.close();
		return c;
	}
	
	public List<Clan> getSviClanovi(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Clan> q = em.createQuery("select c from Clan c", Clan.class);
		List<Clan> retVal = q.getResultList();
		em.close();
		return retVal;
	}

	public List<Clan> getClanForImePrezime(String ime, String prezime) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Clan> q = em.createQuery("select c from Clan c where c.ime like :ime and c.prezime like :prezime", Clan.class);
		q.setParameter("ime", "%" + ime + "%");
		q.setParameter("prezime", "%" + prezime + "%");
		List<Clan> retVal = q.getResultList();
		em.close();
		return retVal;
	}
	
	public List<Clan> getClanoviZaDatumUpisaKategorija(Date datumUpisa, int kat){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Clan> query = em.createQuery("select c from Clan c where c.datumUpisa = :datumUpisa "
				+ "and c.kategorija = :kat", Clan.class);
		query.setParameter("datumUpisa", datumUpisa);
		query.setParameter("kat", em.find(Kategorija.class, kat));
		List<Clan> rez = query.getResultList();
		em.close();
		return rez;
	}
	

	public List<Clan> getClanoviZaKategorije(int kat){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Clan> query = em.createQuery("select c from Clan c where c.kategorija = :kat", Clan.class);
		query.setParameter("kat", em.find(Kategorija.class, kat));
		List<Clan> rez = query.getResultList();
		em.close();
		return rez;
		
	}

	public boolean razduziFilm(int idZaduzenja){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Zaduzenjefilma z = em.find(Zaduzenjefilma.class, idZaduzenja);
				z.setDatumVracanjaFilma(new Date());
				em.merge(z);
				em.getTransaction().commit();
				return true;			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean razduziSeriju(int idZaduzenja){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Zaduzenjeserije z = em.find(Zaduzenjeserije.class, idZaduzenja);
				z.setDatumVracanjaSerije(new Date());
				em.merge(z);
				em.getTransaction().commit();
				return true;			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	

	public List<Zaduzenjefilma> prikazZaduzenjaFilmovaZaClana(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Zaduzenjefilma> q = em.createQuery("select z from Zaduzenjefilma z where z.clan.idClan = :id",
				Zaduzenjefilma.class);
		q.setParameter("id", id);
		List<Zaduzenjefilma> retVal = q.getResultList();
		em.close();
		return retVal;
	}


	public List<Zaduzenjeserije> prikazZaduzenjaSerijaZaClana(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Zaduzenjeserije> q = em.createQuery("select z from Zaduzenjeserije z where z.clan.idClan = :id",
				Zaduzenjeserije.class);
		q.setParameter("id", id);
		List<Zaduzenjeserije> retVal = q.getResultList();
		em.close();
		return retVal;
	}
	
	
	public void removeClan(int idClan){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Clan clan = em.find(Clan.class,idClan);
		Iterator<Zaduzenjefilma> it = clan.getZaduzenjefilmas().iterator();
		while(it.hasNext()) {
			em.remove(it.next());
			em.flush();
			it.remove();
		}
		Iterator<Zaduzenjeserije> it1 = clan.getZaduzenjeserijes().iterator();
		while(it1.hasNext()) {
			em.remove(it1.next());
			em.flush();
			it1.remove();
		}
		em.remove(clan);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	public static void main(String [] args) throws ParseException{
		ClanManager cm = new ClanManager();
		cm.removeClan(1);
	}
	
}


