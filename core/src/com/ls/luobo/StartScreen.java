package com.ls.luobo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class StartScreen implements Screen {
	MyGame game;
	Texture startTexture;
	Texture buttonTexture;
	TextureRegion startRegion;
	TextureRegion buttonRegion;
	SpriteBatch batch;

	Image button;
	Stage stage;
	Sound sound;
	public static float GAME_STAGE_WIDTH;
	public static float GAME_STAGE_HEIGHT;

	public StartScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(startRegion, 0, 0, GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);
		batch.end();
		stage.act();
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GAME_STAGE_WIDTH = Gdx.graphics.getWidth();
		GAME_STAGE_HEIGHT = Gdx.graphics.getHeight();
		System.out.println(GAME_STAGE_WIDTH + "   " + GAME_STAGE_HEIGHT);
		stage = new Stage();
		sound = Gdx.audio.newSound(Gdx.files.internal("luobo/Select.ogg"));
		batch = new SpriteBatch();
		startTexture = new Texture(Gdx.files.internal("luobo/start.png"));
		buttonTexture = new Texture(Gdx.files.internal("luobo/button.png"));
		startRegion = new TextureRegion(startTexture, 0, 0, 1024, 512);
		buttonRegion = new TextureRegion(buttonTexture, 0, 0, 128, 64);
		button = new Image(buttonRegion);
		button.setPosition(GAME_STAGE_WIDTH / 16, GAME_STAGE_HEIGHT / 16);
		button.setColor(Color.BLACK);
		button.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				sound.play(15f);
				game.setScreen(game.loadingScreen);// ÇÐ»»ÓÎÏ·ÆÁÄ»
				return true;
			}

		});
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
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
