package com.ls.luobo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SelectScreen implements Screen, GestureListener {
	MyGame game;
	public static float GAME_STAGE_WIDTH;
	public static float GAME_STAGE_HEIGHT;
	public static float CHAPTER_WIDTH;
	public static float CHAPTER_HEIGHT;// �½�ͼƬ�Ŀ��

	public static float CHAPTER_INTERVAL;// �ڷż��
	public static float CHAPTER_ROLLBACKSPEED;// ÿ��ͼƬ�ع��ٶ�

	float disRollBack;// ���X����仯���
	float touch_X;
	float touch_Y;
	float touchBaseX;
	float touchBaseY;
	float baseOffSet;

	float SELECT_STATE;
	float SELECT_CHAPTER_FIRST;
	float SELECT_CHAPTER_SECOND;
	float SELECT_CHAPTER_THIRD;
	float SELECT_CHAPTER_FOURTH;
	float SELECT_CHAPTER_FIFTH;

	boolean isRollbacking;
	boolean isTouching;
	SpriteBatch batch;
	TextureAtlas atlas;// ���������ͼƬ
	TextureRegion[] pages;

	Texture texture;
	Image[] images;

	Stage stage;
	Sound sound;
	Sound selectSound;

	Vector3 vector3;

	public SelectScreen(MyGame myGame) {
		// TODO Auto-generated constructor stub
		this.game = myGame;

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		batch.begin();
		batch.draw(texture, 0, 0, GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);
		batch.end();
		stage.act();
		stage.draw();
	}

	private void update() {
		// TODO Auto-generated method stub
		// justTouched()��ʼ������ָ�ĵ�һ����
		if (Gdx.input.justTouched() && !isTouching) {
			// System.out.println("Gdx.input.justTouched()");
			isTouching = true;
			touchBaseX = Gdx.input.getX(0);
			touchBaseY = Gdx.input.getY(0);
			// System.out.println("Gdx.input.justTouched()    :  " +
			// touchBaseX);
			// System.out
			// .println("Gdx.input.justTouched()    stage.getCamera().position.x  :  "
			// + stage.getCamera().position.x);
			touchBaseX += stage.getCamera().position.x - GAME_STAGE_WIDTH / 2;// ����Ļ����ת��Ϊ��̨����
		} else if (Gdx.input.isTouched(0) && isTouching) {// isTouch()��������ʱ����µĵ�
			touch_X = Gdx.input.getX(0);
			touch_Y = Gdx.input.getY(0);
			System.out.println("Gdx.input.isTouched(0)" + vector3.x);
			// ���������������ƶ�����ָ�����෴
			stage.getCamera().position.set(touchBaseX - touch_X + vector3.x,
					vector3.y, vector3.z);
		} else {
			isTouching = false;
			if (!isRollbacking) {
				rollBackPre();
			} else {
				rollBack();
			}
		}
	}

	private void rollBack() {
		// TODO Auto-generated method stub
		float temDis = disRollBack * Gdx.graphics.getDeltaTime()
				* CHAPTER_ROLLBACKSPEED;
		stage.getCamera().position.x -= temDis;
		disRollBack -= temDis;
		if (Math.abs(disRollBack) < 0.1) {
			stage.getCamera().position.x -= disRollBack;
			isRollbacking = false;
		}
	}

	private void rollBackPre() {
		// TODO Auto-generated method stub
		float cameX = stage.getCamera().position.x;
		disRollBack = cameX - (images[0].getX() + CHAPTER_WIDTH / 2);// ���X�������һ��ͼ�е����
		// ���������ָ����Ϊֹ������½�ͼƬ���ĸ�
		for (int i = 1; i < images.length; i++) {
			float tmp = cameX - (images[i].getX() + CHAPTER_WIDTH / 2);
			if (Math.abs(tmp) < Math.abs(disRollBack)) {
				disRollBack = tmp;
			}
		}
		isRollbacking = true;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GAME_STAGE_WIDTH = Gdx.graphics.getWidth();
		GAME_STAGE_HEIGHT = Gdx.graphics.getHeight();// ������
		CHAPTER_WIDTH = GAME_STAGE_WIDTH * 0.625f;// �½�ͼƬ��
		CHAPTER_HEIGHT = GAME_STAGE_HEIGHT * 0.7f;// �½�ͼƬ��
		CHAPTER_INTERVAL = GAME_STAGE_WIDTH * 0.375f;// �½�ͼƬ֮��ľ���
		CHAPTER_ROLLBACKSPEED = GAME_STAGE_WIDTH / 50;// �½�ͼƬ�������ٶ�
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("luobo/bg.png"));// ������
		sound = Gdx.audio.newSound(Gdx.files.internal("luobo/MenuSelect.ogg"));// �˵�ѡ������
		selectSound = Gdx.audio
				.newSound(Gdx.files.internal("luobo/Select.ogg"));
		stage = new Stage();
		Gdx.input.setInputProcessor(new GestureDetector(this));// ����ʶ��ļ���
		pages = new TextureRegion[5];
		images = new Image[5];
		atlas = new TextureAtlas(Gdx.files.internal("luobo/potato.pack"));// �½�ͼƬ���

		baseOffSet = (GAME_STAGE_WIDTH - CHAPTER_WIDTH) / 2;
		System.out.println("baseOffset�ĳ�ʼֵ��" + baseOffSet
				+ "  GAME_STAGE_WIDTH :" + GAME_STAGE_WIDTH
				+ "  CHAPTER_WIDTH:" + CHAPTER_WIDTH);
		float offSet = baseOffSet;// ��ʼXλ��
		for (int i = 0; i < pages.length; i++) {
			// ͨ�������ҵ���TexturePacker�����ͼƬ
			pages[i] = atlas.findRegion((i + 1) + "");
			images[i] = new Image(pages[i]);// ���õ���ͼƬ����Image
			// �O��Image�Ĵ�С��λ��
			images[i].setSize(GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);
			images[i].setPosition(offSet,
					-(GAME_STAGE_HEIGHT - CHAPTER_HEIGHT) / 2);// ����λ��
			offSet += GAME_STAGE_WIDTH;// /�½�ͼƬX������ۼ�
			stage.addActor(images[i]);
		}
		vector3 = new Vector3(stage.getCamera().position);
		System.out.println("�����λ�ã�x" + stage.getCamera().position.x + "  y "
				+ stage.getCamera().position.y);// /��̨����
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

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
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
