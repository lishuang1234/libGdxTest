package com.ls.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class StoreStage extends Stage {
	Texture texture;
	TextureRegion goodsShelfRegion;
	TextureRegion goldRegion;
	TextureRegion heartRegion;
	Image goodsShelf;
	Image goldImage;
	Image heartImage;

	public StoreStage() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		texture = new Texture(Gdx.files.internal("object.jpg"));
		goodsShelfRegion = new TextureRegion(texture, 0, 85, 510, 350);
		goodsShelf = new Image(goodsShelfRegion);
		goodsShelf.setSize(480, 320);
		heartRegion = new TextureRegion(texture, 0, 0, 102, 85);
		heartImage = new Image(heartRegion);
		goldRegion = new TextureRegion(texture, 102, 0, 102, 85);
		goldImage = new Image(goldRegion);
		goldImage.setPosition(50, 50);
		heartImage.setPosition(190, 50);
		addActor(goldImage);
		addActor(heartImage);
		addActor(goodsShelf);
		heartImage.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				Gdx.app.exit();
				return true;
			}

		});
		goldImage.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				Gdx.app.exit();
				return true;
			}

		});
	}

}
