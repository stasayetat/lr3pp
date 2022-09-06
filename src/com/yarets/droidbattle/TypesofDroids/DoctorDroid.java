package com.yarets.droidbattle.TypesofDroids;

public class DoctorDroid extends DefaultDroid{
    private String name;
    private int damage = 2;
    private int health = 15;
    private int healD = 5;
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
