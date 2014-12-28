package com.ls.luobo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingScreen implements Screen {
	MyGame game;
	public static float GAME_STAGE_WIDTH;
	public static float GAME_STAGE_HEIGHT;
	SpriteBatch batch;
	Texture loadingTexture;
	float stateTime = 0;

	public LoadingScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		if (stateTime > 5) {
			game.setScreen(game.selectScreen);
		}
		batch.begin();
		batch.draw(loadingTexture, 0, 0, GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GAME_STAGE_HEIGHT = Gdx.graphics.getHeight();
		GAME_STAGE_WIDTH = Gdx.graphics.getWidth();
		batch = new SpriteBatch();
		loadingTexture = new Texture(Gdx.files.internal("luobo/loading.png"));

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
