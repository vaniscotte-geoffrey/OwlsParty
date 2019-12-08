package fr.fireowls.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hud extends GameObject{
    BitmapFont font;
    Player p;

    public Hud(Player p) {
        super(0, 0, ID.HUD);
        this.p = p;
        font = new BitmapFont();
        font.setColor(Color.BLACK);
    }

    @Override
    public void dispose() {
        font.dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        font.draw(batch, "Score : "+p.getScore(), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()-10);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean collision(GameObject o) {
        return false;
    }
}
