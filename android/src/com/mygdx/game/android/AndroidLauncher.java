package com.mygdx.game.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ls.actor.ActionTest;
import com.ls.actor.MushParticleTest;
import com.ls.actor.ParticleTest;
import com.ls.actor.TouchpadTest;
import com.ls.camera.OrthographicCameraTest;
import com.ls.map.Collide;
import com.ls.map.MapTest;
import com.ls.view.TexturePackerTest;
import com.mygdx.game.ImageTest;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.StagesTest;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Collide(), config);
	}
}
