package com.ls.view;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class WindowTest implements ApplicationListener {
	SpriteBatch batch;
	Texture texture;
	ImageButton btn_A_ok;
	ImageButton btn_B_cancle;
	ImageButton btn_show;
	Stage stage;
	BitmapFont font;
	Window dialogWindow;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		stage = new Stage();
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("window/tishi.fnt"),
				Gdx.files.internal("window/tishi.png"), false);
		setButton();
		setWindow();
		setBtnListener();
		stage.addActor(btn_show);
		Gdx.input.setInputProcessor(stage);
	}

	private void setBtnListener() {
		// TODO Auto-generated method stub
		btn_show.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				stage.addActor(dialogWindow);// 显示对话框
				return true;
			}
		});
		btn_A_ok.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				Gdx.app.exit();// 推出
				return true;
			}
		});
		btn_B_cancle.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				dialogWindow.remove();
				return true;
			}
		});
	}

	private void setWindow() {
		// TODO Auto-generated method stub
		TextureRegionDrawable windowDrawable = new TextureRegionDrawable(
				new TextureRegion(new Texture(
						Gdx.files.internal("window/dia.png"))));// 对话框背景图片
		WindowStyle style = new WindowStyle(font, Color.RED, windowDrawable);
		dialogWindow = new Window("Game", style);
		dialogWindow.setHeight(Gdx.graphics.getHeight() / 1.5f);
		dialogWindow.setWidth(Gdx.graphics.getWidth() / 1.5f);
		dialogWindow.setPosition(100, 80);
		dialogWindow.setMovable(true);
		btn_A_ok.setPosition(Gdx.graphics.getWidth() / 10, 0);
		btn_B_cancle.setPosition(Gdx.graphics.getWidth() / 3, 0);
		dialogWindow.addActor(btn_A_ok);
		dialogWindow.addActor(btn_B_cancle);
	}

	private void setButton() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("window/button.png"));
		TextureRegion[][] split = TextureRegion.split(texture, 64, 64);// 图片裁剪
		TextureRegion[] regions = new TextureRegion[6];
		// 显示
		regions[0] = split[0][0];
		regions[1] = split[0][1];
		regions[2] = split[0][2];
		regions[3] = split[0][3];
		regions[4] = split[1][0];
		regions[5] = split[1][1];
		TextureRegionDrawable btn_show_up = new TextureRegionDrawable(
				regions[0]);
		TextureRegionDrawable btn_show_down = new TextureRegionDrawable(
				regions[1]);
		TextureRegionDrawable btn_A_up = new TextureRegionDrawable(regions[2]);
		TextureRegionDrawable btn_A_down = new TextureRegionDrawable(regions[3]);
		TextureRegionDrawable btn_B_up = new TextureRegionDrawable(regions[4]);
		TextureRegionDrawable btn_B_down = new TextureRegionDrawable(regions[5]);
		btn_show = new ImageButton(btn_show_up, btn_show_down);
		btn_A_ok = new ImageButton(btn_A_up, btn_A_down);
		btn_B_cancle = new ImageButton(btn_B_up, btn_B_down);
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
		batch.begin();
		font.draw(batch, "确定", 100, 200);
		batch.end();
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
