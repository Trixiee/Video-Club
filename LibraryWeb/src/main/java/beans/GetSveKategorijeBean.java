package beans;

import java.io.Serializable;
import java.util.List;


import managers.KategorijaManager;
import model.Kategorija;

@SuppressWarnings("serial")
public class GetSveKategorijeBean implements Serializable {
	private List<Kategorija> sveKategorije;
	
	
	public GetSveKategorijeBean(){
		sveKategorije=new KategorijaManager().getSveKategorije();
	}

	public List<Kategorija> getSveKategorije() {
		return sveKategorije;
	}

	public void setSveKategorije(List<Kategorija> sveKategorije) {
		this.sveKategorije = sveKategorije;
	}
	
	
}