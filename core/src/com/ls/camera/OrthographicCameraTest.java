package com.ls.camera;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class OrthographicCameraTest implements ApplicationListener {

	static final int WIDTH = 100;
	static final int HEIGHT = 100;
	private OrthographicCamera camera;
	// private Texture texture;
	private SpriteBatch batch;
	private Sprite sprite;

	// private Mesh mesh;
	// private Rectangle rectangle;
	private float rotationSpeed;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		rotationSpeed = 0.5f;
		sprite = new Sprite(new Texture(Gdx.files.internal("ls.png")));
		sprite.setSize((float) WIDTH, (float) HEIGHT);
		sprite.setPosition(0, 0);

		// mesh = new Mesh(true, 4, 6, new VertexAttribute(Usage.Position, 3,
		// "attr_Position"), new VertexAttribute(Usage.TextureCoordinates,
		// 2, "attr_texCoords"));
		// texture = new Texture(Gdx.files.internal("ls.png"));
		// mesh.setVertices(new float[] { -1024f, -1024f, 0, 0, 1, 1024f,
		// -1024f,
		// 0, 1, 1, 1024f, 1024f, 0, 1, 0, -1024f, 1024f, 0, 0, 0 });
		// mesh.setIndices(new short[] { 0, 1, 2, 2, 3, 0 });
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(200, 200);
		camera.position.set(WIDTH / 2, HEIGHT / 2, 0);

		// rectangle = new Rectangle(0, 0, WIDTH, HEIGHT);
		batch = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		handleInput();
		// GL20 gl = Gdx.graphics.getGL20();
		// gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// gl.glViewport((int) rectangle.x, (int) rectangle.y,
		// (int) rectangle.getWidth(), (int) rectangle.getHeight());// /?
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		// gl.glActiveTexture(GL20.GL_TEXTURE0);
		// gl.glEnable(GL20.GL_TEXTURE_2D);
		// texture.bind();
		//
		// mesh.render(GL20.GL_TRIANGLES);
		batch.begin();
		sprite.draw(batch);
		batch.end();

	}

	private void handleInput() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 0.2;// ½¹¾à
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 0.2;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			if (camera.position.x > 0)
				camera.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			if (camera.position.x < 1024)
				camera.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			if (camera.position.y > 0)
				camera.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			if (camera.position.y < 1024)
				camera.translate(0, 3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			camera.rotate(-rotationSpeed, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			camera.rotate(rotationSpeed, 0, 0, 1);
		}
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
