package com.ls.view;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;

public class TexturePackerTest implements ApplicationListener {
	/**������СͼƬ����ɴ�ͼƬ�����Խ����ж���ͼƬ����һ��ͼƬ�����TextureAtlas�Ǵ���.pack �ļ��ķ��������������õ���ӦͼƬ*/
	SpriteBatch batch;
	TextureAtlas atlas;
	Animation animation;
	float stateTime = 0;
	Sprite sprite;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		atlas = new TextureAtlas(Gdx.files.internal("pack/test.pack"), false);
		animation = new Animation(0.1f, atlas.findRegions("donghua_jump"));
		System.out.println();
		atlas.findRegions("donghua_jump").get(1);
		sprite = atlas.createSprite("renwu");
		sprite.setPosition(100, 100);
		sprite.setSize(300, 300);

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
		stateTime += Gdx.graphics.getDeltaTime();
		batch.begin();
		sprite.draw(batch);
		batch.draw(animation.getKeyFrame(stateTime, true), 270, 50, 200, 150);
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
