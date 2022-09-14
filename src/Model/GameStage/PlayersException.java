
package Model.GameStage;

/**
 * This class create an exception
 * @author Davide Morelli
 *
 */
public class PlayersException extends Exception {

	private static final long serialVersionUID = -1987500193782447923L;

	public PlayersException() {
		System.out.println("I giocatori devono essere maggiori di 0");
	}
}
