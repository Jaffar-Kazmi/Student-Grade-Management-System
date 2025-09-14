import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static final int MAX = 50;
    static String[] studentName = new String[MAX];
    static int[] studentId = new int[MAX];
    static double[][] marks = new double[MAX][3];
    static int studentCount = 0;

    static void addStudent(){
        char choice;
        do {
            if(studentCount>= MAX){
                System.out.println("Maximum count reached. Can't add more students.");
                return;
            }

            System.out.print("Enter student's Id: ");
            int id = sc.nextInt();
            for (int i = 0; i < studentCount; i++) {
                if (id == studentId[i]) {
                    System.out.println("Student with this Id already exists.");
                    return;
                }
            }

            sc.nextLine();
            System.out.print("Enter students's name: ");
            String name = sc.nextLine();

            double[] newMarks = new double[3];
            for (int i = 0; i < 3; i++) {
                double mark;
                do {
                    System.out.print("Enter marks for subject " + (i + 1) + " (0–100): ");
                    mark = sc.nextDouble();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid input.");
                    }
                }while (mark<0 || mark>100);
                newMarks[i] = mark;
            }

            studentId[studentCount] = id;
            studentName[studentCount] = name;
            for (int i = 0; i < 3; i++) {
                marks[studentCount][i] = newMarks[i];
            }
            studentCount++;
            System.out.print("\nStudent Added.\nDo you want to add another student(yes/no):");
            choice = sc.next().charAt(0);
        }while(choice == 'y' || choice == 'Y');
    }

    static void viewAllStudents(){
        if(studentCount<=0){
            System.out.println("No students to display.");
            return;
        }
        System.out.println("----------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Student " + (i+1));
            System.out.println("Id: " + studentId[i] );
            System.out.println("Name: " + studentName[i]);
            System.out.println("Marks: ");
            for (int j = 0; j < 3; j++) {
                System.out.println("Subject " + (j+1) + ": " + marks[i][j]);
            }
            System.out.println("----------------------------------");
        }
    }

    static void updateMarks(){
        if(studentCount<=0){
            System.out.println("No data to update");
            return;
        }
        System.out.print("Enter student id to update: ");
        int id = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if(id == studentId[i]){
                found = true;
                System.out.print("Enter subject number to update(1-3): ");
                int subject = sc.nextInt();

                if (subject < 1 || subject > 3) {
                    System.out.println("Invalid subject number.");
                    return;
                }

                double newMarks;
                do {
                    System.out.print("Enter new marks for subject " + subject + ": ");
                    newMarks = sc.nextDouble();

                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println("Invalid marks! Please enter between 0 and 100.");
                    }
                }while (newMarks < 0 || newMarks > 100);

                marks[i][subject-1] = newMarks;
                System.out.println("Marks Updated successfully.");
            }
        }
        if(!found){
            System.out.println("Student does'nt exist.");
        }
    }

    static void removeStudent(){
        if(studentCount<=0){
            System.out.println("No data to delete.");
        }
        int id;
        char choice;
        boolean found = false;

        do{
            System.out.print("Enter student id to delete: ");
            id = sc.nextInt();
            for (int i = 0; i < studentCount; i++) {
                if(id == studentId[i]){
                    found = true;
                    studentCount--;
                    for (int j = i; j < studentCount; j++) {
                        studentId[j] = studentId[j+1];
                        studentName[j] = studentName[j+1];
                        marks[j] = marks[j+1];
                    }
                }
            }
            if(!found){
                System.out.println("Student does'nt exist.");
                return;
            }
            System.out.print("Student Removed successfully.\nDo you want to remove another student? (yes/no):");
            choice = sc.next().charAt(0);
        }while (choice == 'y' || choice == 'Y');
    }

    static void searchStudent(){
        if(studentCount<=0){
            System.out.println("No data to search");
        }
        int id;
        char choice;
        boolean found = false;

        do{
            System.out.print("Enter student's Id you want to search: ");
            id = sc.nextInt();
            for (int i = 0; i < studentCount; i++) {
                if(id == studentId[i]){
                    found = true;
                    System.out.println("Student data:");
                    System.out.println("Id: " + studentId[i]);
                    System.out.println("Name: " + studentName[i]);
                    System.out.println("Marks: ");
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Subject " + (j+1) + ": " + marks[i][j]);
                    }
                }
            }
            if (!found){
                System.out.println("Student does'nt exist.");
                return;
            }
            System.out.print("\nDo you want to search another student? (yes/no): ");
            choice = sc.next().charAt(0);
        }while (choice == 'y' || choice == 'Y');
    }

    static void highestScorer(){
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }
        double highestTotal = -1;

        for (int i = 0; i < studentCount; i++) {
            double total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            if(total>highestTotal){
                highestTotal = total;
            }
        }

        System.out.println("Highest Scorer(s): ");
        for (int i = 0; i < studentCount; i++) {
            double total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }

            if(total == highestTotal){
                System.out.println("----------------------------------");
                System.out.println("Id: " + studentId[i]);
                System.out.println("Name: " + studentName[i]);
                System.out.println("Total Marks: " + highestTotal);
                System.out.println("Average: " + highestTotal/3);
            }
        }
    }

    static void classAverage(){
        if(studentCount==0){
            System.out.println("No data to display");
            return;
        }
        double[] average = new double[3];
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) {
                average[j] += marks[i][j];
            }
        }

        System.out.println("\nClass Average per Subject:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Subject " + (i+1) + ": " + (average[i]/studentCount));
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Student Grade Management System\n\n");
        int choice;

        do{
            System.out.println("1. Add Student.");
            System.out.println("2. Update Marks.");
            System.out.println("3. Remove Student.");
            System.out.println("4. View All Students.");
            System.out.println("5. Search Student by Id.");
            System.out.println("6. Highest Scorer.");
            System.out.println("7. Class Average.");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1 -> addStudent();
                case 2 -> updateMarks();
                case 3 -> removeStudent();
                case 4 -> viewAllStudents();
                case 5 -> searchStudent();
                case 6 -> highestScorer();
                case 7 -> classAverage();
                case 8 -> exit (0);
                default -> System.out.println("Invalid choice.");
            }
        }while (true);
    }
}