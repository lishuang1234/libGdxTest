package com.ls.plane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen implements Screen {
	PlaneGame game;
	Texture textureBg1;
	Texture textureBg2;
	Texture planeTexture;
	TextureRegion region1;
	TextureRegion region2;
	SpriteBatch batch;

	float width;
	float height;
	int bg1x, bg1y, bg2x, bg2y;
	float touchX;
	float touchY;
	float touchBaseX;
	float touchBaseY;
	boolean isTouching;
	float disX;
	float disY;

	public GameScreen(PlaneGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		touch();// 获得手指滑动的距离
		logic();
		batch.begin();
		batch.draw(region1, bg1x, bg1y, 320, 852);
		batch.draw(region2, bg2x, bg2y, 320, 852);
		batch.draw(planeTexture, 120 + disX, disY, 80, 80);
		batch.end();
	}

	private void logic() {
		// TODO Auto-generated method stub
		bg1y -= 3;
		bg2y -= 3;// 背景的移动速度
		float RH1;
		float RH2;
		RH1 = region1.getRegionHeight();
		RH2 = region2.getRegionHeight();
		if (bg1y < -RH1) {// 如果背景1完全隐藏，就重新赋值坐标
			bg1y = bg2y + region1.getRegionHeight();
		}
		if (bg2y < -RH2) {
			bg2y = bg1y + region2.getRegionHeight();
		}
	}

	private void touch() {
		// TODO Auto-generated method stub
		if (Gdx.input.justTouched()) {// 开始按下的那个点
			touchBaseX = Gdx.input.getX(0);
			touchBaseY = Gdx.input.getY(0);
			System.out.println("touchBaseX::" + touchBaseX + " touchBaseY::"
					+ touchBaseY);
		} else if (Gdx.input.isTouched(0)) {// /更随手指的坐标
			touchX = Gdx.input.getX(0);
			touchY = Gdx.input.getY(0);
			System.out.println("touchX::" + touchX + " touchY::" + touchY);
		}
		disX = touchX - touchBaseX;
		disY = -touchY + touchBaseY;// 获得滑动的距离, 注意此处滑动的Y坐标轴原点为左上角

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
		batch = new SpriteBatch();
		textureBg1 = new Texture(Gdx.files.internal("plane/background1.png"));
		textureBg2 = new Texture(Gdx.files.internal("plane/background2.png"));
		planeTexture = new Texture(Gdx.files.internal("plane/plane.png"));

		region1 = new TextureRegion(textureBg1, 0, 0, 480, 852);
		region2 = new TextureRegion(textureBg2, 0, 0, 480, 852);// 截取現實的背景

		bg1x = bg2x = 0;
		bg1y = 0;
		bg2y = bg1y + region1.getRegionHeight();// 第二章图片纵坐标

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
