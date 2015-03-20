package com.android.cssking.rooms;

import com.android.cssking.Spel;
import com.android.cssking.rooms.KamerObject;

/**
 * Created by Robert on 20-3-2015.
 */
public class Blok extends KamerObject {
    private int blokId = -1;

    public Blok(int x, int y)
    {
        setX(x);
        setY(y);
        setSprite(Spel.BLOK_SPRITE);
    }

    public Blok(int x, int y, int blokId)
    {
        setX(x);
        setY(y);
        setSprite(Spel.BLOK_SPRITE);
        this.blokId = blokId;
    }


    public int getBlokId()
    {
        return this.blokId;
    }




}
