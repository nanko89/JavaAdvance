package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car result = null;
        for (Car car : this.data) {
            if (result == null || result.getYear() < car.getYear()) {
                result = car;
            }
        }
        return result;
    }

    public Car getCar(String manufacturer, String model){
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n",this.type));
        for (Car car : this.data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
