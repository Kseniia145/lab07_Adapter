import com.mobile.Legacy.Charger;
import com.mobile.Legacy.MobilePhone;

public class Main {

    public static void main(String[] args) {
        Charger charger = new Charger(5.0f, 1.0f);

        System.out.println("\n============= MicroUsb ==============\n");
        MobilePhone phone = new MobilePhone();
        phone.charge(20);
        phone.pluginCharger(charger);
        phone.charge(20);
        phone.unplugCharger();
        System.out.printf("Current power status = %s%n", phone.getChargingPercent());

        System.out.println("\n============= Type-C ==============\n");
        FastCharge fastCharge = new FastCharge(18);
        SamsungS samsung = new SamsungS();
        samsung.makeCall();
        samsung.pluginCharger(fastCharge);
        samsung.charge(30);
        samsung.unplugCharger();
        printBatteryStatus(samsung);

        samsung.makeCall();
        printBatteryStatus(samsung);
        samsung.charge(10);
        samsung.unplugCharger();
        printBatteryStatus(samsung);

        // ================= Adapter MicroUsb → TypeC =================
        System.out.println("\nCharging with adapter (MicroUsb → Type-C)");
        TypeCCharger adapterMicroUsbToTypeC = new AdapterMicroUsbToTypeC(charger);
        samsung.pluginCharger(adapterMicroUsbToTypeC);
        samsung.charge(10);
        samsung.unplugCharger();
        printBatteryStatus(samsung);

        // ================= Adapter TypeC → MicroUsb =================
        System.out.println("\nCharging with adapter (Type-C → MicroUsb)");
        phone.pluginCharger(new AdapterTypeCToMicroUsb(fastCharge));
        phone.charge(20);
        System.out.printf("Current power status = %s%n", phone.getChargingPercent());
    }

    private static void printBatteryStatus(SamsungS phone) {
        System.out.printf("Current battery status = %s%n", phone.getChargingPercent());
    }
}
