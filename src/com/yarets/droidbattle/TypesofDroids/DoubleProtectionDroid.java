package com.yarets.droidbattle.TypesofDroids;
/*
*Підклас DefaultDroid, перша атака по цьомі дроїду не наносить урону
 */
public class DoubleProtectionDroid extends DefaultDroid{
    private String name;
    private int damage = 10;
    private int health = 8;
    private int doubleProtection = 1;

    public DoubleProtectionDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }
    /*
    *Метод в якому перший урон по дроїду пропускається
     */
    public int attackDroid(int damageDroid) {
        if (this.doubleProtection == 0) {
            this.health -= damageDroid;
            setHealth(this.health);
        }
        else {
            this.doubleProtection--;
            System.out.println("Первинний захист знищено!");
            return 0;
        }

        return damageDroid;
    }
}
