package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.DualStream;
import com.yarets.droidbattle.TypesofDroids.DefaultDroid;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
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
    public void allData() throws FileNotFoundException {
        DefaultDroid[] winDroid = stBattle();
        endBattle(winDroid);
        return;
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
    public DefaultDroid[] stBattle() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("C:\\Tests\\test_java\\out.txt"));
        PrintStream dual = new DualStream(System.out, out);
        System.setOut(dual);

        PrintStream err = new PrintStream(new FileOutputStream("C:\\Tests\\test_java\\err.txt"));
        dual= new DualStream(System.err, err);
        System.setErr(dual);
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
        Random rand = new Random();
        int curDef;
        do {
            curDef = rand.nextInt(defender.length);
        }while (!defender[curDef].isAlive());
        attacker[curAttack].printInfo(attacker, defender, curDef);
    }
/*
*Метод для випадкового вибору противника та удару його
 */

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

