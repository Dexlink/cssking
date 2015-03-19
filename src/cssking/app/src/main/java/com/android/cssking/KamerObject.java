package com.android.cssking;

import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;

/**
 * Created by Robert on 16-3-2015.
 */
public class KamerObject extends MoveableGameObject{
    protected int positionX;
    protected int positionY;
    protected String spriteName;

    public KamerObject(int x, int y, String spriteName)
    {
        this.positionX = x;
        this.positionY = y;
        setSprite(spriteName);
    }



}
