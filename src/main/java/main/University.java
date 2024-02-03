package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class University {
    final private String FILENAME = "File.txt";
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

    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
            System.out.println("Oppilaat tallennettu tiedostoon");
        } catch (IOException e) {
            System.out.println("Oppilaiden tallentaminen ei onnistunut");
            e.printStackTrace();
        }
    }

    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
            System.out.println("Oppilaat ladattu tiedostosta");
        } catch (FileNotFoundException e) {
            System.out.println("Oppilaiden lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Oppilaiden lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Oppilaiden lukeminen ei onnistunut");
            e.printStackTrace();
        }

    }
}
