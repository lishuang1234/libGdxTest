package com.ls.net;

import java.io.IOException;
import java.io.InputStream;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class NetTest implements ApplicationListener, HttpResponseListener {
	SpriteBatch batch;
	Texture texture;
	Texture texture2;
	HttpRequest request;
	Stage stage;
	ImageButton imageButton;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		texture2 = new Texture(Gdx.files.internal("net/btn.jpg"));
		TextureRegion upRegion = new TextureRegion(texture2, 0, 0, 90, 60);
		TextureRegion downRegion = new TextureRegion(texture2, 90, 0, 90, 60);
		TextureRegionDrawable upDrawable = new TextureRegionDrawable(upRegion);
		TextureRegionDrawable downDrawable = new TextureRegionDrawable(
				downRegion);
		imageButton = new ImageButton(upDrawable, downDrawable);
		imageButton.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				request = new HttpRequest(Net.HttpMethods.GET);
				request.setUrl("http://www.cnlie.cn/uploads/allimg/c130624/13H0D049B340-1c53.jpg");
				Gdx.net.sendHttpRequest(request, NetTest.this);
				return true;
			}
		});
		stage.addActor(imageButton);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		if (texture != null) {
			batch.begin();
			batch.draw(texture, 200, 200);
			batch.end();
		}
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

	@Override
	public void handleHttpResponse(HttpResponse httpResponse) {
		// TODO Auto-generated method stub

		final InputStream inputStream = httpResponse.getResultAsStream();
		try {
			texture = new Texture(new FileHandle("net/image.jpg") {

				@Override
				public InputStream read() {
					// TODO Auto-generated method stub
					return inputStream;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void failed(Throwable t) {
		// TODO Auto-generated method stub
		System.out.println("fail");

	}

	@Override
	public void cancelled() {
		// TODO Auto-generated method stub

	}

}
