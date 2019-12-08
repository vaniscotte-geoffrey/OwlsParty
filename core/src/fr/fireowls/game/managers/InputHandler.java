package fr.fireowls.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.fireowls.game.objects.GameObject;
import fr.fireowls.game.objects.ID;
import fr.fireowls.game.objects.Player;
import fr.fireowls.game.utils.Values;

public class InputHandler implements InputProcessor {
    ObjectHandler handler;

    public InputHandler(ObjectHandler handler){
        this.handler = handler;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for(GameObject o : handler.getList()){
            if(o.getId() == ID.PLAYER){
                if(button == Input.Buttons.LEFT){
                    ((Player)o).goTo(screenX - Values.SQUARE_WIDTH / 2, Gdx.graphics.getHeight() - screenY - Values.SQUARE_HEIGHT / 2);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
