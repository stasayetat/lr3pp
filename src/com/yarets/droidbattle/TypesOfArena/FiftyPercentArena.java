package com.yarets.droidbattle.TypesOfArena;

import java.util.Random;

/*
*Підклас Arena, в якому кожна атака має 50% на промах
 */
public class FiftyPercentArena extends Arena{


    public FiftyPercentArena() {
        super();
    }


/*
*Метод в якому при кожній атаці є шанс на промах 50%
 */
    @Override
    public void doFight() {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            attacker[0].printInfo(attacker, defender, 0);
        }
        else {
            System.out.println("Дроїд " + attacker[0].getName() + " промахнувся");
        }
    }
}
