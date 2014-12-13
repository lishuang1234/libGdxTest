package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ImageTest implements ApplicationListener {
	Stage stage;
	Texture texture;
	TextureRegion textureRegion;
	Image image;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("ls.png"));
		textureRegion = new TextureRegion(texture, 0, 0, 80, 80);
		image = new Image(textureRegion);
		image.setScale(1.2f);// 缩放
		image.setColor(Color.PINK);
		image.setPosition(200, 200);// 绘画七点
		image.setOrigin(0, 0);// 旋转中心
		image.setRotation(45);// 旋转角度
		image.setSize(100, 100);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		stage.addActor(image);

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
