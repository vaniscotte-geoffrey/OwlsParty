package fr.fireowls.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.game.OwlsParty;
import fr.fireowls.game.utils.Values;

public class Cercle extends GameObject{

    Pixmap pixmap;
    Texture texture;
    float radius = Values.CERCLE_RADIUS;

    public Cercle(float x, float y) {
        super(x, y, ID.CERCLE);
        pixmap = new Pixmap((int)Values.CERCLE_RADIUS*2+1, (int)Values.CERCLE_RADIUS*2+1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.fillCircle((int)radius,(int)radius,(int)radius);
        texture = new Texture(pixmap);
    }

    public void decRadius(int val){
        radius -= val;
    }

    public boolean collision(GameObject o){
        float dx = x+radius - o.x;
        float dy = y+radius - o.y;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        return distance < radius + Values.SQUARE_WIDTH;
    }

    @Override
    public void dispose() {
        pixmap.dispose();
        texture.dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        pixmap.setColor(Color.RED);
        pixmap.fillCircle((int)Values.CERCLE_RADIUS,(int)Values.CERCLE_RADIUS,(int)radius);
        batch.draw(new Texture(pixmap), x, y);
    }

    @Override
    public void update() {
        if(radius <= 0) radius = 0;
    }
}
