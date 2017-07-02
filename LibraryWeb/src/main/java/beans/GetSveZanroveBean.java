package beans;

import java.io.Serializable;
import java.util.List;

import managers.ZanrManager;
import model.Zanr;

@SuppressWarnings("serial")
public class GetSveZanroveBean implements Serializable {
	private List<Zanr> sviZanrovi;

	public GetSveZanroveBean(){
		sviZanrovi=new ZanrManager().getSviZanrovi();
		
	}

	public List<Zanr> getSviZanrovi() {
		return sviZanrovi;
	}

	public void setSviZanrovi(List<Zanr> sviZanrovi) {
		this.sviZanrovi = sviZanrovi;
	}
	
}

	