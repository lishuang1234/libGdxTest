package com.ls.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadingScreen implements Screen {

	MyGame game;
	SpriteBatch batch;
	Texture loadTexture;
	Animation animation;
	float stateTime = 0;

	public LoadingScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		TextureRegion loadRegion = animation.getKeyFrame(stateTime, true);
		if (stateTime > 5) {
			game.setScreen(game.gameScreen);
		}
		batch.begin();
		batch.draw(loadRegion, 180, 120, 100, 100);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		loadTexture = new Texture(Gdx.files.internal("screen/prepare.jpg"));
		batch = new SpriteBatch();
		setAni();

	}

	private void setAni() {
		// TODO Auto-generated method stub
		TextureRegion[][] arrayRegions = TextureRegion.split(loadTexture, 40,
				40);
		TextureRegion[] loadingRegions = new TextureRegion[12];
		loadingRegions[0] = arrayRegions[0][0];
		loadingRegions[1] = arrayRegions[0][1];
		loadingRegions[2] = arrayRegions[0][2];
		loadingRegions[3] = arrayRegions[0][3];
		loadingRegions[4] = arrayRegions[0][4];
		loadingRegions[5] = arrayRegions[1][0];

		loadingRegions[6] = arrayRegions[1][1];
		loadingRegions[7] = arrayRegions[1][2];
		loadingRegions[8] = arrayRegions[1][3];
		loadingRegions[9] = arrayRegions[1][4];
		loadingRegions[10] = arrayRegions[2][0];
		loadingRegions[11] = arrayRegions[2][1];
		animation = new Animation(0.1f, loadingRegions);
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
