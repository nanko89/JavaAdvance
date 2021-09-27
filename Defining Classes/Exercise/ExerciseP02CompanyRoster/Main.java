package ExerciseP02CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee employee;
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 6) {
                employee = new Employee(name,salary,position, department, input[4], Integer.parseInt(input[5]));
            } else if (input.length == 4) {
                employee = new Employee(name,salary,position, department);
            } else {
                String lastElement = input[4];
                if (lastElement.contains("@")){
                    employee = new Employee(name,salary,position, department, lastElement);
                }else {
                    employee = new Employee(name,salary,position, department, Integer.parseInt(lastElement));
                }
            }
            departments.putIfAbsent(department,new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department maxAverageSalary =departments.entrySet()
                .stream().max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalary.getName());
        maxAverageSalary.getEmployees()
                .stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));

    }
}
