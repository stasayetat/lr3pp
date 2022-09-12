package com.yarets.droidbattle;

import com.yarets.droidbattle.TypesOfArena.Arena;
import com.yarets.droidbattle.TypesOfArena.ArenaManyDroid;
import com.yarets.droidbattle.TypesOfArena.FiftyPercentArena;
import com.yarets.droidbattle.TypesOfArena.SwitchArena;
import com.yarets.droidbattle.TypesofDroids.*;

import java.util.Scanner;

/*
*Клас в якому створюються дроїди та вибираємо арену для поєдинку
 */
public class Battle{
    /*
     *Поля створені для подання інформації про різних дроїдів
     */

    private final TwoLivesDroid tDroid = new TwoLivesDroid("tD");
    private final DoctorDroid dDroid = new DoctorDroid("dD");
    private final DoubleAttack daDroid = new DoubleAttack("daD");
    private final DoubleProtectionDroid dpDroid = new DoubleProtectionDroid("dpD");
    private final AttackTwiceDroid aDroid = new AttackTwiceDroid("aD");

    private Arena aArena = new Arena();
    private Arena fArena = new FiftyPercentArena();
    private Arena sArena = new SwitchArena();
    /*
    *Поле для масиву зі всіма дроїдами
     */
    private DefaultDroid[] twoDroid;

    private DefaultDroid[] typicalDroid = new DefaultDroid[5];
    private Arena[] typicalArena = new Arena[3];
    /*
    *Поле для ініціалізація арени для поєдинку
     */
    private Arena battleArena;
    /*
    *Конструктор в якому ми вибираємо тип поєдинку та створюємо дроїдів
     */
    public Battle() {
        this.typicalDroid[0] = dDroid;
        this.typicalDroid[1] = daDroid;
        this.typicalDroid[2] = dpDroid;
        this.typicalDroid[3] = tDroid;
        this.typicalDroid[4] = aDroid;

        this.typicalArena[0] = aArena;
        this.typicalArena[1] = sArena;
        this.typicalArena[2] = fArena;
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть тип бою 1vs1(1) чи команда на команду(2): ");
        int numPlayerTeam;
        int chooseTeamBattle = 0;
        int chooseBattle = sc.nextInt();
        if(chooseBattle == 2) {
            System.out.println("Виберіть кількість гравців у кожній команді(максимум 5): ");
            chooseTeamBattle = sc.nextInt();
        }
        if(chooseBattle == 1)
            numPlayerTeam = 2;

        else
            numPlayerTeam = chooseTeamBattle * 2;
        twoDroid = new DefaultDroid[numPlayerTeam];
        try {
            typeOfDroid(numPlayerTeam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        typeOfArena();
    }

/*
*Метод для друку інформації про різні класи дроїдів
 */
    public void infoAboutDroid() {
        System.out.println("0. Дроїд - DoctorDroid(може лікувати себе або союзників), його атака " + typicalDroid[0].getDamage() + ", його здоров'я " + typicalDroid[0].getHealth());
        System.out.println("1. Дроїд - DoubleAttack(після атаки збільшує свою урон удвічі), його атака " + typicalDroid[1].getDamage() + ", його здоров'я " + typicalDroid[1].getHealth());
        System.out.println("2. Дроїд - DoubleProtection(перша атака йому не наносить урону), його атака " + typicalDroid[2].getDamage() + ", його здоров'я " + typicalDroid[2].getHealth());
        System.out.println("3. Дроїд - TwoLivesDroid(після того як здоров'я менше 0, воно стає 1), його атака " + typicalDroid[3].getDamage() + ", його здоров'я " + typicalDroid[3].getHealth());
        System.out.println("4. Дроїд - AttackTwiceDroid(атакує двічі за хід), його атака " + typicalDroid[4].getDamage() + ", його здоров'я " + typicalDroid[4].getHealth());
    }

    public void typeOfDroid(int numPlayerTeam) throws Exception{
        Scanner sc = new Scanner(System.in);
        String nameDroid = null;
        for(int i = 0; i < numPlayerTeam; ++i)
        {
            System.out.println("Виберіть дроїда від 0 до 4, 99 - інформація про дроїдів");
            int chDroid = sc.nextInt();
            if(chDroid != 99) {
                System.out.println("Виберіть ім'я для дроїда");
                sc.nextLine();
                nameDroid = sc.nextLine();
            }

            if(chDroid == 99) {
                infoAboutDroid();
                --i;
                continue;
            }
            twoDroid[i] = typicalDroid[chDroid].clone();
            twoDroid[i].setName(nameDroid);
        }
    }


/*
*Метод для вибору арени
 */
    public void typeOfArena() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть арену для битви(0-3, 99 - інформація про арени): ");
        int chArena;
        chArena = sc.nextInt();
        if(chArena == 99) {
            infoArena();
            System.out.println("Виберіть арену: ");
            chArena = sc.nextInt();
        }
        if(chArena == 3) {
            ArenaManyDroid battleManyDroid = new ArenaManyDroid(twoDroid);
            battleManyDroid.allData();
        }

        battleArena = typicalArena[chArena];
        battleArena.allData(twoDroid);

    }
/*
*Метод для друку інформації про різні арени
 */
    public void infoArena() {
        System.out.println("0. Звичайна арена 1 vs 1");
        System.out.println("1. Арена, на якій здоров'я міняється з уроном");
        System.out.println("2. Арена, на якій при кожному ударі шанс 50% на промах");
        System.out.println("3. Арена, для бою багатьох дроїдів");
    }

}


