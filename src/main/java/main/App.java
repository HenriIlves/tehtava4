package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        String FILENAME = "File.txt";
        University university = new University();

        boolean exit = false;
        while(!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna opiskelijan nimi?");
                        String name = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        int studentNumber = Integer.parseInt(sc.nextLine());

                        university.addStudent(new Student(name, studentNumber));
                        break;

                    case 2:
                        System.out.println("Opiskelijat:");
                        university.listStudents();
                        break;

                    case 3:
                        university.listStudentWithIndex();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        int studentIndex = Integer.parseInt(sc.nextLine());
                        System.out.println("Mille kurssille suorite lisätään?");
                        String course = sc.nextLine();
                        System.out.println("Mikä arvosana kurssille lisätään?");
                        int grade = Integer.parseInt(sc.nextLine());

                        university.addGradeToStudent(studentIndex, course, grade);
                        break;

                    case 4:
                        university.listStudentWithIndex();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        int index4 = Integer.parseInt(sc.nextLine());

                        university.listStudentGrades(index4);
                        break;

                    case 5:
                        university.listStudentWithIndex();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        int index5 = Integer.parseInt(sc.nextLine());

                        double average = Calculator.getAverageGrade(university.students, index5);
                        System.out.println("Keskiarvo on: " + average);
                        break;

                    case 6:
                        university.listStudentWithIndex();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        int index6 = Integer.parseInt(sc.nextLine());

                        double median = Calculator.getMedianGrade(university.students, index6);
                        System.out.println("Mediaani on " + median);
                        break;

                    case 7:
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                            oos.writeObject(university);
                            System.out.println("Tiedot tallennettu.");
                        } catch (IOException e) {
                            System.out.println("Tiedoston tallennus epäonnistui: " + e.getMessage());
                        }
                        break;

                    case 8:
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                            university = (University) ois.readObject(); // Assign loaded object to university variable
                            System.out.println("Opiskelijat ladattu tiedostosta.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Tiedoston lukeminen epäonnistui: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        
        }
    sc.close();
    }
}
