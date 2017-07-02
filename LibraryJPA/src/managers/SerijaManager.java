package managers;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Clan;
import model.Primerakfilm;
import model.Primerakserija;
import model.Serija;
import model.Zaduzenjefilma;
import model.Zaduzenjeserije;
import model.Zanr;

public class SerijaManager {
	
	public Serija dodajSeriju(Serija serija,Zanr zanr){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			serija.setZanr(zanr);
			em.persist(serija);
			em.getTransaction().commit();
			em.close();
			em.refresh(serija);
			return serija;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Serija updateSerija (int idSerija, String produkcijskaKuca){
		try{
			EntityManager em=JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Serija s = em.find(Serija.class, idSerija);
			
			s.setProdukcijsaKuca(produkcijskaKuca);
			em.merge(s);
			em.getTransaction().commit();
		
			return s;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Serija getSerijaForId(int idserije) {
		EntityManager em = JPAUtil.getEntityManager();
		Serija s = em.find(Serija.class, idserije);
		em.close();
		return s;
	}
	
	public List<Serija> sveSerije(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Serija> q = em.createQuery("from Serija s ",Serija.class);
		List<Serija> serije = q.getResultList();
		em.close();
		return serije;
	}
	
	public List<Serija> getSerijeForNaslov(String naslov) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Serija> q = em.createQuery("select s from Serija s where s.naslov like :naslov", Serija.class);
		q.setParameter("naslov", "%" + naslov + "%");
		List<Serija> retVal = q.getResultList();
		em.close();
		return retVal;
	}
	
	

	public Zaduzenjeserije saveZaduzenjeSerija(int idClana, int invBroj) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Clan clan = em.find(Clan.class, idClana);
			Primerakserija pr = em.find(Primerakserija.class, invBroj);
			Zaduzenjeserije zad = new Zaduzenjeserije();
			zad.setClan(clan);
			zad.setPrimerakserija(pr);
			zad.setDatumZaduzenja(new Date());
			zad.setDatumVracanjaSerije(null);
			em.persist(zad);
			em.getTransaction().commit();
			em.close();
			return zad;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	
	public static void main(String [] args) throws ParseException{
		SerijaManager sm = new SerijaManager();
		

	
	}}
