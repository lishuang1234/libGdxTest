package com.ls.actor;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MushParticleTest implements ApplicationListener {
	SpriteBatch batch;
	ParticleEffect effect;
	int emitterIndex;
	Array<ParticleEmitter> emittersArray;
	int particleCount = 10;
	float fpsCounter;
	InputProcessor inputProcessor;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("particle/particle1.p"),
				Gdx.files.internal("particle/"));
		effect.setPosition(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		emittersArray = new Array<ParticleEmitter>(effect.getEmitters());// 粒子发射器
		effect.getEmitters().clear();
		effect.getEmitters().add(emittersArray.get(0));
		inputProcessor = new InputProcessor() {

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;

			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				effect.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				effect.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
				ParticleEmitter emitter = emittersArray.get(0);//得到发射器
				particleCount += 100;
				if (particleCount > emitter.getMaxParticleCount()) {// 大于最大离子数
					emitter.setMaxParticleCount(particleCount * 2);
				}
				System.out.println("count：：：" + particleCount);
				emitter.getEmission().setHigh(
						200);
				effect.getEmitters().clear();
				effect.getEmitters().add(emitter);
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
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
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		// batch.getProjectionMatrix().set(0, 0, Gdx.graphics.getWidth(),
		// Gdx.graphics.getHeight());
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		effect.draw(batch, delta);
		batch.end();

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
