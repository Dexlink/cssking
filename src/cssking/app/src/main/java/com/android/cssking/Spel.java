package com.android.cssking;

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.MotionSensor;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;
import android.gameengine.icadroids.tiles.GameTiles;

import com.android.cssking.rooms.Blok;
import com.android.cssking.rooms.KamerObject;
import com.android.cssking.rooms.KamerObjectListener;
import com.android.cssking.rooms.Knop;

import java.util.ArrayList;

/**
 * Main class of the game 'CSS King'
 * @author Robert Hendriks, Mitch Holewijn
 */
public class Spel extends GameEngine {
    //Constante
    public static final int BLOK_TILE = 0;
    public static final String BLOK_SPRITE = "blok";


    private int huidigeKamer = -1;
    private ArrayList<Kamer> kamerLijst = new ArrayList<Kamer>();
    private Speler speler;


	@Override
	protected void initialize() {
		// Set up control mechanisms to use
		TouchInput.use = false;
		MotionSensor.use = true;
		OnScreenButtons.use = true;
        speler = new Speler();

        addGameObject(speler);
        maakKamers();

        loadKamer(0);
        addGameObject(speler);

	}

    void loadKamer(int nieuweKamer)
    {
        if(kamerLijst.size() < nieuweKamer)
            throw new ArrayIndexOutOfBoundsException("Deze kamer bestaat niet !!");

        if(huidigeKamer != -1)
        {
            //Verwijder alle monsters
            deleteAllGameObjectsOfType(Wezen.class);
            //Verwijder alle objecten
            deleteAllGameObjectsOfType(KamerObject.class);
        }

        setTileMap(kamerLijst.get(nieuweKamer).tiles);

        //Laad alle monsters in van de kamer
        for(Wezen wezen : kamerLijst.get(nieuweKamer).wezenLijst)
        {
            addGameObject(wezen);
        }

        //Laad alle objecten in van de kamer
        for(KamerObject object : kamerLijst.get(nieuweKamer).objectenLijst)
        {
            addGameObject(object);
        }

        //Kamer geladen !
    }

    /*
    * Reset de huidge kamer door hem opnieuw in te laden, gebeurd voornamelijk wanneer de speler word geraakt door een vijand
     */
    public void resetKamer()
    {
        loadKamer(huidigeKamer);
    }


    /*
     * Initialiseer alle kamers zodat deze ingeladen kunnen worden door het spel
     * Een kamer bevat een tilemap, een ArrayList met wezens, en een ArrayList met kamerObjecten
     */
    private void maakKamers()
    {
        //Bagger functie, kunnen we die data niet uit een db halen ... ? todolijst +1
        String[] tileImagesNames1 = { "blok"};
        ArrayList<Wezen> wezensKamer1 = new ArrayList<Wezen>();
        final ArrayList<KamerObject> objectenKamer1 = new ArrayList<KamerObject>();

        objectenKamer1.add(new Knop(100,100, speler));
        objectenKamer1.get(0).addListener(new KamerObjectListener() {
                @Override
                public void handelEventAf(int event_id, KamerObject object) {
            for(KamerObject kamerObject : objectenKamer1)
            {
                if(kamerObject instanceof Blok)
                {
                    if(((Blok)kamerObject).getBlokId() == 1)
                    deleteGameObject(kamerObject);
                }
            }
            }
            }
        );

        //Doorgang blokken
        objectenKamer1.add(new Blok(20, 0, 1));
        objectenKamer1.add(new Blok(40, 0, 1));
        objectenKamer1.add(new Blok(60, 0, 1));

        //Andere blokken
        objectenKamer1.add(new Blok(100, 100));
        objectenKamer1.add(new Blok(300, 100));
        objectenKamer1.add(new Blok(100, 300));
        objectenKamer1.add(new Blok(300, 300));
        wezensKamer1.add(new Spook(speler));

        int[][] kamerMap1 = {
                { 0, -1, -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0 },
                { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
        };
        kamerLijst.add(new Kamer(new GameTiles(tileImagesNames1, kamerMap1,  20), wezensKamer1, objectenKamer1));
    }


	@Override
	public void update() {
		super.update();

        //Check of de speler nog leeft en of de monsters nog leven (oftewel meer als 0 hp hebben)
	}
}