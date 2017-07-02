package beans;

import java.util.List;

import managers.SerijaManager;
import model.Clan;
import model.Serija;

public class GetSveSerijeBean {
	private List<Serija> sveSerije;


	public GetSveSerijeBean(){
		sveSerije=new SerijaManager().sveSerije();
		
	}

	public List<Serija> getSveSerije(){
		return sveSerije;
	}

	public void setSveSerije(List<Serija> sveSerije) {
		this.sveSerije = sveSerije;
	}
}
