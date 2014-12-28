package com.ls.luobo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyGame extends Game {
	Music music;
	public static OrthographicCamera camera;

	StartScreen startScreen;
	LoadingScreen loadingScreen;
	SelectScreen selectScreen;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		startScreen = new StartScreen(this);
		loadingScreen = new LoadingScreen(this);
		selectScreen  = new SelectScreen(this);
		music = Gdx.audio.newMusic(Gdx.files.internal("luobo/BGMusic.ogg"));
		music.play();
		music.setLooping(true);
		music.setVolume(15);
		this.setScreen(startScreen);
	}

}
