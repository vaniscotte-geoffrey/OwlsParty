package fr.fireowls.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.game.managers.InputHandler;
import fr.fireowls.game.managers.ObjectHandler;
import fr.fireowls.game.objects.Cercle;
import fr.fireowls.game.objects.Hud;
import fr.fireowls.game.objects.Player;
import fr.fireowls.game.utils.Values;

public class OwlsParty extends ApplicationAdapter {
	SpriteBatch batch;
	ObjectHandler handler;
	InputHandler input;

	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		player = new Player(0,0);

		handler = new ObjectHandler(player, new Hud(player));
		input = new InputHandler(handler);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		handler.render(batch);
		batch.end();
	}

	private void update() {
		handler.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
		handler.dispose();
	}
}
