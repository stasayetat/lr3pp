package com.yarets.droidbattle.TypesofDroids;

import java.util.Scanner;

/*
*Підклас DefaultDroid, лікує заданого дроїда на задану кількість HP
 */
public class DoctorDroid extends DefaultDroid{
    private final String name;
    private final int damage = 3;
    private final int health = 15;
    private final int healD = 5;
    private DefaultDroid patient;

    public DoctorDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }
/*
*Метод в якому дроїд лікує іншого на задану кількість HP
 */
    public int healDroid(DefaultDroid patient) {
        this.patient = patient;
        this.patient.setHealth(this.patient.getHealth()+healD);
        return healD;
    }

    @Override
    public void printInfo(DefaultDroid[] attacker, DefaultDroid[] defender, int curDef) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < attacker.length; i++)
        {
            if(!attacker[i].isAlive()) {
                System.out.println(attacker[i].getName() + " знищено!");
                continue;
            }

            System.out.println(attacker[i]);
        }
        System.out.println("Виберіть кого полікувати: (Перший дроїд - 0, другий - 1 і так далі)");
        int healPatient = sc.nextInt();
        int healed = ((DoctorDroid) this).healDroid(attacker[healPatient]);
        System.out.println("Дроїд " + this.getName() + " вилікував " + attacker[healPatient].getName() + " на 5 HP");
        int aDamage = defender[curDef].attackDroid(this.getDamage());
        System.out.println("Дроїд " + this.getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);
    }

}
