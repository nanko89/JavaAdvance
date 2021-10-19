package Exam14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.capacity > this.students.size()) {
            if (students.contains(student)) {
                return "Student is already in the Exam14April2021.university";
            } else {
                students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "No seats in the Exam14April2021.university";
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        Student student = null;
        for (Student s : this.students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                student = s;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.students.size(); i++) {
            if (i == students.size() - 1) {
                sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", students.get(i).getFirstName(),
                        students.get(i).getLastName(), students.get(i).getBestSubject()));
            } else {
                sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", students.get(i).getFirstName(),
                        students.get(i).getLastName(), students.get(i).getBestSubject()));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
