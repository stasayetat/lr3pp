package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.TypesofDroids.DefaultDroid;

public class SwitchArena extends Arena{
    public SwitchArena(DefaultDroid fDroid, DefaultDroid sDroid) {
        super(fDroid, sDroid);
        swapStats(fDroid);
        swapStats(sDroid);
        System.out.println(fDroid);
        sDroid.toString();
    }
    public void swapStats(DefaultDroid tmpDroid) {
        int tmpData;
        tmpData = tmpDroid.getDamage();
        tmpDroid.setDamage(tmpDroid.getHealth());
        tmpDroid.setHealth(tmpData);
    }
}
