package com.yarets.droidbattle.TypesofDroids;
/*
*Клас для початкового класу дроїда, всі інші похідні від нього
 */
public abstract class DefaultDroid implements Cloneable{
    /*
    *Поля для задання імені, урону та здоров'я дроїда
     */
    private String name;
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

    public void setName(String name) {
        this.name = name;
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

    public void printInfo(DefaultDroid[] attacker, DefaultDroid[] defender, int curDef) {
        int aDamage = defender[curDef].attackDroid(this.getDamage());
        System.out.println("Дроїд " + this.getName() + " наніс дроїду " + defender[curDef].getName() + " урону: " + aDamage);
    }

    @Override
    public DefaultDroid clone() throws CloneNotSupportedException {
        return (DefaultDroid)super.clone();
    }

}

