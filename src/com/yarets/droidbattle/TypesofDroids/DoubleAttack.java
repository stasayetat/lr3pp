package com.yarets.droidbattle.TypesofDroids;
/*
*Підклас DefaultDroid, після атаки його урон збільшується удвічі
 */
public class DoubleAttack extends DefaultDroid{
    private String name;
    private int damage = 3;
    private int health = 20;

    public DoubleAttack(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }

    @Override
    public void printInfo(DefaultDroid[] attacker, DefaultDroid[] defender, int curDef) {
        int aDamage = defender[curDef].attackDroid(this.getDamage());
        System.out.println("Дроїд " + this.getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);
        int doubled = this.getDamage() * 2;
        this.setDamage(doubled);
        System.out.println("У дроїда " + this.getName() + " збільшено атаку удвічу, тепер вона - " + this.getDamage());

    }

}

