package com.ls.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Mario extends Actor {
	public static float x;
	public static float y;
	public static float stateTime;
	Texture texture;
	TextureRegion currentFrame;
	public ImageButton buttonL;
	public ImageButton buttonR;
	Animation aniRight;
	Animation aniLeft;
	Animation aniIdle;
	STATE state;

	enum STATE {
		Left, Right, Idle
	}

	public Mario(float x, float y) {
		this.x = x;
		this.y = y;
		stateTime = 0.0f;
		state = STATE.Idle;
		this.show();
	}

	/** ���������ã���ť���Ըı�λ�õõ�������Ӧ */
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		stateTime += Gdx.graphics.getDeltaTime();
		// System.out.println("state::" + stateTime);
		this.update();
		this.check();
		batch.draw(currentFrame, x, y);

	}

	public void show() {
		texture = new Texture(Gdx.files.internal("mario.png"));// ����ͼƬ��Դ
		TextureRegion[][] spilt = TextureRegion.split(texture, 64, 64);// �ָ�����
		TextureRegion[][] miror = TextureRegion.split(texture, 64, 64);
		for (TextureRegion[] regions : miror) {// ��ת����������Աx��Ϊ����
			for (TextureRegion region : regions) {
				region.flip(true, false);// �݆T��x�ᷭת�����������෴
			}
		}

		TextureRegion[] rightRegions = new TextureRegion[3];// �������ߵ������ͼ
		rightRegions[0] = spilt[0][0];
		rightRegions[1] = spilt[0][1];
		rightRegions[2] = spilt[0][2];
		aniRight = new Animation(0.1f, rightRegions);// ��������ʱ�Ķ���

		TextureRegion[] leftRegions = new TextureRegion[3];// �������ߵ������ͼ
		leftRegions[0] = miror[0][0];
		leftRegions[1] = miror[0][1];
		leftRegions[2] = miror[0][2];// ��ת��
		aniLeft = new Animation(0.1f, leftRegions);

		TextureRegion[] idleRegions = new TextureRegion[1];// ֹͣʱ��������ͼ
		idleRegions[0] = spilt[0][0];
		aniIdle = new Animation(0.1f, idleRegions);
		// ��ʼ����ť
		buttonL = new ImageButton(new TextureRegionDrawable(spilt[1][0]),
				new TextureRegionDrawable(spilt[1][1]));
		buttonR = new ImageButton(new TextureRegionDrawable(miror[1][0]),
				new TextureRegionDrawable(miror[1][1]));
		buttonL.setPosition(20, 20);
		buttonR.setPosition(100, 20);// ��ư�ťλ��
		buttonL.addListener(new InputListener() {// ���¼�

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = STATE.Left;
				return true;// ���뷵��true
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = STATE.Idle;
				super.touchUp(event, x, y, pointer, button);
			}
		});
		buttonR.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = STATE.Right;
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = STATE.Idle;
				super.touchUp(event, x, y, pointer, button);
			}
		});
	}

	/** �������� */
	public void update() {
		if (state == STATE.Right) {
			this.x += 1.5;
			if (x >= 400) {
				this.x = 400;
			}
		} else if (state == STATE.Left) {
			this.x -= 1.5;
			if (x <= 10) {
				this.x = 10;
			}
		}
	}

	/** �õ���һ֡ */
	public void check() {
		if (state == STATE.Left) {
			currentFrame = aniLeft.getKeyFrame(stateTime, true);
		} else if (state == STATE.Right) {
			currentFrame = aniRight.getKeyFrame(stateTime, true);
		} else if (state == STATE.Idle) {
			currentFrame = aniIdle.getKeyFrame(stateTime, true);
		}
	}
}
