package adapter;

import com.vehiclecalculator.Vehicle;
import com.vehiclecalculator.VehicleCalculator;
import com.vehiclecalculator.CarCalculator;
import customs.Auto;
import customs.Customs;

public class VehicleCalculatorAdapter implements Customs {
    private static final float USD_TO_UAH = 40f; // курс валют

    private VehicleCalculator calculator;

    public VehicleCalculatorAdapter() {
        // Припустимо, адаптер працює лише з легковими авто
        this.calculator = new CarCalculator();
    }

    @Override
    public float vehiclePrice(Auto auto) {
        Vehicle vehicle = convertToVehicle(auto);
        calculator.setVehicle(vehicle);
        float priceInUSD = Float.parseFloat(calculator.calculatePrice());
        return priceInUSD * USD_TO_UAH;
    }

    @Override
    public float tax(Auto auto) {
        float priceUAH = vehiclePrice(auto);
        return priceUAH * 0.3f; // умовний митний збір 30%
    }

    private Vehicle convertToVehicle(Auto auto) {
        return new Vehicle(
                auto.getAge(),
                auto.getModel(),
                auto.isDamaged() ? 0.5f : 0f, // якщо пошкоджено — коефіцієнт 0.5
                auto.getMileage()
        );
    }
}
