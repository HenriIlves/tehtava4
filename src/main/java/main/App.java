package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        University university = new University();

        boolean exit = false;
        while(!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) LAske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna opiskelijalle nimi?");
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
                        System.out.println("Mediaani on: " + median);
                        break;

                    case 7:
                        university.saveStudents();
                        break;

                    case 8:
                        university.loadStudents();
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
