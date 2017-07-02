package managers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Film;
import model.Kategorija;
import model.Zanr;

public class KategorijaManager {
	
	public Kategorija dodajKategoriju(Kategorija kat) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(kat);
			em.getTransaction().commit();
			em.close();
			em.refresh(kat);
			return kat;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Kategorija> getSveKategorije(){
		EntityManager em=JPAUtil.getEntityManager();
		TypedQuery<Kategorija> q=em.createQuery("from Kategorija k",Kategorija.class);
		List<Kategorija> kategorije=q.getResultList();
		em.close();
		return kategorije;
	}
	
	
	
	

	public static void main(String [] args) throws ParseException{
		
		KategorijaManager  km = new KategorijaManager();
		
		Kategorija kat = new Kategorija();
		kat.setIdKategorija(3);
		kat.setNazivKategorije("premium");
		km.dodajKategoriju(kat);
		
	}
}
