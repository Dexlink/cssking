package com.android.cssking;

import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Robert on 16-3-2015.
 * TODO: fix herhalende code !!
 */
public class Speler extends Wezen implements ICollision {
    private HashMap<String, Boolean>skills = new HashMap<String, Boolean>();

    int currentFrame = 0;
    int currentFrameDelay = 0;

    public Speler()
    {
        setSprite("linkframes", 12);
        setFriction(0.25);

        setDirection(180);
        setSpeed(loopSnelheid);

        skills.put("display_none", false);
        skills.put("border", false);
    }

    @Override
    public void update()
    {
        super.update();


        ArrayList<GameObject> collidedObjects = getCollidedObjects();
        if(collidedObjects  != null)
        {

        }

        //Check of de speler beweegt, verander de sprite.
        if(getSpeed() < 0.01) {
            double orientatie = getDirection();
            Log.d("Orientatie", "" + orientatie);
            if (orientatie == 0)
                setFrameNumber(3);
            else if (orientatie == 90)
                setFrameNumber(8);
            else if (orientatie == 180)
                setFrameNumber(9);
            else if (orientatie == 270)
                setFrameNumber(0);
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
        }
    }

    public void setSkill(String skillName, boolean status)
    {
        if(skills.containsKey(skillName))
        {
            skills.put(skillName, status);
        }
    }

    public boolean getSkillStatus(String skillName)
    {
        if(skills.containsKey(skillName))
        {
            return skills.get(skillName);
        }
        return false;
    }


    @Override
    public void collisionOccurred(List<TileCollision> collidedTiles)
    {
        for(TileCollision tc : collidedTiles)
        {
            if(tc.theTile.getTileType() == Spel.BLOK_TILE)
            {
                moveUpToTileSide(tc);
                setSpeed(0);
                return;
            }
        }
    }


}
