package com.android.cssking;

import android.gameengine.icadroids.tiles.GameTiles;

import java.util.ArrayList;

/**
 * Created by Robert on 16-3-2015.
 * De kamer heeft een tilemap, en twee arraylisten met wezens en met objecten
 * Een kamer word aan het begin van de game geinitaliseerd.
 * De bedoeling van een kamer is dat deze ingeladen kan worden wanneer dat nodig is, de staat van de kamers kan ook worden gewijzigd.
 * Stel dat de speler een object kapot maakt en dit object mag niet meer terug komen dan dient hier een object van de arrayList objecten worden te verwijderd
 * Als dit niet word gedaan kan de speler de kamer verlaten en weer terug de kamer in gaan en dan is alles weer in oude staat !!!
 */
public class Kamer {
    GameTiles tiles;
    ArrayList<Wezen> wezenLijst = new ArrayList<Wezen>();
    ArrayList<KamerObject> objectenLijst = new ArrayList<KamerObject>();

    public Kamer (GameTiles tiles, ArrayList wezens, ArrayList objecten)
    {
        this.tiles = tiles;
        this.wezenLijst = wezens;
        this.objectenLijst = objecten;
    }
}
