package com.android.cssking;

import android.gameengine.icadroids.input.OnScreenButton;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Robert on 16-3-2015.
 * TODO: fix herhalende code !!
 */
public class Speler extends Wezen implements ICollision {
    HashMap<String, Boolean>skills = new HashMap<String, Boolean>();
    int currentFrame = 0;
    int currentFrameDelay = 0;

    public Speler()
    {
        setSprite("linkframes", 12);
        setFriction(0.25);

        setDirection(180);
        setSpeed(loopSnelheid);
    }

    @Override
    public void update()
    {
        super.update();

        //Check of de speler beweeg
        if(getSpeed() < 0.01)
        {
            switch(orientatie)
            {
                case 0:
                    setFrameNumber(3);
                    break;
                case 90:
                    setFrameNumber(8);
                    break;
                case 180:
                    setFrameNumber(9);
                    break;
                case 270:
                    setFrameNumber(0);
                    break;
            }
        }

        //Handel input af van de push buttons
        if(OnScreenButtons.dPadUp)
        {
            //Juiste sprite voor het lopen
            if(currentFrame == 5){
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(4);
                    currentFrame = 4;
                    currentFrameDelay = 0;
                }
            } else {
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(5);
                    currentFrame = 5;
                    currentFrameDelay = 0;
                }
            }

            setDirectionSpeed(0, loopSnelheid);
            orientatie = 0;
        }
        else if(OnScreenButtons.dPadRight)
        {

            //Juiste sprite voor het lopen
            if(currentFrame == 7){
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(6);
                    currentFrame = 6;
                    currentFrameDelay = 0;
                }
            } else {
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(7);
                    currentFrame = 7;
                    currentFrameDelay = 0;
                }
            }

            setDirectionSpeed(90, loopSnelheid);
            orientatie = 90;
        }
        else if (OnScreenButtons.dPadDown)
        {
            //Juiste sprite voor het lopen
            if(currentFrame == 10){
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(11);
                    currentFrame = 11;
                    currentFrameDelay = 0;
                }
            } else {
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(10);
                    currentFrame = 10;
                    currentFrameDelay = 0;
                }
            }

            setDirectionSpeed(180, loopSnelheid);
            orientatie = 180;
        }
        else if(OnScreenButtons.dPadLeft)
        {
            //Juiste sprite voor het lopen
            if(currentFrame == 1){
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(2);
                    currentFrame = 2;
                    currentFrameDelay = 0;
                }
            } else {
                currentFrameDelay++;
                if(currentFrameDelay > 10) {
                    setFrameNumber(1);
                    currentFrame = 1;
                    currentFrameDelay = 0;
                }
            }
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
