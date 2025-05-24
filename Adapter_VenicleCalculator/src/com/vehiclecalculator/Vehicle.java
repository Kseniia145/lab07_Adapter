package com.vehiclecalculator;

public class Vehicle {
    private String model;
    private int age;
    private float damaged;
    private int mileage;

    public Vehicle(int age, String model, float damaged, int mileage) {
        this.age = age;
        this.model = model;
        this.damaged = damaged;
        this.mileage = mileage;
    }

    public int getAge() {
        return age;
    }

    public String getModel() {
        return model;
    }

    public float getDamage() {
        return damaged;
    }

    public float getMileage() {
        return mileage;
    }
}
