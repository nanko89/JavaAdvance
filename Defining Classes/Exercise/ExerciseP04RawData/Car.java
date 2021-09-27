package ExerciseP04RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tires[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Tires[] getTiers() {
        return this.tiers;
    }

    public String getModel() {
        return this.model;
    }

    public boolean lessPressureThanOne(){
        for (Tires tier : tiers) {
            if (tier.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
