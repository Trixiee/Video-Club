package managers;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Clan;
import model.Film;
import model.Primerakfilm;
import model.Zaduzenjefilma;
import model.Zanr;

public class FilmManager {
	
	public Film dodajFilm(Film film, Zanr zanr) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			film.setZanr(zanr);
			em.persist(film);
			em.getTransaction().commit();
			em.refresh(film);
			return film;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Film updateFilm (int idFilm, String produkcijskaKuca){
		try{
			EntityManager em=JPAUtil.getEntityManager();
			Film f = em.find(Film.class, idFilm);
	
			em.getTransaction().begin();
			f.setProdukcijskaKuca(produkcijskaKuca);
			em.merge(f);
			em.getTransaction().commit();
			return f;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Film getFilmForId(int idfilma) {
		EntityManager em = JPAUtil.getEntityManager();
		Film f = em.find(Film.class, idfilma);
		em.close();
		return f;
	}
	
	
	public List<Film> sviFilmovi(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Film> q = em.createQuery("from Film f ",Film.class);
		List<Film> filmovi = q.getResultList();
		em.close();
		return filmovi;
	}
	
	public List<Film> getFilmoviForNaslov(String naslov) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Film> q = em.createQuery("select f from Film f where f.naslov like :naslov  ", Film.class);
		q.setParameter("naslov", "%" + naslov + "%");
		List<Film> retVal = q.getResultList();
		em.close();
		return retVal;
	}
	
	
	

	public Zaduzenjefilma saveZaduzenjeFilm(int idClana, int invBroj) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Clan clan = em.find(Clan.class, idClana);
			Primerakfilm pr = em.find(Primerakfilm.class, invBroj);
			Zaduzenjefilma zad = new Zaduzenjefilma();
			zad.setClan(clan);
			zad.setPrimerakfilm(pr);
			zad.setDatumZaduzenjaFIlma(new Date());
			zad.setDatumVracanjaFilma(null);
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
		FilmManager fm = new FilmManager();
		
	}
	
}
