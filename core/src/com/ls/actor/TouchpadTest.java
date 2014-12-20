package com.ls.actor;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TouchpadTest implements ApplicationListener {
	Stage stage;
	Touchpad touchpad;
	Texture texture;
	Texture killerTexture;
	SpriteBatch batch;
	TextureRegionDrawable background;
	TextureRegionDrawable knob;
	TouchpadStyle touchpadStyle;
	int speed = 3;
	int x = 0;
	int y = 0;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("touch/touch.png"));
		killerTexture = new Texture(Gdx.files.internal("touch/2.png"));
		background = new TextureRegionDrawable(new TextureRegion(texture, 0, 0,
				128, 128));
		knob = new TextureRegionDrawable(new TextureRegion(texture, 128, 0,
				128, 128));
		touchpadStyle = new TouchpadStyle(background, knob);
		touchpad = new Touchpad(15, touchpadStyle);
		touchpad.setBounds(0, 0, 150, 150);
		stage.addActor(touchpad);
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
		update();
		batch.begin();
		batch.draw(killerTexture, x, y, 50, 50);
		batch.end();

		stage.act();
		stage.draw();

	}

	private void update() {
		// TODO Auto-generated method stub
		if (touchpad.isTouched()) {
			x += touchpad.getKnobPercentX() * speed;
			y += touchpad.getKnobPercentY() * speed;

		}

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
