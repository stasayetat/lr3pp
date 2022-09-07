package com.yarets.droidbattle.TypesofDroids;
/*
*Клас для початкового класу дроїда, всі інші похідні від нього
 */
public class DefaultDroid {
    /*
    *Поля для задання імені, урону та здоров'я дроїда
     */
    private final String name;
    private int damage;
    private int health;
    /*
    *Конструктор в якому ініціалізуємо ім'я дроїда
     */
    public DefaultDroid(String name) {
        this.name = name;
    }
    /*
    *Гетери та сетери
     */
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
/*
*Метод для зняття здоров'я дроїда на задану кількість урона
 */
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
/*
*Перевірка дроїда на життя
 */
    public boolean isAlive() {
        return health > 0;
    }
/*
*Метод для друкук всіє потрібної інформації про дроїда
 */
    public String toString() {
        return "У дроїда: " + this.name + " залишилось " + this.health + " здоров'я та " + this.damage + " урону";
    }


}

