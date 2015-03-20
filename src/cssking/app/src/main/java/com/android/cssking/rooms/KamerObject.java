package com.android.cssking.rooms;

import android.gameengine.icadroids.objects.MoveableGameObject;

import java.util.ArrayList;

/**
 * Created by Robert on 16-3-2015.
 */
public class KamerObject extends MoveableGameObject{
    public static final int KNOP_INGEDRUKT = 1;
    private ArrayList<KamerObjectListener> _listeners = new ArrayList<KamerObjectListener>();


    public KamerObject()
    {
    }


    public void addListener(KamerObjectListener l)
    {
        _listeners.add(l);
    }

    public void removeListener(KamerObjectListener l)
    {
        _listeners.remove(l);
    }

    protected void fireEvent(int event)
    {
        for(KamerObjectListener listener : _listeners)
        {
            listener.handelEventAf(event, this);
        }
    }

}
