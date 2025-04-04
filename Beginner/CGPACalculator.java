import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CGPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Semester> semesters = new ArrayList<>();

        System.out.println("Welcome to the CGPA Calculator!");

        while (true) {
            System.out.print("Enter the number of semesters you want to include (or 0 to calculate CGPA): ");
            int numSemesters = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (numSemesters == 0) {
                break;
            }

            for (int i = 1; i <= numSemesters; i++) {
                System.out.println("\n--- Semester " + i + " ---");
                Semester semester = getSemesterDetails(scanner);
                semesters.add(semester);
            }
        }

        if (!semesters.isEmpty()) {
            double cgpa = calculateCgpa(semesters);
            System.out.println("\n--- CGPA Result ---");
            System.out.printf("Your Cumulative Grade Point Average (CGPA) is: %.2f\n", cgpa);
        } else {
            System.out.println("No semester data entered. Exiting.");
        }

        scanner.close();
    }

    public static Semester getSemesterDetails(Scanner scanner) {
        List<Subject> subjects = new ArrayList<>();
        System.out.print("Enter the number of subjects in this semester: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("\n--- Subject " + i + " ---");
            System.out.print("Enter the credits for this subject: ");
            int credits = scanner.nextInt();
            System.out.print("Enter the grade obtained (e.g., A+, A, B+, B, C+, C, D, F): ");
            scanner.next(); // Consume previous newline
            String grade = scanner.nextLine().toUpperCase();

            double gradePoint = getGradePoint(grade);
            if (gradePoint == -1) {
                System.out.println("Invalid grade entered. Please enter a valid grade.");
                i--; // Decrement to re-enter the current subject
                continue;
            }

            subjects.add(new Subject(credits, gradePoint));
        }
        return new Semester(subjects);
    }

    public static double getGradePoint(String grade) {
        switch (grade) {
            case "A+":
                return 10.0;
            case "A":
                return 9.0;
            case "B+":
                return 8.0;
            case "B":
                return 7.0;
            case "C+":
                return 6.0;
            case "C":
                return 5.0;
            case "D":
                return 4.0;
            case "F":
                return 0.0;
            default:
                return -1.0; // Indicate invalid grade
        }
    }

    public static double calculateCgpa(List<Semester> semesters) {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Semester semester : semesters) {
            for (Subject subject : semester.getSubjects()) {
                totalGradePoints += subject.getCredits() * subject.getGradePoint();
                totalCredits += subject.getCredits();
            }
        }

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }

        return totalGradePoints / totalCredits;
    }
}

class Subject {
    private int credits;
    private double gradePoint;

    public Subject(int credits, double gradePoint) {
        this.credits = credits;
        this.gradePoint = gradePoint;
    }

    public int getCredits() {
        return credits;
    }

    public double getGradePoint() {
        return gradePoint;
    }
}

class Semester {
    private List<Subject> subjects;

    public Semester(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}