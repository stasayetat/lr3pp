package com.yarets.droidbattle.TypesOfArena;
import com.yarets.droidbattle.TypesofDroids.*;

import java.util.Random;
/*
*Клас для звичайної битви 1 на 1
 */
public class Arena {
    /*
    *Поля для ініціалізації дроїдів для битви
     */
    protected DefaultDroid fDroid;
    protected DefaultDroid sDroid;
    protected DefaultDroid attacker;
    protected DefaultDroid defender;
    private DefaultDroid tmp;

/*
*Конструктор в якому ініціалізуємо 2 заданих дроїда
 */
    public Arena() {

   }
/*
*Метод в якому запускаємо битву та в подальшому виводимо переможця
 */
   public void allData(DefaultDroid[] dTeam) {
       this.fDroid = dTeam[0];
       this.sDroid = dTeam[1];
       DefaultDroid winDroid = stBattle();
       System.out.println("Переможець бою між " + attacker.getName() + " VS " + defender.getName() + "\n\n\n" + winDroid.getName() + ", Вітаємо його!");

   }

   /*
   *Метод битви спочатку рандомно визначаємо першого атакуючого, далі виводимо послідовно коден раунд, поки 1 робот не знищеться, повертаємо переможця
    */
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
        int curRound = 0;
        do {
            curRound++;
            System.out.println("-------------------------------------");
            System.out.println("Раунд - " + curRound);
            System.out.println("Атакує - " + attacker.getName());
            System.out.println("Захищається - " + defender.getName());
            /*
            *Виклик головної фази битви
             */
            doFight();
            System.out.println("У дроїда " + defender.getName() + " залишилось " + defender.getHealth() + " HP");
            System.out.println("У дроїда " + attacker.getName() + " залишилось " + attacker.getHealth() + " HP");
            swapFighter(attacker, defender);
        } while (attacker.isAlive());
        return defender;
    }
/*
*Метод в якому перевіряємо чи є атакуючий дроїд певним класом, якщо так то робимо певні рядки, якщо ні то просто атакуємо
 */
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
/*
*Метод в якому атакуючий дроїд наносить урон іншому дроїду і виводить цю інформацію
 */
    public void printInfo() {
        int aDamage = defender.attackDroid(attacker.getDamage());
        System.out.println("Дроїд " + attacker.getName() + " наніс дроїду " + defender.getName() + " урону: " + aDamage);
    }
/*
*Кожен хід міняємо атакуючого дроїда з іншим
 */
    private void swapFighter(DefaultDroid attacker, DefaultDroid defender) {
        tmp = this.attacker;
        this.attacker = this.defender;
        this.defender = tmp;
    }
}
