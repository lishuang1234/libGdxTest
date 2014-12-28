package com.ls.plane;

import com.badlogic.gdx.Game;

public class PlaneGame extends Game {
	public static StartScreen startScreen;
	public static GameScreen gameScreen;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		startScreen = new StartScreen(this);
		gameScreen = new GameScreen(this);
		this.setScreen(startScreen);

	}

}
