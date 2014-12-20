package com.ls.actor;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ActionTest implements ApplicationListener, InputProcessor {
	Texture startTexture;
	Texture circleTexture;
	Stage stage;
	Image image;
	float delta;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		stage = new Stage();
		startTexture = new Texture(Gdx.files.internal("action/star.png"));
		circleTexture = new Texture(Gdx.files.internal("action/circle.png"));
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		delta += Gdx.graphics.getDeltaTime();
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
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		int roll = (int) (delta * 1000000);
		if (roll % 4 == 0) {
			createStar(MathUtils.randomBoolean(), screenX,
				 screenY, MathUtils.random(10, 20));
		}
		return false;
	}

	private void createStar(boolean randomBoolean, int screenX, int i,
			int random) {
		if (randomBoolean) {
			image = new Image(startTexture);
		} else {
			image = new Image(circleTexture);
		}
		setAction(image);
		image.setPosition(screenX - random / 2, i - random / 2);
		image.setSize(random, random);
		stage.addActor(image);

		// TODO Auto-generated method stub

	}

	private void setAction(Image image2) {
		// TODO Auto-generated method stub
		float x = image2.getX();
		float y = image2.getY();
		float duration = MathUtils.random(3, 10);
		MoveToAction moveAction = Actions.moveTo(240, 160, duration);
		float scale = MathUtils.random(0.5f, 0.2f);
		ScaleToAction scaleToAction = Actions.scaleTo(scale, scale, duration);
		float rotate = MathUtils.random(360);
		RotateToAction rotateToAction = Actions.rotateTo(rotate, duration);
		RunnableAction endActions = Actions.run(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("所有Action完成！");
			}
		});
		SequenceAction sequenceAction = Actions.sequence(
				Actions.fadeIn(duration), Actions.fadeIn(duration), endActions);// 顺序执行
		ParallelAction parallelAction = Actions.parallel(moveAction,
				scaleToAction, rotateToAction, sequenceAction);// 并行执行
		RepeatAction repeatAction = Actions.repeat(3, parallelAction);// 重复时间执行
		RepeatAction forveRepeatAction = Actions.forever(repeatAction);// 循环执行
		image2.addAction(parallelAction);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
