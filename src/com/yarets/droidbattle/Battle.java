package com.yarets.droidbattle;

import com.yarets.droidbattle.TypesofDroids.*;
import com.yarets.droidbattle.TypesOfArena.*;
import java.util.Scanner;

public class Battle {
    private TwoLivesDroid tDroid = new TwoLivesDroid("tD");
    private DoctorDroid dDroid = new DoctorDroid("dD");
    private DoubleAttack daDroid = new DoubleAttack("daD");
    private DoubleProtectionDroid dpDroid = new DoubleProtectionDroid("dpD");
    private AttackTwiceDroid aDroid = new AttackTwiceDroid("aD");
    private DefaultDroid[] twoDroid = new DefaultDroid[2];
    private Arena battleArena;
    public Battle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть тип бою 1vs1(1) чи команда на команду(2): ");
        int chooseBattle;
        int numPlayerTeam;
        int chooseTeamBattle = 0;
        int chDroid;
        String nameDroid = null;
        chooseBattle = sc.nextInt();
        if(chooseBattle == 2) {
            System.out.println("Виберіть кількість гравців у кожній команді: ");
            chooseTeamBattle = sc.nextInt();
        }
        if(chooseBattle == 1)
            numPlayerTeam = 2;
        else
            numPlayerTeam = chooseTeamBattle * 2;
        for(int i = 0; i < numPlayerTeam; ++i)
        {
            System.out.println("Виберіть дроїда від 1 до 5, 0 - інформація про дроїдів");
            chDroid = sc.nextInt();
            if(chDroid != 0) {
                System.out.println("Виберіть ім'я для дроїда");
                sc.nextLine();
                nameDroid = sc.nextLine();
            }

            switch (chDroid) {
                case 0:
                    infoAboutDroid();
                    --i;
                    break;
                case 1:
                    twoDroid[i] = new DoctorDroid(nameDroid);
                    break;
                case 2:
                    twoDroid[i] = new DoubleAttack(nameDroid);
                    break;
                case 3:
                    twoDroid[i] = new DoubleProtectionDroid(nameDroid);
                    break;
                case 4:
                    twoDroid[i] = new TwoLivesDroid(nameDroid);
                    break;
                case 5:
                    twoDroid[i] = new AttackTwiceDroid(nameDroid);
                    break;
                default:
                    break;
            }

        }

        typeOfArena();
    }


    public void infoAboutDroid() {
        System.out.println("1. Дроїд - DoctorDroid(може лікувати себе або союзників), його атака " + dDroid.getDamage() + ", його здоров'я " + dDroid.getHealth());
        System.out.println("2. Дроїд - DoubleAttack(після атаки збільшує свою урон удвічі), його атака " + daDroid.getDamage() + ", його здоров'я " + daDroid.getHealth());
        System.out.println("3. Дроїд - DoubleProtection(перша атака йому не наносить урону), його атака " + dpDroid.getDamage() + ", його здоров'я " + dpDroid.getHealth());
        System.out.println("4. Дроїд - TwoLivesDroid(після того як здоров'я менше 0, воно стає 1), його атака " + tDroid.getDamage() + ", його здоров'я " + tDroid.getHealth());
        System.out.println("5. Дроїд - AttackTwiceDroid(атакує двічі за хід), його атака " + aDroid.getDamage() + ", його здоров'я " + aDroid.getHealth());
    }

    public void typeOfArena() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть арену для битви(1-3, 0 - інформація про арени): ");
        int chArena;
        chArena = sc.nextInt();
        if(chArena == 0) {
            infoArena();
            System.out.println("Виберіть арену: ");
            chArena = sc.nextInt();
        }
            infoArena();
        switch (chArena) {
            case 1:
                battleArena = new Arena(twoDroid[0], twoDroid[1]);
                battleArena.allData();
                break;
            case 2:
                battleArena = new SwitchArena(twoDroid[0], twoDroid[1]);
                battleArena.allData();
                break;
            case 3:
                battleArena = new FiftyPercentArena(twoDroid[0], twoDroid[1]);
                battleArena.allData();
                break;
        }
        Arena arena1 = new Arena(twoDroid[0], twoDroid[1]);
    }

    public void infoArena() {
        System.out.println("1. Звичайна арена 1 vs 1");
        System.out.println("2. Арена, на якій здоров'я міняється з уроном");
        System.out.println("3. Арена, на якій при кожному ударі шанс 50% на промах");
    }
}
