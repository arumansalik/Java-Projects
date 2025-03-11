import java.util.Scanner;

public class JavaQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Java Quiz!");
        System.out.println("-------------------------");

        // Question 1
        System.out.println("1. What is the keyword used to define a class in Java?");
        System.out.println("a) struct");
        System.out.println("b) class");
        System.out.println("c) object");
        System.out.println("d) method");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();
        if (answer1.equalsIgnoreCase("b")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is b) class.");
        }
        System.out.println();

        // Question 2
        System.out.println("2. Which of the following is a primitive data type in Java?");
        System.out.println("a) String");
        System.out.println("b) Integer");
        System.out.println("c) boolean");
        System.out.println("d) Array");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();
        if (answer2.equalsIgnoreCase("c")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is c) boolean.");
        }
        System.out.println();

        // Question 3
        System.out.println("3. What is the purpose of the 'main' method in a Java program?");
        System.out.println("a) To define variables");
        System.out.println("b) To create objects");
        System.out.println("c) To start program execution");
        System.out.println("d) To perform mathematical operations");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();
        if (answer3.equalsIgnoreCase("c")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is c) To start program execution.");
        }
        System.out.println();

        // Question 4
        System.out.println("4. What does the 'new' keyword do in Java?");
        System.out.println("a) Declares a variable");
        System.out.println("b) Creates a new object");
        System.out.println("c) Defines a method");
        System.out.println("d) Imports a package");
        System.out.print("Your answer: ");
        String answer4 = scanner.nextLine();
        if (answer4.equalsIgnoreCase("b")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is b) Creates a new object.");
        }
        System.out.println();

        // Question 5
        System.out.println("5. Which operator is used for assignment in Java?");
        System.out.println("a) ==");
        System.out.println("b) +=");
        System.out.println("c) =");
        System.out.println("d) ->");
        System.out.print("Your answer: ");
        String answer5 = scanner.nextLine();
        if (answer5.equalsIgnoreCase("c")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is c) =.");
        }
        System.out.println();

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of 5.");

        scanner.close();
    }
}