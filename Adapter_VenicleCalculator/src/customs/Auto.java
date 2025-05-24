package customs;

public class Auto {
    private int age;
    private String model;
    private boolean damaged;
    private int mileage;

    public Auto(int age, String model, boolean damaged, int mileage) {
        this.age = age;
        this.model = model;
        this.damaged = damaged;
        this.mileage = mileage;
    }

    public int getAge() { return age; }
    public String getModel() { return model; }
    public boolean isDamaged() { return damaged; }
    public int getMileage() { return mileage; }
}
