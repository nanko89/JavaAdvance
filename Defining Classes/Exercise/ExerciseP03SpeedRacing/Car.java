package ExerciseP03SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double fuelCostPerKilometer;
    private int distance;

    public Car(String model, double fuel, double fuelCostPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distance = 0;
    }

    public boolean drive(int distance) {
        double needFuel = distance * fuelCostPerKilometer;
        if (needFuel <= this.fuel) {
            this.distance += distance;
            this.fuel -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
