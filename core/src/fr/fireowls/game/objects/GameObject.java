package fr.fireowls.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.game.utils.Disposable;
import fr.fireowls.game.utils.Renderable;
import fr.fireowls.game.utils.Updatable;

public abstract class GameObject implements Renderable, Updatable, Disposable {
    float x, y;
    float vitX, vitY;
    ID id;

    public GameObject(float x, float y, float vitX, float vitY, ID id){
        this.x = x;
        this.y = y;
        this.vitX = vitX;
        this.vitY = vitY;
        this.id = id;
    }

    public GameObject(float x, float y, ID id){
        this(x,y,0,0,id);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVitX() {
        return vitX;
    }

    public float getVitY() {
        return vitY;
    }

    public ID getId() {
        return id;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVitX(float vitX) {
        this.vitX = vitX;
    }

    public void setVitY(float vitY) {
        this.vitY = vitY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void incVitX(float vitX){
        this.vitX += vitX;
    }

    public void incVitY(float vitY){
        this.vitY += vitY;
    }

    public void incX(float x){
        this.x += x;
    }

    public void incY(float y){
        this.y += y;
    }

    public void affectSpeed(){
        this.x += vitX;
        this.y += vitY;
    }

    public abstract boolean collision(GameObject o);
}
