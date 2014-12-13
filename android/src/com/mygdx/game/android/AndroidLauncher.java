package com.mygdx.game.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.AnimationTest;
import com.mygdx.game.ImageButtonTest;
import com.mygdx.game.ImageTest;
import com.mygdx.game.LableTest;
import com.mygdx.game.MarioGame;
import com.mygdx.game.MyGdxGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MarioGame(), config);

	}
}
