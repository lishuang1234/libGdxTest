package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class LableTest implements ApplicationListener {
	Stage stage;
	LabelStyle labelStyle;
	BitmapFont font;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		font = new BitmapFont(Gdx.files.internal("lable.fnt"),
				Gdx.files.internal("lable.png"), false);// ²»Ðý×ª
		labelStyle = new LabelStyle(font, font.getColor());
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		Label label = new Label("Hello\n lable", labelStyle);
		label.setPosition(0, 500);
		label.setFontScale(2);
		label.setColor(Color.GREEN);
		stage.addActor(label);

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
