package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ls.actor.Mario;

public class MusicTest implements ApplicationListener {

	public static boolean GameIsRunning;
	public static boolean ShopIsRunning;
	public static boolean SuccessIsRunning;

	Stage stage;
	Stage openStage;
	Image image;
	Image button;
	Mario mario;
	Image openImage;
	Image shop;
	Image rack;// ªıº‹
	Image coinImage;
	Image heartImage;
	Image buy;
	Stage shopMenueStage;
	Stage successStage;

	Music music;
	Music backMusic;
	Sound sound;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		show();
		setListener();
		setPosition();
		addActor();
		music.play();
		music.setLooping(true);
		music.setVolume(15);
	}

	private void addActor() {
		// TODO Auto-generated method stub
		openStage.addActor(openImage);
		openStage.addActor(button);
		stage.addActor(image);
		stage.addActor(mario);
		stage.addActor(mario.buttonL);
		stage.addActor(mario.buttonR);
		stage.addActor(shop);
		shopMenueStage.addActor(rack);
		shopMenueStage.addActor(coinImage);
		shopMenueStage.addActor(heartImage);
	}

	private void setPosition() {
		// TODO Auto-generated method stub
		image.setPosition(0, 170);
		button.setPosition(40, 230);
		shop.setPosition(290, 60);
		openImage.setSize(480, 320);
		rack.setPosition(0, 0);
		rack.setSize(480, 320);
		coinImage.setPosition(50, 50);
		heartImage.setPosition(190, 50);
		buy.setPosition(100, 100);
	}

	private void setListener() {
		// TODO Auto-generated method stub
		button.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				GameIsRunning = true;
				music.stop();
				sound.play();
				backMusic.play();

				return true;

			}
		});
		heartImage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				SuccessIsRunning = true;
				sound.play(15);
				return true;
			}
		});
		coinImage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				SuccessIsRunning = true;
				sound.play();
				return true;
			}
		});
		shop.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				ShopIsRunning = true;
				sound.play();
				backMusic.stop();
				return true;
			}
		});
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
		setStage();
		// ‰÷»æŒËÃ®
		stageRender();
	}

	private void stageRender() {
		// TODO Auto-generated method stub
		if (GameIsRunning) {
			Gdx.input.setInputProcessor(stage);
			if (ShopIsRunning) {
				Gdx.input.setInputProcessor(shopMenueStage);
				if (SuccessIsRunning) {
					Gdx.input.setInputProcessor(successStage);
					successStage.addActor(buy);
				}
			}
		} else {
			Gdx.input.setInputProcessor(openStage);
		}

	}

	private void setStage() {
		// TODO Auto-generated method stub
		if (GameIsRunning) {
			stage.act();
			stage.draw();
			if (ShopIsRunning) {
				shopMenueStage.act();
				shopMenueStage.draw();
				if (SuccessIsRunning) {
					successStage.act();
					successStage.draw();
				}
			}
		} else {
			openStage.act();
			openStage.draw();
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

	public void show() {
		mario = new Mario(100, 190);
		music = Gdx.audio.newMusic(Gdx.files.internal("start.ogg"));
		backMusic = Gdx.audio.newMusic(Gdx.files.internal("back.ogg"));
		sound = Gdx.audio.newSound(Gdx.files.internal("sound.wav"));
		Texture texture = new Texture(Gdx.files.internal("open.png"));
		Texture texture2 = new Texture(Gdx.files.internal("shop.png"));
		image = new Image(new Texture(Gdx.files.internal("13.png")));
		button = new Image(new NinePatch(texture, 924, 0, 100, 50));
		openImage = new Image(new TextureRegion(texture, 0, 0, 800, 480));
		shop = new Image(new TextureRegion(texture2, 204, 0, 102, 85));
		rack = new Image(new TextureRegion(texture2, 0, 85, 510, 350));
		coinImage = new Image(new TextureRegion(texture2, 0, 0, 102, 85));
		heartImage = new Image(new TextureRegion(texture2, 102, 0, 102, 85));
		buy = new Image(new TextureRegion(texture2, 510, 0, 255, 255));
		stage = new Stage();
		openStage = new Stage();
		shopMenueStage = new Stage();
		successStage = new Stage();
	}
}