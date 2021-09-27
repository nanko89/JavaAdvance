package ExerciseP05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine>engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Engine engine;
            //"<Model> <Power> <Displacement> <Efficiency>
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (input.length == 2) {
                engine = new Engine(model, power);
            } else {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = input[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            Car car;
            String[] input = scanner.nextLine().split("\\s+");
            //"<Model> <Engine> <Weight> <Color>",
            String model = input[0];
            String engine = input[1];
            if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, engine, weight, color);
            } else if (input.length == 2) {
                car = new Car(model, engine);
            } else {
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = input[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engines.forEach(engine -> {
               if (engine.getModel().equals(car.getEngine())){
                   System.out.print(engine.toString());
               }
            });
            if (car.getWeight() == 0){
                System.out.println("Weight: n/a");
            }else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}

