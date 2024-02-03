package main;

import java.util.ArrayList;
import java.util.Map;

public class University {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void listStudentWithIndex() {
        int i = 0;

        for (Student student : students) {
            System.out.println(i++ + ": " + student.name);
        }
    }
    
    public void addGradeToStudent(int index, String course, int grade) {
        students.get(index).addGrade(course, grade);
    }

    public void listStudentGrades(int index) {
        Student student = students.get(index);
        for (Map.Entry<String, Integer> entry : student.getGrades().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
    }
}
