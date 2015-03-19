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



    Knop(int x, int y, String spritename, Wezen wezen)
    {
        super(x, y, spritename);
        this.collisionObject = wezen;
    }

    @Override
    public void update()
    {
        super.update();
        ArrayList<GameObject> collidedObjects = getCollidedObjects();

        for(GameObject object : collidedObjects)
        {
            if(object instanceof Speler)
            {
                //setSprite();
            }
        }

    }

    public void collisionOccurred(List<TileCollision> collidedTiles)
    {
        //Doe niks een knop collide niet met tiles maar met wezen objecten, zie update
    }


}
