package Exam18August2021.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (capacity > this.employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee employeeOldest = null;
        for (Employee employee : employees) {
            if (employeeOldest == null || employee.getAge() > employeeOldest.getAge()) {
                employeeOldest = employee;
            }
        }
        return employeeOldest;
    }

    public Employee getEmployee(String name) {
        Employee newEmployee = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                newEmployee = employee;
            }
        }
        return newEmployee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s", this.name))
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
