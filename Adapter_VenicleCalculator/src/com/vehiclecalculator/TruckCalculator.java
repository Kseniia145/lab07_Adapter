package com.vehiclecalculator;

public class TruckCalculator implements VehicleCalculator {
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
        // Truck має вищу базову ціну і повільніше знецінення
        float basePrice = 40000f;
        float price = basePrice
                - vehicle.getAge() * 1500
                - vehicle.getMileage() * 0.03f
                - vehicle.getDamage() * 15000;

        return String.format("%.2f", Math.max(price, 0));
    }
}
