package ExerciseP04RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
//"<CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age>
// <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed,enginePower);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Tires[] tires = new Tires[4];
            int count = 0;
            for (int j = 5; j < input.length - 1; j+=2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j+1]);
                Tires tire = new Tires(tirePressure, tireAge);
                tires[count] = tire;
                count++;
            }
            Car car = new Car(model,engine,cargo,tires);
            cars.putIfAbsent(model, car);
        }
        String command = scanner.nextLine();
        for (Car car : cars.values()) {
        if (command.equals("fragile")
                && car.getCargo().getType().equals("fragile")
                && car.lessPressureThanOne()){
            System.out.println(car.toString());
        }else if (command.equals("flamable")
                && car.getCargo().getType().equals("flamable")
                && car.getEngine().getPower() > 250){
            System.out.println(car.toString());
        }
        }
    }
}
