package com.android.cssking;

import android.gameengine.icadroids.input.OnScreenButton;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Robert on 16-3-2015.
 */
public class Speler extends Wezen implements ICollision {
    HashMap<String, Boolean>skills = new HashMap<String, Boolean>();

    public Speler()
    {
        setSprite("zeldaframes", 12);
        setFriction(5);

        setDirection(180);
        setSpeed(5);
    }

    @Override
    public void update()
    {
        super.update();

        //Handel input af van de push buttons
        if(OnScreenButtons.dPadUp)
        {
            setFrameNumber(3);
            setDirectionSpeed(0, loopSnelheid);
            orientatie = 0;
        }
        else if(OnScreenButtons.dPadRight)
        {
            setFrameNumber(8);
            setDirectionSpeed(90, loopSnelheid);
            orientatie = 90;
        }
        else if (OnScreenButtons.dPadDown)
        {
            setFrameNumber(9);
            setDirectionSpeed(180, loopSnelheid);
            orientatie = 180;
        }
        else if(OnScreenButtons.dPadLeft)
        {
            setFrameNumber(0);
            setDirectionSpeed(270, loopSnelheid);
            orientatie = 270;
        }



    }


    @Override
    public void collisionOccurred(List<TileCollision> collidedTiles)
    {
        for(TileCollision tc : collidedTiles)
        {
            if(tc.theTile.getTileType() == Spel.BLOK_SPRITE)
            {
                moveUpToTileSide(tc);
                setSpeed(0);
                return;
            }
        }
    }


}
