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

    public int attackDroid(int damageDroid) {
        this.health -= damageDroid;
        return damageDroid;
    }

}
