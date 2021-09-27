package ExerciseP05CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;


    public Engine(String model, int power,int displacement,String efficiency){
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;

    }
    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.efficiency = "n/a";
        this.displacement = 0;
    }

    public Engine(String model, int power, int displacement){
        this(model, power);
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency){
        this(model, power);
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Power: " + this.power + "\n");
        if (this.displacement == 0){
            stringBuilder.append("Displacement: n/a" + "\n");
        }else {
            stringBuilder.append("Displacement: " + this.displacement + "\n");
        }
        stringBuilder.append("Efficiency: " + this.efficiency + "\n");

        return stringBuilder.toString();
    }
}
