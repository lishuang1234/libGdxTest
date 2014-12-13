package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageButtonTest implements ApplicationListener {
	Stage stage;
	TextureRegion[][] textureRegions;
	TextureRegionDrawable up;
	TextureRegionDrawable down;
	TextureRegion buttonUpRegion;
	TextureRegion buttonDownRegion;
	Texture texture;
	ImageButton imageButton;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("contral.png"));
		textureRegions = TextureRegion.split(texture, 120, 120);
		buttonUpRegion = textureRegions[0][0];
		buttonDownRegion = textureRegions[0][1];
		up = new TextureRegionDrawable(buttonUpRegion);
		down = new TextureRegionDrawable(buttonDownRegion);
		imageButton = new ImageButton(up, down);
		imageButton.setPosition(100, 0);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		stage.addActor(imageButton);

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
