package com.ls.map;

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

public class MapTest implements ApplicationListener {
	TiledMap map;
	TiledMapRenderer renderer;
	Stage stage;
	Mario mario;
	OrthographicCamera camera;
	MapLayers mapLayers;
	int[] tiles;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();

		map = new TmxMapLoader().load("data/test.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		mapLayers = map.getLayers();
		//MapLayer mapLayer = mapLayers.get(0);

		System.out.println("layersCount:" + mapLayers.getCount());
		String name = map.getLayers().get(1).getName();
		System.out.println("name:  " + name);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		// camera.zoom = 10f;
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
		for (MapLayer mLayer : mapLayers) {
			if (mLayer.getName().equals("Actors")) {
				System.out.println("Actors is ");
				for (int i = 0; i < mLayer.getObjects().getCount(); i++) {

					if (mLayer.getObjects().get(i).getName().equals("player")) {
						MapObject object = mLayer.getObjects().get(i);
						mario.x = (Float) object.getProperties().get("x");
						mario.y = (Float) object.getProperties().get("y");
						System.out.println((Float) object.getProperties().get(
								"x")
								+ "   " + map.getProperties().get("width"));

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
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		renderer.setView(camera);
		renderer.render();

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
