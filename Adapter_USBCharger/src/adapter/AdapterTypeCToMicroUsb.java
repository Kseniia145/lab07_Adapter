import com.mobile.Legacy.MicroUsbCharger;

public class AdapterTypeCToMicroUsb implements MicroUsbCharger {
    private final TypeCCharger typeCCharger;

    public AdapterTypeCToMicroUsb(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public float getOutputVoltage() {
        // Умовно подаємо 5V
        return 5.0f;
    }

    @Override
    public float getOutputAmperage() {
        // Потужність = V * I => I = P / V
        return typeCCharger.getOutputPower() / getOutputVoltage();
    }
}
