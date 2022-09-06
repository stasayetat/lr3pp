package com.yarets.droidbattle.TypesofDroids;

public class DoubleProtectionDroid extends DefaultDroid{
    private String name;
    private int damage = 9;
    private int health = 8;
    private int doubleProtection = 1;

    public DoubleProtectionDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }
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
