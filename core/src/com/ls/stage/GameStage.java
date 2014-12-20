package com.ls.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ls.actor.Mario;
import com.ls.tool.Constant;

public class GameStage extends Stage {
	Image backDrop;// ±³¾°Í¼Æ¬½ØÍ¼
	Mario mario;
	Texture texture;
	TextureRegion backDropRegion;
	Image mushRoom;
	TextureRegion mushRoomRegion;

	public GameStage() {
		super();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("object.jpg"));
		backDropRegion = new TextureRegion(texture, 512, 256, 512, 128);
		backDrop = new Image(backDropRegion);
		backDrop.setPosition(0, 170);
		mushRoomRegion = new TextureRegion(texture, 204, 0, 102, 85);
		mushRoom = new Image(mushRoomRegion);
		mushRoom.setPosition(290, 60);
		mario = new Mario(100, 190);
		addActor(backDrop);
		addActor(mario);
		addActor(mushRoom);
		addActor(mario.buttonL);
		addActor(mario.buttonR);
		mushRoom.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.STATE_FLAG = Constant.STORE_STAGE_ON;
				return true;
			}

		});
	}

}
