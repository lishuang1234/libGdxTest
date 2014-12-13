package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	// SpriteBatch batch;// SpriteBatch 就是一个画笔
	// Texture img;
	// private Texture lsPhoto;// 图片容器
	// private TextureRegion region;// 截图工具
	// private TextureRegion textureRegion;// 反响截图
	// private Sprite sprite;// 综合处理，旋转颜色等
	// private BitmapFont font;// 呈现位图字体

	// private FreeTypeFontGenerator generator;// 字体装在容器
	// private FreeTypeBitmapFontData fontData;
	// private BitmapFont bFont;


	@Override
	public void create() {
		// batch = new SpriteBatch();
		// img = new Texture("badlogic.jpg");
		// lsPhoto = new Texture("ls.png");
		// region = new TextureRegion(img, 0, 0, 100, 100);// 原图左上角为原点截图
		// sprite = new Sprite(region);
		// sprite.setSize(100, 100);// 设置绘制的大小
		// sprite.setOrigin(sprite.getHeight() / 2, sprite.getWidth() / 2);//
		// 设置旋转中心
		// sprite.setRotation(50);// 设值旋转角度以左为正
		// sprite.setPosition(0, 0);// 绘制位置
		// sprite.setColor(1, 0, 1, 1);// 绘制背景
		// textureRegion = new TextureRegion(img, 100, 100, -100, -100);//
		// 先反向在截图、
		// font = new BitmapFont(Gdx.files.internal("lss.fnt"),
		// Gdx.files.internal("lss.png"), false);// 不旋转
		// / font.setColor(0.5f, 0.4f, 0.6f, 1.0f);// 设置字体颜色
		// / font.setScale(1.0f);// 设置字体比例大小

		// generator = new
		// FreeTypeFontGenerator(Gdx.files.internal("baby.TTF"));
		// fontData = generator.generateData(20, generator.DEFAULT_CHARS
		// + "这是第一次测试\n李双", false);
		// bFont = new BitmapFont(fontData, fontData.getTextureRegions()[0],
		// false);

		

	}

	@Override
	public void render() {
		// Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		// batch.begin();
		// batch.draw(region, 0, 0);// 左下角为原点
		// sprite.draw(batch);// /综合实现效果，在指定位置、截图、旋转一定角度、设置背景颜色
		// batch.draw(textureRegion, 380, 700);// 左下角为原点
		// batch.draw(lsPhoto, 300, 300);
		// batch.draw(img, 0, 200);// 左下角为原点

		/** 设置换行文字显示 */
		// font.draw(batch, "李双", 0f, 700f);
		// font.drawMultiLine(batch, "这是我第一次\n测试的内容\n李双", 100, 200);

		// bFont.draw(batch, "长得好耍啊", 200, 700);
		// batch.end();

	

	}

}
