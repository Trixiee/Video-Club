package beans;

import java.io.Serializable;
import java.util.List;

import managers.ClanManager;
import model.Clan;



@SuppressWarnings("serial")
public class GetSveClanoveBean implements Serializable {
	private List<Clan> sveClanove;


	public GetSveClanoveBean(){
		sveClanove=new ClanManager().getSviClanovi();
		
	}

	public List<Clan> getSveClanove(){
		return sveClanove;
	}

	public void setSveClanove(List<Clan> sveClanove) {
		this.sveClanove = sveClanove;
	}
}
