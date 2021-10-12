package PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();
        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    if (tokens[1].equals("Pet")) {
                        String petName = tokens[2];
                        Pet pet = new Pet(petName, Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(petName, pet);
                    } else {

                        try {
                            String clinicName = tokens[2];
                            Clinic clinic = new Clinic(clinicName, Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(clinicName, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    System.out.println(clinics.get(tokens[1]).release());
                    break;
                case "Print":
                    String clinicNames = tokens[1];
                    Clinic clinic1 = clinics.get(clinicNames);
                    if (tokens.length == 2) {
                        for (Pet clinic1Pet : clinic1.getPets()) {
                            if (clinic1Pet == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(clinic1Pet.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(tokens[2]);
                        clinic1.printClinicInfo(room);
                    }
                    break;
            }
        }

    }
}
