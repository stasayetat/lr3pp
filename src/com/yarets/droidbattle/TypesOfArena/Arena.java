package com.yarets.droidbattle.TypesOfArena;
import com.yarets.droidbattle.TypesofDroids.*;

import java.util.Random;
public class Arena {
    private final DefaultDroid fDroid;
    private final DefaultDroid sDroid;
    protected DefaultDroid attacker;
    protected DefaultDroid defender;
    private DefaultDroid tmp;

    private int curRound = 0;

    public Arena(DefaultDroid fDroid, DefaultDroid sDroid) {
        this.fDroid = fDroid;
        this.sDroid = sDroid;
   }

   public void allData() {
       DefaultDroid winDroid = stBattle();
       System.out.println("Переможець бою між " + attacker.getName() + " VS " + defender.getName() + "\n\n\n" + winDroid.getName() + ", Вітаємо його!");

   }
    public DefaultDroid stBattle() {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            attacker = fDroid;
            defender = sDroid;
        }
        else {
            attacker = sDroid;
            defender = fDroid;
        }
        do {
            curRound++;
            System.out.println("-------------------------------------");
            System.out.println("Раунд - " + curRound);
            System.out.println("Атакує - " + attacker.getName());
            System.out.println("Захищається - " + defender.getName());
            doFight();
            System.out.println("У дроїда " + defender.getName() + " залишилось " + defender.getHealth() + " HP");
            System.out.println("У дроїда " + attacker.getName() + " залишилось " + attacker.getHealth() + " HP");
            swapFighter(attacker, defender);
        } while (attacker.isAlive());
        return defender;
    }

    private void doFight() {
        if(attacker instanceof DoctorDroid) {
            int healed = ((DoctorDroid) attacker).healDroid(attacker);
            System.out.println("Дроїд " + attacker.getName() + " вилікував себе на " + healed + "HP");
            printInfo();
        }
        else if (attacker instanceof  AttackTwiceDroid) {
            printInfo();
            printInfo();
        }
        else if(attacker instanceof  DoubleAttack) {
            printInfo();
            int doubled = attacker.getDamage() * 2;
            attacker.setDamage(doubled);
            System.out.println("У дроїда " + attacker.getName() + " збільшено атаку удвічу, тепер вона - " + attacker.getDamage());
        }
        else
            printInfo();
    }

    public void printInfo() {
        int aDamage = defender.attackDroid(attacker.getDamage());
        System.out.println("Дроїд " + attacker.getName() + " наніс дроїду " + defender.getName() + " урону: " + aDamage);
    }

    private void swapFighter(DefaultDroid attacker, DefaultDroid defender) {
        tmp = this.attacker;
        this.attacker = this.defender;
        this.defender = tmp;
    }
}
