package com.ls.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ls.tool.Constant;

public class StartStage extends Stage {
	Texture texture;
	TextureRegion startRegion;
	Image startImage;
	Image newGameImage;
	TextureRegion newGameRegion;

	public StartStage() {
		super();
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("start.jpg"));
		startRegion = new TextureRegion(texture, 0, 0, 800, 480);
		startImage = new Image(startRegion);
		startImage.setPosition(480, 800);
		newGameRegion = new TextureRegion(texture, 924, 0, 100, 50);
		newGameImage = new Image(newGameRegion);
		newGameImage.setPosition(40, 230);
		addActor(startImage);
		addActor(newGameImage);
		newGameImage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.STATE_FLAG = Constant.GAME_STAGE_ON;
				return true;
			}
		});
	}
	

}
