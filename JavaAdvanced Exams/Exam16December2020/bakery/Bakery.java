package Exam16December2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee employeeOldest = null;
        for (Employee employee : employees) {
            if (employeeOldest == null || employee.getAge() > employeeOldest.getAge()){
                employeeOldest = employee;
            }
        }
        return employeeOldest;
    }

    public Employee getEmployee(String name){
        Employee currentEmployee = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name));
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
