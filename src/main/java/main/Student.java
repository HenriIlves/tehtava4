package main;

import java.util.HashMap;
import java.util.Map;

public class Student {
    String name;
    int studentNumber;
    Map<String, Integer> grades;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new HashMap<>();
    }

    public String toString() {
        return studentNumber + ": " + name;
    }

    public void addGrade(String course, int grade) {
        grades.put(course, grade);
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}