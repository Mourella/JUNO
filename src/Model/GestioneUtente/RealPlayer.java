package Model.GestioneUtente;

/**
 * This class extend User. Thanks to this class we create 
 * a new RealPlayer
 * @author Davide Morelli
 */
public class RealPlayer extends User   {
	
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = -1443548732007291832L;

	/**
	 * Constructor of this class ,it creates a new RealPlayer with these nickname, avatar  and a new object statistics
	 * @param nickname
	 * @param pathAvatar
	 * 
	 */
	public RealPlayer(String nickname,String pathAvatar)  {
		
		this.setNickname(nickname); //set nickname
		this.setPathAvatar(pathAvatar); //set avatar
		this.setStatistics(new Statistics()); //set stats
		saveLoad.saveNewUtente(this); //save this player	
	}
}
