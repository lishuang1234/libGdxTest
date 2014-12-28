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
	public static float CHAPTER_HEIGHT;// 章节图片的宽高

	public static float CHAPTER_INTERVAL;// 摆放间隔
	public static float CHAPTER_ROLLBACKSPEED;// 每张图片回滚速度

	float disRollBack;// 相机X坐标变化间隔
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
	TextureAtlas atlas;// 处理打包后的图片
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
		// justTouched()开始按下手指的第一个点
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
			touchBaseX += stage.getCamera().position.x - GAME_STAGE_WIDTH / 2;// 有屏幕坐标转化为舞台坐标
		} else if (Gdx.input.isTouched(0) && isTouching) {// isTouch()触摸结束时最后按下的点
			touch_X = Gdx.input.getX(0);
			touch_Y = Gdx.input.getY(0);
			System.out.println("Gdx.input.isTouched(0)" + vector3.x);
			// 滑动相机，相机的移动与手指方向相反
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
		disRollBack = cameX - (images[0].getX() + CHAPTER_WIDTH / 2);// 相机X坐标与第一张图中点距离
		// 计算距离手指结束为止最近的章节图片是哪个
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
		GAME_STAGE_HEIGHT = Gdx.graphics.getHeight();// 窗体宽高
		CHAPTER_WIDTH = GAME_STAGE_WIDTH * 0.625f;// 章节图片宽
		CHAPTER_HEIGHT = GAME_STAGE_HEIGHT * 0.7f;// 章节图片高
		CHAPTER_INTERVAL = GAME_STAGE_WIDTH * 0.375f;// 章节图片之间的距离
		CHAPTER_ROLLBACKSPEED = GAME_STAGE_WIDTH / 50;// 章节图片滑动的速度
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("luobo/bg.png"));// 主背景
		sound = Gdx.audio.newSound(Gdx.files.internal("luobo/MenuSelect.ogg"));// 菜单选择声音
		selectSound = Gdx.audio
				.newSound(Gdx.files.internal("luobo/Select.ogg"));
		stage = new Stage();
		Gdx.input.setInputProcessor(new GestureDetector(this));// 手势识别的监听
		pages = new TextureRegion[5];
		images = new Image[5];
		atlas = new TextureAtlas(Gdx.files.internal("luobo/potato.pack"));// 章节图片打包

		baseOffSet = (GAME_STAGE_WIDTH - CHAPTER_WIDTH) / 2;
		System.out.println("baseOffset的初始值：" + baseOffSet
				+ "  GAME_STAGE_WIDTH :" + GAME_STAGE_WIDTH
				+ "  CHAPTER_WIDTH:" + CHAPTER_WIDTH);
		float offSet = baseOffSet;// 初始X位置
		for (int i = 0; i < pages.length; i++) {
			// 通过名字找到用TexturePacker处理的图片
			pages[i] = atlas.findRegion((i + 1) + "");
			images[i] = new Image(pages[i]);// 将得到的图片生成Image
			// 設置Image的大小与位置
			images[i].setSize(GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);
			images[i].setPosition(offSet,
					-(GAME_STAGE_HEIGHT - CHAPTER_HEIGHT) / 2);// 设置位置
			offSet += GAME_STAGE_WIDTH;// /章节图片X坐标的累加
			stage.addActor(images[i]);
		}
		vector3 = new Vector3(stage.getCamera().position);
		System.out.println("相机的位置：x" + stage.getCamera().position.x + "  y "
				+ stage.getCamera().position.y);// /舞台中央
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
