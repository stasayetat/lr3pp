package com.yarets.droidbattle.TypesofDroids;

public class DoctorDroid extends DefaultDroid{
    private final String name;
    private final int damage = 3;
    private final int health = 15;
    private final int healD = 5;
    private DefaultDroid patient;

    public DoctorDroid(String name) {
        super(name);
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }

    public int healDroid(DefaultDroid patient) {
        this.patient = patient;
        this.patient.setHealth(this.patient.getHealth()+healD);
        return healD;
    }
}
