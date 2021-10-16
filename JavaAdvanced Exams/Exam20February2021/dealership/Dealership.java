package Exam20February2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getModel().equals(model) && car.getManufacturer().equals(manufacturer)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        for (Car car : this.data) {
            if (latestCar == null || car.getYear() > latestCar.getYear()) {
                latestCar = car;
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model){
        Car currentCar = null;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                currentCar = car;
            }
        }
        return currentCar;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car Exam20February2021.dealership %s:%n", this.name));
        for (Car car : this.data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

