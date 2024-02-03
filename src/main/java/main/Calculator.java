package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public static double getAverageGrade(ArrayList<Student> students, int index) {
        Student student = students.get(index);
        List<Integer> grades = new ArrayList<>(student.getGrades().values());
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    public static double getMedianGrade(ArrayList<Student> students, int index) {
        Student student = students.get(index);
        List<Integer> grades = new ArrayList<>(student.getGrades().values());
        Collections.sort(grades);
        int size = grades.size();
        if (size == 0) return 0.0;
        if (size % 2 == 0) {
            return (grades.get(size / 2 - 1) + grades.get(size / 2)) / 2.0;
        } else {
            return grades.get(size / 2);
        }
    }
}
