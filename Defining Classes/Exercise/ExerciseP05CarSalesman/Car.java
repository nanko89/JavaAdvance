package ExerciseP05CarSalesman;

public class Car {

    private String model;
    private String engine;
    private int weight;
    private String color;

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.color = "n/a";
        this.weight = 0;
    }

    public Car(String model, String engine, int weight, String color){
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, String engine, int weight){
        this(model, engine);
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, String engine, String color){
        this(model, engine);
        this.color = color;
        this.weight = 0;
    }

    public String getModel() {
        return this.model;
    }

    public String getEngine() {
        return this.engine;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

}
