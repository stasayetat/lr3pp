package com.yarets.droidbattle.TypesofDroids;

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

