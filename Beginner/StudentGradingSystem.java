import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    List<Integer> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMarks(int mark) {
        this.marks.add(mark);
    }

    public double calculateAverage() {
        if(marks.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for(int mark: marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public char calculateGrade() {
        double average = calculateAverage();
        if(average >= 90) {
            return 'A';
        } else if(average >= 80) {
            return 'B';
        } else if(average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public int calculateTotalMarks() {
        int total = 0;
        for(int mark: this.marks) {
            total += mark;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + ", Average: " + calculateAverage() + ", Grade: " + calculateGrade() + ", Total Marks: " + calculateTotalMarks();
    }
}

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 :
                    addStudent(sc, students);
                    break;
                case 2:
                    displayStudents(students);
                    break;
                case 3:
                    System.out.println("Exiting.....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        }
    }

    public static void addStudent(Scanner sc, List<Student> students) {
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        Student student = new Student(name);

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ": ");
            int mark = sc.nextInt();
            if(mark < 0 || mark > 100) {
                System.out.println("Invalid marks entered. Marks must be between 0 and 100.");
                return;
            }
            student.addMarks(mark);
        }
        students.add(student);
        sc.nextLine();
        System.out.println("Student added successfully.");
    }

    public static void displayStudents(List<Student> students) {
        if(students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n--- Students Reports");
        for(Student student : students) {
            System.out.println(student);
        }
    }
}
