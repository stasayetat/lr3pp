package com.yarets.droidbattle.TypesofDroids;
/*
*Підклас DefaultDroid, після смерті відроджується з 1 HP
 */
public class TwoLivesDroid extends DefaultDroid{
    private final String name;

    private final int damage = 11;
    private int health = 5;
    private int doubleLive = 1;
    public TwoLivesDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }
/*
*Метод в якому реалізується властивість цього дроїда
 */
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
