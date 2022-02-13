package com.singleton.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Vector3;

public class SingletonGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Helicopter helicopter;

	private static final SingletonGame INSTANCE = new SingletonGame();
	private SingletonGame() {}
	public static SingletonGame getInstance() {
		return INSTANCE;
	}

	static final int height = 100;
	static final int width = 100;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("helicopter.png");
		helicopter = Helicopter.getHeliInstance();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		checkCrash();
		batch.begin();
		helicopter.render(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		helicopter.dispose();
	}

	private void checkCrash() {
		Vector3 helicopterPosition = helicopter.getPosition();
		if (helicopterPosition.x > (700-height) || helicopterPosition.x < 0) {
			helicopter.changeXmovement();
		}
		if (helicopterPosition.y < 0 || helicopterPosition.y > (500-width)) {
			helicopter.changeYmovement();
		}
	}
}
