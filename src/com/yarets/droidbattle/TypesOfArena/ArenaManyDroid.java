package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.TypesofDroids.AttackTwiceDroid;
import com.yarets.droidbattle.TypesofDroids.DefaultDroid;
import com.yarets.droidbattle.TypesofDroids.DoctorDroid;
import com.yarets.droidbattle.TypesofDroids.DoubleAttack;

import java.util.Random;
import java.util.Scanner;
/*
*Окремий клас Арени для битви команд на команду
 */
public class ArenaManyDroid {
    private DefaultDroid[] dTeam;
    protected DefaultDroid[] attacker;
    protected DefaultDroid[] defender;
    private DefaultDroid[] tmp;
    private int curRound = 0;

    public ArenaManyDroid(DefaultDroid[] dTeam) {
        this.dTeam = dTeam;
    }
    /*
    Метод в якому ми запускаємо битву і потім викликаємо метод про її закінчення
     */
    public void allData() {
        DefaultDroid[] winDroid = stBattle();
        endBattle(winDroid);
    }
/*
*Метод в якому ми оголошуємо переможців і закінчуємо програму
 */
    public void endBattle(DefaultDroid[] winDroid) {
        System.out.println("Команда переможців: ");
        infoTeam(winDroid);
        System.exit(0);
    }
    /*
    *Метод самої битви, де ми створюємо 2 команди, вибираємо, яка 1 буде атакувати, і викликаємо атаку поки команда противників жива
     */
    public DefaultDroid[] stBattle() {
        int lenTeam = dTeam.length;
        DefaultDroid[] fTeam = new DefaultDroid[lenTeam / 2];
        DefaultDroid[] sTeam = new DefaultDroid[lenTeam / 2];
        System.arraycopy(dTeam, 0, fTeam, 0, lenTeam/2);
        System.arraycopy(dTeam, lenTeam/2, sTeam, 0, lenTeam/2);
        System.out.println("Команда А: ");
        infoTeam(fTeam);
        System.out.println("\nКоманда B: ");
        infoTeam(sTeam);
        Random rand = new Random();
        if(rand.nextBoolean()) {
            attacker = fTeam;
            defender = sTeam;
        }
        else {
            attacker = sTeam;
            defender = fTeam;
        }
        tmp = new DefaultDroid[attacker.length];
        int curAttack = 0;
        do {
            curRound++;
            if(curRound % 2 != 0 && curRound >= 3)
                curAttack++;
            if(curAttack >= attacker.length)
                curAttack = 0;
            while(attacker[curAttack].getHealth() == 0)
            {
                curAttack++;
                if(curAttack >= attacker.length)
                    curAttack = 0;
            }
            System.out.println("-------------------------------------");
            System.out.println("Раунд - " + curRound);
            doTeamBattle(curAttack);
            infoTeam(defender);
            swapTeams(attacker, defender);
        }while(checkTeamsAlive(attacker));
        return defender;
    }
/*
*Метод в якому ми виводимо інформацію про певну команду, чи знищений дроїд чи ні
 */
    public void infoTeam(DefaultDroid[] tmpTeam) {
        for(int i = 0; i < tmpTeam.length; ++i) {
            if(!tmpTeam[i].isAlive()) {
                System.out.println("Дроїд: " + tmpTeam[i].getName() + " знищено");
                tmpTeam[i].setHealth(0);
                continue;
            }


            System.out.println(i + ".Дроїд: " + tmpTeam[i].getName() + " Здоров'я: " + tmpTeam[i].getHealth() + " Урон: " + tmpTeam[i].getDamage());
        }
    }
/*
*Метод в якому перевіряємо чи є атакуючий дроїд певним класом, та атакуємо супротивника
 */
    private void doTeamBattle(int curAttack) {
        Scanner sc = new Scanner(System.in);
        if(attacker[curAttack] instanceof DoctorDroid) {
            infoTeam(attacker);
            System.out.println("Виберіть кого полікувати: ");
            int healPatient = sc.nextInt();
            int healed = ((DoctorDroid) attacker[curAttack]).healDroid(attacker[healPatient]);
            System.out.println("Дроїд " + attacker[curAttack].getName() + " вилікував " + attacker[healPatient].getName() + " на " + healed + " HP");
            printInfo(curAttack);
        }
        else if (attacker[curAttack] instanceof AttackTwiceDroid) {
            printInfo(curAttack);
            printInfo(curAttack);
        }
        else if(attacker[curAttack] instanceof DoubleAttack) {
            printInfo(curAttack);
            int doubled = attacker[curAttack].getDamage() * 2;
            attacker[curAttack].setDamage(doubled);
            System.out.println("У дроїда " + attacker[curAttack].getName() + " збільшено атаку удвічу, тепер вона - " + attacker[curAttack].getDamage());
        }
        else
            printInfo(curAttack);
    }
/*
*Метод для випадкового вибору противника та удару його
 */
    private void printInfo(int curAttack) {
        Random rand = new Random();
        int curDef;
        do {
            curDef = rand.nextInt(defender.length);
        }while (!defender[curDef].isAlive());
        int aDamage = defender[curDef].attackDroid(attacker[curAttack].getDamage());
        System.out.println("Дроїд " + attacker[curAttack].getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);
        if(!checkTeamsAlive(defender))
            endBattle(attacker);
    }

    /*
    *Кожного ходу ми змінюємо команду атакуючих дроїдів на інші
     */
    private void swapTeams(DefaultDroid[] attacker, DefaultDroid[] defender) {
        System.arraycopy(this.attacker, 0, tmp, 0, this.attacker.length);
        System.arraycopy(this.defender, 0, this.attacker, 0, this.attacker.length);
        System.arraycopy(tmp, 0, this.defender, 0, this.attacker.length);
    }
/*
*Перевірка чи певна команда жива
 */
    private boolean checkTeamsAlive(DefaultDroid[] chTeam) {
        for(int j = 0; j < chTeam.length; ++j) {
            if(chTeam[j].getHealth() > 0)
                return true;
        }
        return false;
    }
}

