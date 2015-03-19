package com.android.cssking;

import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 19-3-2015.
 */
public class Knop extends KamerObject implements ICollision {
    Wezen collisionObject; //Op welk wezen reageerd deze knop

    Knop(int x, int y, Wezen wezen)
    {
        setX(x);
        setY(y);
        this.collisionObject = wezen;
        setSprite("button", 2);
        setFrameNumber(1);
    }

    @Override
    public void update()
    {
        super.update();
        ArrayList<GameObject> collidedObjects = getCollidedObjects();

        if(collidedObjects == null)
            return;

        for(GameObject object : collidedObjects)
        {
            if(object instanceof Speler)
            {
                setFrameNumber(0);
            }
        }

    }

    public void collisionOccurred(List<TileCollision> collidedTiles)
    {
        //Doe niks een knop collide niet met tiles maar met wezen objecten, zie update
    }
}
