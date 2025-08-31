import java.util.Scanner;

/**
 * A simple command-line Student Grade Management System.
 * 
 * This program allows users to add student names and marks, calculate grades based on marks,
 * and display all student records. It uses an array to store data and runs until the user exits.
 * 
 * @author Pooja [Your Last Name]  // Replace with your name
 * @version 1.0
 * @since 2025-08-22
 */
public class StudentGradeSystem {
    // Arrays to store student data (max 50 students for simplicity)
    private static String[] studentNames = new String[50];
    private static double[] studentMarks = new double[50];
    private static int studentCount = 0;

    /**
     * Main method to run the student grade management system.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Student Grade Management System!");
        System.out.println("Options: 1. Add Student  2. Display All Students  3. Exit");

        while (running) {
            System.out.print("\nEnter choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    /**
     * Adds a new student with name and marks, and calculates their grade.
     * 
     * @param scanner Scanner object to read user input.
     */
    private static void addStudent(Scanner scanner) {
        if (studentCount >= 50) {
            System.out.println("Error: Cannot add more students. Limit reached.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student marks (0-100): ");
        double marks = scanner.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return;
        }

        studentNames[studentCount] = name;
        studentMarks[studentCount] = marks;
        studentCount++;

        System.out.println("Student added successfully!");
    }

    /**
     * Displays all students with their names, marks, and calculated grades.
     */
    private static void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("\nStudent Records:");
        System.out.println("Name\t\tMarks\tGrade");
        System.out.println("--------------------------------");

        for (int i = 0; i < studentCount; i++) {
            String grade = calculateGrade(studentMarks[i]);
            System.out.println(studentNames[i] + "\t\t" + studentMarks[i] + "\t" + grade);
        }
    }

    /**
     * Calculates the grade based on marks.
     * 
     * @param marks The marks obtained by the student.
     * @return A string representing the grade (A, B, C, D, or F).
     */
    private static String calculateGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}