package com.ls.asset;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ls.screen.LoadingScreen;
import com.sun.org.glassfish.gmbal.ManagedAttribute;

public class AssetManagerTest implements ApplicationListener {

	AssetManager assetManager;
	BitmapFont font;
	SpriteBatch batch;
	BitmapFont font2;
	TextureAtlas textureAtlas;
	Texture texture;
	Texture progressBar_BG;
	Texture progressBar_FT;
	TextureRegion region;
	float progress;

	boolean diagnosed = false;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("window/tishi.fnt"), false);
		assetManager = new AssetManager();
		progressBar_BG = new Texture(Gdx.files.internal("asset/white_bar.jpg"));
		progressBar_FT = new Texture(Gdx.files.internal("asset/green_bar.jpg"));
		region = new TextureRegion(progressBar_BG, 0, 0, 512, 64);
		load();
	}
/**资源加载*/
	private void load() {
		// TODO Auto-generated method stub
		assetManager.load("back.jpg", Texture.class);
		assetManager.load("ls.png", Texture.class);
		assetManager.load("lable.fnt", BitmapFont.class);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		boolean result = assetManager.update();//正式资源加载
		if (result & !diagnosed) {
			diagnosed = true;
			unLoad();
			load();
			diagnosed = false;
		}
		batch.begin();
		if (assetManager.isLoaded("back.jpg", Texture.class)) {
			batch.draw(assetManager.get("back.jpg", Texture.class), 100, 100);
		}
		if (assetManager.isLoaded("ls.png", Texture.class)) {
			batch.draw(assetManager.get("ls.png", Texture.class), 200, 100);
		}
		if (assetManager.isLoaded("lable.fnt", BitmapFont.class)) {
			assetManager.get("ls.png", BitmapFont.class).draw(batch, "测试", 300,
					0);
		}

		progress = assetManager.getProgress() * 700;//得到加载进度
		System.out.println("assetManager:" + progress);
		batch.draw(progressBar_FT, 40, 0, progress, 64);
		batch.draw(region, 0, 20);
		batch.end();

	}
	/**资源卸载*/
	private void unLoad() {
		// TODO Auto-generated method stub
		assetManager.unload("back.jpg");
		assetManager.unload("ls.png");
		assetManager.unload("lable.fnt");

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
