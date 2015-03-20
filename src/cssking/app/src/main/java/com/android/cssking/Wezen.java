package com.android.cssking;

import android.gameengine.icadroids.objects.MoveableGameObject;

/**
 * Created by Robert on 16-3-2015.
 */
public abstract class Wezen extends MoveableGameObject {
    private int HP = 100;
    private int kracht = 10;
    protected double loopSnelheid = 5;


    public void increaseHP(int punten) {
        this.HP += punten;
    }
    public void decreaseHP(int punten)
    {
        this.HP -= punten;
    }
    /*
    * Accessors
     */

    public void setKracht(int kracht)
    {
        this.kracht = kracht;
    }

    public int getKracht()
    {
        return this.kracht;
    }

    public void setHP(int hp)
    {
        this.HP = hp;
    }

    public int getHP()
    {
        return this.HP;
    }
}