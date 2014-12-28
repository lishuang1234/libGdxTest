package com.ls.plane;

import sun.management.resources.agent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class StartScreen implements Screen {
	PlaneGame game;
	Texture texture;
	Texture textureBg;
	TextureRegion region;
	Stage stage;
	Image image;
	Music music;
	SpriteBatch batch;
	float width;
	float height;

	public StartScreen(PlaneGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(region, 0, 0, width, height);
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
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		stage = new Stage();
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("plane/logo.png"));
		textureBg = new Texture(Gdx.files.internal("plane/background.png"));
		region = new TextureRegion(textureBg, 0, 0, 480, 852);
		music = Gdx.audio.newMusic(Gdx.files.internal("plane/plane.ogg"));
		music.play();
		music.setLooping(true);
		music.setVolume(15f);
		setImage();
		stage.addActor(image);
		Gdx.input.setInputProcessor(stage);
	}

	private void setImage() {
		// TODO Auto-generated method stub
		image = new Image(texture);
		image.setScale(0.7f);
		image.setPosition(0, height / 2 - image.getHeight() / 2);
		image.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				game.setScreen(game.gameScreen);
				stage.clear();
				return false;
			}

		});

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
