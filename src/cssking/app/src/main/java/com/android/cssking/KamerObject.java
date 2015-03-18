package com.android.cssking;

import android.gameengine.icadroids.objects.GameObject;

/**
 * Created by Robert on 16-3-2015.
 */
public class KamerObject extends GameObject{
    private int positionX;
    private int positionY;
    private String spriteName;

    public KamerObject(int x, int y, String spriteName)
    {
        this.positionX = x;
        this.positionY = y;
    }



}
