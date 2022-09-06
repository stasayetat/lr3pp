package com.yarets.droidbattle.TypesofDroids;

public class DefaultDroid {
    private final String name;
    private int damage;
    private int health;

    public DefaultDroid(String name) {
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

    public int attackDroid(int damageDroid) {
        this.health -= damageDroid;
        return damageDroid;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String toString() {
        return "У дроїда: " + this.name + " залишилось " + this.health + " здоров'я та " + this.damage + " урону";
    }


}

