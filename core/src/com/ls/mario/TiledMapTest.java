package com.ls.mario;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ls.actor.Mario;

public class TiledMapTest implements ApplicationListener {
	public static TiledMap tiledMap;
	OrthogonalTiledMapRenderer renderer;
	OrthographicCamera camera;
	Stage stage;
	Mario mario;
	MapLayers mapLayers;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		tiledMap = new TmxMapLoader().load("mario/level1.tmx");
		mapLayers = tiledMap.getLayers();
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		stage = new Stage();
		mario = new Mario(0, 0);
		setMario();
		stage.addActor(mario);
		stage.addActor(mario.buttonL);
		stage.addActor(mario.buttonR);
		Gdx.input.setInputProcessor(stage);
	}

	private void setMario() {
		// TODO Auto-generated method stub
		for (MapLayer layer : mapLayers) {
			if (layer.getName().equals("Actors")) {
				for (int i = 0; i < layer.getObjects().getCount(); i++) {

					if (layer.getObjects().get(i).getName().equals("mario")) {
						MapObject object = layer.getObjects().get(i);
						mario.x = (Float) object.getProperties().get("x");
						mario.y = renderer.getViewBounds().height
								- (Float) object.getProperties().get("y");
						// System.out.println((Float)
						// object.getProperties().get(
						// "x")
						// + "   " + map.getProperties().get("width"));

					}

				}
			}
		}

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// camera.position.x = mario.x;
		renderer.getViewBounds().x = mario.x;
		stage.getCamera().position.x = mario.x;
		renderer.render();

		System.out.println("map的相机X位置：" + renderer.getViewBounds().x);
		System.out.println("stage的相机X位置：" + stage.getCamera().position.x);
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
