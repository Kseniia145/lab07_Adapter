import adapter.VehicleCalculatorAdapter;
import customs.Auto;
import customs.Customs;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto(5, "Audi", true, 100_000);
        Customs customs = new VehicleCalculatorAdapter();

        System.out.println("Вартість авто в грн: " + customs.vehiclePrice(auto));
        System.out.println("Мито: " + customs.tax(auto));
    }
}
