package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.TypesofDroids.DefaultDroid;
/*
*Арена, під клас звичайної Arena, в ній в кожного дроїда здоров'я міняється з атакою
 */
public class SwitchArena extends Arena{
    public SwitchArena() {
    }

    @Override
    public void allData(DefaultDroid[] dTeam) {
        this.fDroid = dTeam[0];
        this.sDroid = dTeam[1];
        swapStats(fDroid);
        swapStats(sDroid);
        DefaultDroid winDroid = stBattle();
        System.out.println("Переможець бою між " + attacker.getName() + " VS " + defender.getName() + "\n\n\n" + winDroid.getName() + ", Вітаємо його!");

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
