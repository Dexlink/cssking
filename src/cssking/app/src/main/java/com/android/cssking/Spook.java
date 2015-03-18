package com.android.cssking;

import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;
import android.util.Log;

import java.util.List;
import java.util.Random;

/**
 * Created by Robert on 16-3-2015.
 * Spook is een wezen dat probeert te ontsnappen
 */
public class Spook extends Wezen implements ICollision {
    public Speler deSpeler;
    Random ran = new Random();
    boolean nieuweVluchtRoute = true;

    public Spook(Speler deSpeler)
    {
        this.deSpeler = deSpeler;
        setSprite("ghost");
        this.setX(100);
        this.setY(100);
    }


    @Override
    public void update()
    {
        super.update();

        //Check of de speler in de buurt is en ren weg
        int afstandXtotSpeler = Math.abs(deSpeler.getX() - this.getX());
        int afstandYtotSpeler = Math.abs(deSpeler.getY() - this.getY());

        if(afstandXtotSpeler < 150 && afstandYtotSpeler < 150)
        {
            //Vlucht, speler is te dichtbij
            if(nieuweVluchtRoute)
            {
                setDirectionSpeed(ran.nextInt(360), 8);
                nieuweVluchtRoute = false;
            }
            setSpeed(8);
        } else {
            setSpeed(0);
        }
    }

    public void teleporteerNaarRandomLocatie()
    {
        int randomX = 10 + ran.nextInt(350);
        int randomY = 10 + ran.nextInt(350);

        setX(randomX);
        setY(randomY);
    }

    public void collisionOccurred(List<TileCollision> collidedTiles)
    {
        for (TileCollision tc : collidedTiles)
        {
            if (tc.theTile.getTileType() == Spel.BLOK_SPRITE)
            {
                //Teleporteer naar een random plek
                teleporteerNaarRandomLocatie();
                nieuweVluchtRoute = true;
                setSpeed(0);
                return;
            }
        }
    }
}
