package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	// SpriteBatch batch;// SpriteBatch ����һ������
	// Texture img;
	// private Texture lsPhoto;// ͼƬ����
	// private TextureRegion region;// ��ͼ����
	// private TextureRegion textureRegion;// �����ͼ
	// private Sprite sprite;// �ۺϴ�����ת��ɫ��
	// private BitmapFont font;// ����λͼ����

	// private FreeTypeFontGenerator generator;// ����װ������
	// private FreeTypeBitmapFontData fontData;
	// private BitmapFont bFont;


	@Override
	public void create() {
		// batch = new SpriteBatch();
		// img = new Texture("badlogic.jpg");
		// lsPhoto = new Texture("ls.png");
		// region = new TextureRegion(img, 0, 0, 100, 100);// ԭͼ���Ͻ�Ϊԭ���ͼ
		// sprite = new Sprite(region);
		// sprite.setSize(100, 100);// ���û��ƵĴ�С
		// sprite.setOrigin(sprite.getHeight() / 2, sprite.getWidth() / 2);//
		// ������ת����
		// sprite.setRotation(50);// ��ֵ��ת�Ƕ�����Ϊ��
		// sprite.setPosition(0, 0);// ����λ��
		// sprite.setColor(1, 0, 1, 1);// ���Ʊ���
		// textureRegion = new TextureRegion(img, 100, 100, -100, -100);//
		// �ȷ����ڽ�ͼ��
		// font = new BitmapFont(Gdx.files.internal("lss.fnt"),
		// Gdx.files.internal("lss.png"), false);// ����ת
		// / font.setColor(0.5f, 0.4f, 0.6f, 1.0f);// ����������ɫ
		// / font.setScale(1.0f);// �������������С

		// generator = new
		// FreeTypeFontGenerator(Gdx.files.internal("baby.TTF"));
		// fontData = generator.generateData(20, generator.DEFAULT_CHARS
		// + "���ǵ�һ�β���\n��˫", false);
		// bFont = new BitmapFont(fontData, fontData.getTextureRegions()[0],
		// false);

		

	}

	@Override
	public void render() {
		// Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		// batch.begin();
		// batch.draw(region, 0, 0);// ���½�Ϊԭ��
		// sprite.draw(batch);// /�ۺ�ʵ��Ч������ָ��λ�á���ͼ����תһ���Ƕȡ����ñ�����ɫ
		// batch.draw(textureRegion, 380, 700);// ���½�Ϊԭ��
		// batch.draw(lsPhoto, 300, 300);
		// batch.draw(img, 0, 200);// ���½�Ϊԭ��

		/** ���û���������ʾ */
		// font.draw(batch, "��˫", 0f, 700f);
		// font.drawMultiLine(batch, "�����ҵ�һ��\n���Ե�����\n��˫", 100, 200);

		// bFont.draw(batch, "���ú�ˣ��", 200, 700);
		// batch.end();

	

	}

}
