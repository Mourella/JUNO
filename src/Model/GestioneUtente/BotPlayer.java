package Model.GestioneUtente;

import java.util.Map;
import java.util.Random;

/**
 * This class extend User,thanks to this class we create a new BotPlayer
 * @author Davide Morelli
 *
 */
public class BotPlayer extends User {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 7960110622820083701L;
	/**
	 * This field contains possible names to be associated with a bot.
	 */
	private final String[] NICKNAME= {"Furio","Franco","Mimmo","Giancarlo","Emidio","Melissa","Mirella","Federica","Magda","Annunziata"};
	/*
	 * This field contains a Map NicknameBot - avatarBot
	 */
	private final Map<String,String> NICK_AVATAR = Map.of("Furio","Image\\Avatar\\avatarBotM1.png","Franco","Image\\Avatar\\avatarBotM2.png",
			"Mimmo","Image\\Avatar\\avatarBotM3.png","Giancarlo","Image\\Avatar\\avatarBotM4.png","Emidio","Image\\Avatar\\avatarBotM5.png",
			"Melissa","Image\\Avatar\\avatarBotW1.png","Mirella","Image\\Avatar\\avatarBotW2.png","Federica","Image\\Avatar\\avatarBotW3.png",
			"Magda","Image\\Avatar\\avatarBotW4.png","Annunziata","Image\\Avatar\\avatarW3.png");
	/**
	 * Constructor of this class. Create a new BotPlayer with a random nickname
	 */
	public BotPlayer() {
		int index=new Random().nextInt(0,NICKNAME.length);
		this.setNickname(NICKNAME[index]);
		this.setPathAvatar(NICK_AVATAR.get(getNickname()));
	}
	

}
