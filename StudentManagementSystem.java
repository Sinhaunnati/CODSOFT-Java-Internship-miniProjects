// 
import java.io.*;
import java.util.*;

class Student {
    String name;
    int rollNo;
    String grade;

    public Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String toString() {
        return name + "," + rollNo + "," + grade;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        String name = parts[0];
        int rollNo = Integer.parseInt(parts[1]);
        String grade = parts[2];
        return new Student(name, rollNo, grade);
    }

    public String display() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadFromFile();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. View All Students");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addStudent();
            } else if (choice.equals("2")) {
                removeStudent();
            } else if (choice.equals("3")) {
                searchStudent();
            } else if (choice.equals("4")) {
                viewStudents();
            } else if (choice.equals("5")) {
                saveToFile();
                System.out.println("Students saved. Exiting program.");
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        String rollInput = scanner.nextLine();
        int rollNo;
        try {
            rollNo = Integer.parseInt(rollInput);
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        for (Student s : studentList) {
            if (s.rollNo == rollNo) {
                System.out.println("Student with this roll number already exists.");
                return;
            }
        }

        Student student = new Student(name, rollNo, grade);
        studentList.add(student);
        System.out.println("Student added.");
    }

    public static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        String rollInput = scanner.nextLine();
        int rollNo;
        try {
            rollNo = Integer.parseInt(rollInput);
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return;
        }

        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).rollNo == rollNo) {
                studentList.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String rollInput = scanner.nextLine();
        int rollNo;
        try {
            rollNo = Integer.parseInt(rollInput);
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return;
        }
        boolean found = false;
        for (Student s : studentList) {
            if (s.rollNo == rollNo) {
                System.out.println("Found: " + s.display());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void viewStudents() {
        if (studentList.size() == 0) {
            System.out.println("No students.");
        } else {
            for (Student s : studentList) {
                System.out.println(s.display());
            }
        }
    }

    public static void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));
            for (Student s : studentList) {
                writer.println(s.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not save.");
        }
    }

    public static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Student s = Student.fromString(line);
                studentList.add(s);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Could not load file.");
        }
    }
}