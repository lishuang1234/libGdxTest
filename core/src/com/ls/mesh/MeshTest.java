package com.ls.mesh;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MeshTest implements ApplicationListener {
	SpriteBatch batch;
	Texture texture;
	Mesh mesh;

	VertexAttribute color;
	VertexAttribute pos;
	VertexAttribute tex;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		pos = new VertexAttribute(Usage.Position, 3, "Position");
		color = new VertexAttribute(Usage.ColorPacked, 4, "Color");
		tex = new VertexAttribute(Usage.TextureCoordinates, 2, "Texture");
		mesh = new Mesh(true, 3, 3, pos, color, tex);
		mesh.setVertices(new float[] { -0.5f, -0.5f, 0,
				Color.toFloatBits(255, 0, 0, 255), 0, 1, 0.5f, -0.5f, 0,
				Color.toFloatBits(0, 255, 0, 255), 1, 1, 0, 0.5f, 0,
				Color.toFloatBits(0, 0, 255, 255), 0.5f, 0

		});// 设置顶点
		mesh.setIndices(new short[] { 0, 1, 2 });// 设置索引
		texture = new Texture(Gdx.files.internal("mesh/potato.png"));

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		texture.bind();
		//mesh.render(GL20.GL_TRIANGLES, 0);

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
