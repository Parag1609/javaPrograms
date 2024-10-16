import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);
        students.add(student);

        System.out.println("Student added successfully!\n");
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Student student = findStudentById(id);

        if (student != null) {
            System.out.print("Enter new name (or press Enter to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }

            System.out.print("Enter new age (or press 0 to skip): ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            if (age != 0) {
                student.setAge(age);
            }

            System.out.print("Enter new course (or press Enter to skip): ");
            String course = scanner.nextLine();
            if (!course.isEmpty()) {
                student.setCourse(course);
            }

            System.out.println("Student updated successfully!\n");
        } else {
            System.out.println("Student with ID " + id + " not found.\n");
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.\n");
        } else {
            for (Student student : students) {
                student.displayInfo();
                System.out.println("---------------");
            }
        }
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Method to display the menu and process user input
    public void showMenu() {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.showMenu();
    }
}
