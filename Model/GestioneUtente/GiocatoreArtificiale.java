package Model.GestioneUtente;


//i giocatori possono essere al massimo 10, per cui sceglie tra 10 giocatori
public class GiocatoreArtificiale extends Utente {
	
	private final String[] nickname= {"Magda","Furio","Mimmo","Melissa","Mirella","Franco","Federico","Federica","Francesco"};
	public GiocatoreArtificiale(int k) {
		this.setNickname(nickname[k]);
	}
	


	
	//TODO eredita i metodi che devo implementare di incrementa livello
}
