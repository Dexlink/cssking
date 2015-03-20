package com.android.cssking.rooms;

import com.android.cssking.Wezen;

/**
 * Created by Robert on 20-3-2015.
 */
public class Exit extends KamerObject {
    Wezen collisionObject;

    public Exit(int x, int y, Wezen wezen)
    {
        setX(x);
        setY(y);
        collisionObject = wezen;
    }
}
