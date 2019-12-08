package fr.fireowls.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.fireowls.game.objects.Cercle;
import fr.fireowls.game.objects.GameObject;
import fr.fireowls.game.objects.ID;
import fr.fireowls.game.objects.Player;
import fr.fireowls.game.utils.Disposable;
import fr.fireowls.game.utils.Renderable;
import fr.fireowls.game.utils.Updatable;
import fr.fireowls.game.utils.Values;

public class ObjectHandler implements Renderable, Updatable, Disposable {
    private List<GameObject> list;
    private List<ActionEvent> actions;
    private float time = 0;

    public ObjectHandler(){
        list = new ArrayList<GameObject>();
    }

    public ObjectHandler(GameObject... list){
        this();
        this.list.addAll(Arrays.asList(list));
        actions = new ArrayList<>();
        actions.add(new ActionEvent(() -> {
            this.list.add(new Cercle((float)(Math.random() * (Gdx.graphics.getWidth()-Values.SQUARE_WIDTH)), (float)(Math.random() * (Gdx.graphics.getHeight() - Values.SQUARE_HEIGHT))));
        }, () -> {
            return !containID(ID.CERCLE);
        }));
        actions.add(new ActionEvent(() -> {
            this.list.remove(getID(ID.CERCLE));
            ((Player)getID(ID.PLAYER)).incScore();
        }, () -> {
            return collision(ID.PLAYER, ID.CERCLE);
        }));
        actions.add(new ActionEvent(() -> {
            if(getID(ID.CERCLE) != null) ((Cercle) getID(ID.CERCLE)).decRadius(((Player)getID(ID.PLAYER)).getScore()/2);
            time = 0;
        }, () -> {
            return time > 1;
        }));
    }

    public boolean collision(ID id){
        GameObject p = getID(id);
        for(GameObject o : list)
            if (collision(p,o)) return true;
        return false;
    }

    public boolean collision(GameObject p, GameObject o){
        return o.collision(p);
    }

    public boolean collision(GameObject p, ID id){
        for(GameObject o : list)
            if(o.getId() == id && collision(p, o)) return true;
        return false;
    }

    public boolean collision(ID id1, ID id){
        for(GameObject p : list)
            if(p.getId() == id1)
                for(GameObject o : list)
                    if(o.getId() == id && collision(p, o)) return true;
        return false;
    }

    public boolean containID(ID id){
        for(GameObject o : list)
            if(o.getId() == id) return true;
        return false;
    }

    public GameObject getID(ID id){
        for(GameObject o : list)
            if(o.getId() == id) return o;
        return null;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public boolean add(GameObject gameObject) {
        return list.add(gameObject);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public void clear() {
        list.clear();
    }

    public GameObject get(int i) {
        return list.get(i);
    }

    public List<GameObject> getList(){
        return list;
    }


    @Override
    public void render(SpriteBatch batch) {
        for (GameObject o : list)
            o.render(batch);
    }

    @Override
    public void update() {
        for(GameObject o : list)
            o.update();
        for(ActionEvent e : actions)
            e.action();
        time += Gdx.graphics.getDeltaTime();
    }

    @Override
    public void dispose() {
        for(GameObject o : list)
            o.dispose();
    }
}
