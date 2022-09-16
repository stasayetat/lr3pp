package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.TypesofDroids.DefaultDroid;

import java.io.FileNotFoundException;

/*
*Арена, під клас звичайної Arena, в ній в кожного дроїда здоров'я міняється з атакою
 */
public class SwitchArena extends Arena{
    public SwitchArena() {
    }

    @Override
    public void allData(DefaultDroid[] dTeam) throws FileNotFoundException {
        swapStats(dTeam[0]);
        swapStats(dTeam[1]);
        DefaultDroid[] winDroid = stBattle(dTeam);
        System.out.println("Переможець бою між " + attacker[0].getName() + " VS " + defender[0].getName() + "\n\n\n" + winDroid[0].getName() + ", Вітаємо його!");

    }
    /*
    *Метод в якому ми міняємо статистику дроїдів
     */
    public void swapStats(DefaultDroid tmpDroid) {
        int tmpData;
        tmpData = tmpDroid.getDamage();
        tmpDroid.setDamage(tmpDroid.getHealth());
        tmpDroid.setHealth(tmpData);
        System.out.println(tmpDroid);
    }
}
