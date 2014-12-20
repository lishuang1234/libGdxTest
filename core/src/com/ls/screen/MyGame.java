package com.ls.screen;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
	/**�����л�*/
	StartScreen startScreen;
	LoadingScreen loadingScreen;
	GameScreen gameScreen;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		startScreen = new StartScreen(this);
		loadingScreen = new LoadingScreen(this);
		gameScreen = new GameScreen(this);
		setScreen(startScreen);// ���ý���

	}

}
