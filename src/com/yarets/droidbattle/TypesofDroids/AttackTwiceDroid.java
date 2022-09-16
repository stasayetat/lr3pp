package com.yarets.droidbattle.TypesofDroids;
/*
*Підклас DefaultDroid, атакує 2 рази
 */
public class AttackTwiceDroid extends DefaultDroid{
    private String name;
    private int damage = 8;
    private int health = 12;

    public AttackTwiceDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }

    @Override
    public void printInfo(DefaultDroid[] attacker, DefaultDroid[] defender, int curDef) {
        int aDamage = defender[curDef].attackDroid(this.getDamage());
        System.out.println("Дроїд " + this.getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);
        if(!defender[curDef].isAlive())
            return;
        aDamage = defender[curDef].attackDroid(this.getDamage());
        System.out.println("Дроїд " + this.getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);

    }

}
