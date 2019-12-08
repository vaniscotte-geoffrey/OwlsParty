package fr.fireowls.game.utils;

import fr.fireowls.game.objects.GameObject;

public class Maths {
    public static float distance = 0.5f;

    public static void constraintObject(GameObject o, float xMin, float xMax, float yMin, float yMax){
        if(o.getX() < xMin) o.setX(xMin);
        if(o.getX() > xMax) o.setX(xMax);
        if(o.getY() < yMin) o.setY(yMin);
        if(o.getY() > yMax) o.setY(yMax);
    }

    public static boolean closeTo(float x, float targetX){
        return x >= targetX-distance && x <= targetX+distance;
    }
}
