import java.util.Scanner;

public class TextAdventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        System.out.println("Welcome to the Text Adventure!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");

        // Start the adventure
        startAdventure(scanner, playerName);

        scanner.close();
    }

    public static void startAdventure(Scanner scanner, String playerName) {
        System.out.println("\nYou find yourself standing in a dark forest.");
        System.out.println("You can see two paths: one to the LEFT and one to the RIGHT.");
        System.out.print("Which way do you go? (left/right): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("left")) {
            goLeft(scanner, playerName);
        } else if (choice.equals("right")) {
            goRight(scanner, playerName);
        } else {
            System.out.println("Invalid choice. You stand still, and a bear eats you. Game over.");
        }
    }

    public static void goLeft(Scanner scanner, String playerName) {
        System.out.println("\nYou follow the left path and come across a small cottage.");
        System.out.println("Do you ENTER the cottage or CONTINUE down the path? (enter/continue): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("enter")) {
            enterCottage(scanner, playerName);
        } else if (choice.equals("continue")) {
            continueLeft(scanner, playerName);
        } else {
            System.out.println("Invalid choice. You get lost and die. Game over.");
        }
    }

    public static void goRight(Scanner scanner, String playerName) {
        System.out.println("\nYou follow the right path and find a shimmering stream.");
        System.out.println("Do you DRINK from the stream or CROSS it? (drink/cross): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("drink")) {
            drinkStream(scanner, playerName);
        } else if (choice.equals("cross")) {
            crossStream(scanner, playerName);
        } else {
            System.out.println("Invalid choice. A snake bites you. Game over.");
        }
    }

    public static void enterCottage(Scanner scanner, String playerName) {
        System.out.println("\nYou enter the cottage and find a friendly old woman.");
        System.out.println("She offers you a magical potion. Do you ACCEPT or DECLINE? (accept/decline): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("accept")) {
            System.out.println("You drink the potion and gain incredible strength! You win!");
        } else if (choice.equals("decline")) {
            System.out.println("The old woman smiles and says, 'A wise choice.' You find a hidden path and escape the forest. You win!");
        } else {
            System.out.println("Invalid choice. The woman throws a pot at you, and you are knocked out. Game over.");
        }
    }

    public static void continueLeft(Scanner scanner, String playerName) {
        System.out.println("You continue down the path and are ambushed by goblins. Game over.");
    }

    public static void drinkStream(Scanner scanner, String playerName) {
        System.out.println("You drink from the stream and instantly feel refreshed.");
        System.out.println("A magical fish jumps out and gives you a golden key. You win!");
    }

    public static void crossStream(Scanner scanner, String playerName) {
        System.out.println("You attempt to cross the stream, but the current is too strong. You are swept away. Game over.");
    }
}