package com.yarets.droidbattle.TypesOfArena;

import com.yarets.droidbattle.DualStream;
import com.yarets.droidbattle.TypesofDroids.DefaultDroid;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
    protected DefaultDroid[] attacker;
    protected DefaultDroid[] defender;
    private DefaultDroid[] tmp = new DefaultDroid[1];


/*
*Конструктор в якому ініціалізуємо 2 заданих дроїда
 */
    public Arena() {

   }
/*
*Метод в якому запускаємо битву та в подальшому виводимо переможця
 */
   public void allData(DefaultDroid[] dTeam) throws FileNotFoundException {
       DefaultDroid[] winDroid = stBattle(dTeam);
       System.out.println("Переможець бою між " + attacker[0].getName() + " VS " + defender[0].getName() + "\n\n\n" + winDroid[0].getName() + ", Вітаємо його!");
        return;
   }

   /*
   *Метод битви спочатку рандомно визначаємо першого атакуючого, далі виводимо послідовно коден раунд, поки 1 робот не знищеться, повертаємо переможця
    */
    public DefaultDroid[] stBattle(DefaultDroid[] dTeam) throws FileNotFoundException {
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
        int curRound = 0;
        do {
            curRound++;
            System.out.println("-------------------------------------");
            System.out.println("Раунд - " + curRound);
            System.out.println("Атакує - " + attacker[0].getName());
            System.out.println("Захищається - " + defender[0].getName());
            /*
            *Виклик головної фази битви
             */
            doFight();
            System.out.println("У дроїда " + defender[0].getName() + " залишилось " + defender[0].getHealth() + " HP");
            System.out.println("У дроїда " + attacker[0].getName() + " залишилось " + attacker[0].getHealth() + " HP");
            swapFighter(attacker, defender);
        } while (attacker[0].isAlive());
        return defender;
    }
/*
*Метод в якому перевіряємо чи є атакуючий дроїд певним класом, якщо так то робимо певні рядки, якщо ні то просто атакуємо
 */

/*
*Метод в якому атакуючий дроїд наносить урон іншому дроїду і виводить цю інформацію
 */
  public void doFight() {
      attacker[0].printInfo(attacker, defender, 0);
  }
/*
*Кожен хід міняємо атакуючого дроїда з іншим
 */
protected void swapFighter(DefaultDroid[] attacker, DefaultDroid[] defender) {
    System.arraycopy(attacker, 0, tmp, 0, attacker.length);
    System.arraycopy(defender, 0, attacker, 0, attacker.length);
    System.arraycopy(tmp, 0, defender, 0, attacker.length);
}

    public void infoTeam(DefaultDroid[] tmpTeam) {
    System.out.println("Дроїд: " + tmpTeam[0].getName() + " Здоров'я: " + tmpTeam[0].getHealth() + " Урон: " + tmpTeam[0].getDamage());
    }
}
