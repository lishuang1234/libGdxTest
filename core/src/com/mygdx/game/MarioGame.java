package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ls.actor.Mario;

public class MarioGame implements ApplicationListener {
	Stage stage;
	Mario mario;
	Image image;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		image = new Image(new Texture(Gdx.files.internal("back.jpg")));
		image.setPosition(0, 170);
		stage = new Stage();
		mario = new Mario(100, 190);
		Gdx.input.setInputProcessor(stage);
		stage.addActor(image);//Ìí¼ÓÑÝÔ±
		stage.addActor(mario);
		stage.addActor(mario.buttonL);
		stage.addActor(mario.buttonR);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
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
