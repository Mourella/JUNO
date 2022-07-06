package Model.GestioneUtente;

public class UtenteNotExistException extends Exception {

	public UtenteNotExistException() {
		System.out.println("Utente non esistente");
	}
}
