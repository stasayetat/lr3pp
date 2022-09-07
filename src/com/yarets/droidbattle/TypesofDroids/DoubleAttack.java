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

}

