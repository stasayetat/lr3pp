package com.yarets.droidbattle.TypesofDroids;

public class Droid {
    private final String name;
    private int damage;
    private int health;

    public Droid(int damage, int health, String name) {
        this.name = name;
        this.health = health;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void attackDroid(int damage) {
        this.health -= damage;
    }

    @Override
    public String toString() {
        return "У дроїда: " + name + " залишилось " + health + "здоров'я";
    }
}
