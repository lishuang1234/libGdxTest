package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ls.actor.ParticleTest;
import com.ls.asset.AssetManagerTest;
import com.ls.map.Collide;
import com.ls.screen.MyGame;
import com.ls.view.WindowTest;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new AssetManagerTest(), config);
	}
}
