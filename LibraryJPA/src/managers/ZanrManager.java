package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Clan;
import model.Kategorija;
import model.Zanr;

public class ZanrManager {
	
	public Zanr dodajZanr(String nazivZanra){
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Zanr z = new Zanr();
			z.setNazivZanra(nazivZanra);
			em.persist(z);
			em.getTransaction().commit();
			em.refresh(z);
			return z;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Zanr getZanrForId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Zanr> q = em.createQuery("select z from Zanr z where z.idZanr = :id", Zanr.class);
		q.setParameter("id", id);
		List<Zanr> retVal = q.getResultList();
		em.close();
		return retVal.get(0);
	}	
	
	
	public List<Zanr> getSviZanrovi(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Zanr> q = em.createQuery("from Zanr z group by z.nazivZanra",Zanr.class);
		List<Zanr> zanrovi = q.getResultList();
		em.close();
		return zanrovi;	
	}
	
	public static void main(String [] args){
		
		ZanrManager zm = new ZanrManager();
		zm.dodajZanr("Komedija");
		zm.dodajZanr("Horor");
		zm.dodajZanr("Deciji");
		zm.dodajZanr("Dokumentarac");
		zm.dodajZanr("Mjuzikl");
		zm.dodajZanr("Naucna-fantastika");
		zm.dodajZanr("Fantastika");
		zm.dodajZanr("Triler");
		
		
		List<Zanr> zanrovi = new ZanrManager().getSviZanrovi();
		for(Zanr z : zanrovi){
			System.out.println(z.getNazivZanra());
		}
	}
}
