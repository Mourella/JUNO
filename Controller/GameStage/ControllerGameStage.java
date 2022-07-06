package Controller.GameStage;

import Model.GameStage.GameStage;
import View.Game.FrameViewGS;
import View.Game.Reader;

public class ControllerGameStage {
	public ControllerGameStage(GameStage game,Reader reader) {
		game.addObserver(reader);
		game.startGame();
	
	}

	
}
