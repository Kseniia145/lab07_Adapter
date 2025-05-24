package com.vehiclecalculator;

public class CarCalculator implements VehicleCalculator {
    private Vehicle vehicle;

    @Override
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String calculatePrice() {
        if (vehicle == null) {
            return "0";
        }
        // Простий розрахунок: базова ціна - вік*1000 - пробіг*0.05 - шкода*10000
        float basePrice = 20000f;
        float price = basePrice
                - vehicle.getAge() * 1000
                - vehicle.getMileage() * 0.05f
                - vehicle.getDamage() * 10000;

        return String.format("%.2f", Math.max(price, 0));
    }
}
