package com.yarets.droidbattle.TypesofDroids;

public class TwoLivesDroid extends DefaultDroid{
    private String name;

    private int damage = 11;
    private int health = 5;
    private int doubleLive = 1;
    public TwoLivesDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }

    public int attackDroid(int damageDroid) {
        this.health -= damageDroid;
        if(this.health <= 0  && doubleLive == 1) {
            setHealth(1);
            this.health = 1;
            this.doubleLive--;
            System.out.println("Дроїд воскресає з 1 здоров'я");
        }
        setHealth(this.health);
        return damageDroid;
    }

}
