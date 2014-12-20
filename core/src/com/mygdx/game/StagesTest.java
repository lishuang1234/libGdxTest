package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.ls.stage.GameStage;
import com.ls.stage.StartStage;
import com.ls.stage.StoreStage;
import com.ls.tool.Constant;

public class StagesTest implements ApplicationListener {
	GameStage gameStage;
	StartStage startStage;
	StoreStage storeStage;

	@Override
	public void create() {
		// TODO Auto-generated method stub

		gameStage = new GameStage();
		startStage = new StartStage();
		storeStage = new StoreStage();
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
		selectStageRender();

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

	public void selectStageRender() {
		if (Constant.STATE_FLAG == Constant.START_STAGE_ON) {
			Gdx.input.setInputProcessor(startStage);
			startStage.act();
			startStage.draw();
		} else if (Constant.STATE_FLAG == Constant.GAME_STAGE_ON) {
			Gdx.input.setInputProcessor(gameStage);
			gameStage.act();
			gameStage.draw();
		} else if (Constant.STATE_FLAG == Constant.STORE_STAGE_ON) {
			Gdx.input.setInputProcessor(storeStage);
			storeStage.act();
			storeStage.draw();
		}
	}
}
