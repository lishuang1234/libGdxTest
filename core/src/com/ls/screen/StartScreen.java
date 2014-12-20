package com.ls.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
	SpriteBatch batch;
	Texture texture;
	TextureRegion region;
	Texture texture_btn;
	TextureRegion region_btn;
	Image image;
	Stage stage;

	public StartScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(region, 0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
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
		stage = new Stage();
		texture = new Texture(Gdx.files.internal("screen/back.jpg"));
		region = new TextureRegion(texture, 0, 512, 512, 512);
		batch = new SpriteBatch();
		texture_btn = new Texture(Gdx.files.internal("screen/button.jpg"));
		region_btn = new TextureRegion(texture_btn, 128, 0, 64, 64);
		image = new Image(region_btn);
		image.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				game.setScreen(game.loadingScreen);// 设置新的界面
				return super.touchDown(event, x, y, pointer, button);
			}

		});
		image.setPosition(0, 0);
		stage.addActor(image);
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
