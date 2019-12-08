package fr.fireowls.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.game.utils.Maths;
import fr.fireowls.game.utils.Values;

public class Player extends GameObject {
    Pixmap pixmap;
    Texture texture;

    final int WIDTH = (int) Values.SQUARE_WIDTH;
    final int HEIGHT = (int) Values.SQUARE_HEIGHT;
    private float speed = 2;

    private float targetX, targetY;
    private int score;

    public Player(float x, float y) {
        super(x, y, 0, 0, ID.PLAYER);
        pixmap = new Pixmap( WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLUE);
        pixmap.fillRectangle(0,0,WIDTH, HEIGHT);
        texture = new Texture(pixmap);
        targetX = x;
        targetY = y;
        score = 0;
    }

    public boolean collision(GameObject o){
        return x < o.getX() + Values.SQUARE_WIDTH &&
                x + Values.SQUARE_WIDTH > o.getX() &&
                y < o.getY() + Values.SQUARE_HEIGHT &&
                Values.SQUARE_HEIGHT + y > o.getY();
    }

    public void incScore(){
        score++;
    }

    public int getScore(){
        return score;
    }

    public void goTo(float x, float y){
        targetX = x;
        targetY = y;
        setVitX((x - getX()) / speed);
        setVitY((y - getY()) / speed);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, (int)x,(int)y);
    }

    @Override
    public void update() {
        affectSpeed();
        Maths.constraintObject(this, 0, Gdx.graphics.getWidth()-WIDTH, 0, Gdx.graphics.getHeight()-HEIGHT);
        if(Maths.closeTo(getX(), targetX)) setVitX(0);
        if(Maths.closeTo(getY(), targetY)) setVitY(0);
    }

    @Override
    public void dispose() {
        pixmap.dispose();
        texture.dispose();
    }
}
