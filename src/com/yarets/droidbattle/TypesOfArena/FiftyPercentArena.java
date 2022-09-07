package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.TypesofDroids.DefaultDroid;
import java.util.Random;
/*
*Підклас Arena, в якому кожна атака має 50% на промах
 */
public class FiftyPercentArena extends Arena{
    public FiftyPercentArena(DefaultDroid fDroid, DefaultDroid sDroid) {
        super(fDroid, sDroid);

    }
/*
*Метод в якому при кожній атаці є шанс на промах 50%
 */
    @Override
    public void printInfo() {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            int aDamage = defender.attackDroid(attacker.getDamage());
            System.out.println("Дроїд " + attacker.getName() + " наніс дроїду " + defender.getName() + " урону: " + aDamage);
        }
        else {
            System.out.println("Дроїд " + attacker.getName() + " промахнувся");
        }
 }
}
