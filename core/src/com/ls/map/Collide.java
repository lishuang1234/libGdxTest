package com.ls.map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Collide implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	TiledMap tiledMap;
	TextureRegion region;
	OrthogonalTiledMapRenderer renderer;
	private static int[][] barriers;
	float x;
	float y;
	public static final int MAP_TILE_WIDTH = 48;
	public static final int MAP_TILE_HEIGHT = 48;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("mario.png"));
		region = new TextureRegion(texture, 0, 0, 64, 64);
		tiledMap = new TmxMapLoader().load("data2/coll.tmx");
		barriers = new int[10][10];
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		setMario();
	}

	private void setMario() {
		// TODO Auto-generated method stub
		MapLayers mapLayers = tiledMap.getLayers();
		for (MapLayer mapLayer : mapLayers) {
			if (mapLayer.getName().equals("Mario")) {
				System.out.println(x + ":::" + y);
				MapObjects objects = mapLayer.getObjects();
				for (MapObject object : objects) {
					RectangleMapObject rObject = (RectangleMapObject) object;//获得对象层制定对象安排位置
					if (rObject.getName().equals("mario")) {
						x = rObject.getRectangle().getX()+32;
						y = rObject.getRectangle().getY()+32;
						System.out.println(x + ":::" + y);
					}
				}
			} else if (mapLayer.getName().equals("Section1")) {
				if (mapLayer instanceof TiledMapTileLayer) {
					TiledMapTileLayer tileLayer = (TiledMapTileLayer) mapLayer;

					for (int j = 10; j > 0; j--) {// 便利图层中的cell是否有内容
						for (int i = 0; i < 10; i++) {
							Cell cell = tileLayer.getCell(i, j);
							if (cell != null) {
								barriers[j][i] = 1;
								System.out.println("有物体存在:::" + j + "  " + i);// 从上至下遍历，左下角为原点
							}
						}
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
		camera.update();
		renderer.setView(camera);
		renderer.render();
		update();
		batch.begin();
		batch.draw(region, x, y);
		batch.end();
	}

	private void update() {
		// TODO Auto-generated method stub
		if (passEnable(x, y)) {
			x += 0.5f;
			System.out.println("yes ,you can mve");
		}
	}

	private boolean passEnable(float x2, float y2) {
		// TODO Auto-generated method stu
		return barriers[(int)( y2 / MAP_TILE_HEIGHT +0.5)][(int)(x2 / MAP_TILE_WIDTH +0.5)] != 1;
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
