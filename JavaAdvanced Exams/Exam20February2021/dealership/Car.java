package Exam20February2021.dealership;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year){
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString(){
        return this.manufacturer + " " + this.model + " (" + this.year + ")";
    }

    public int getYear(){
        return this.year;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
