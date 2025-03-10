import java.util.Scanner;

public class CalorieCalculator {

    private static final double MALE_BMR_CONSTANT = 5;
    private static final double FEMALE_BMR_CONSTANT = -161;
    private static final double WEIGHT_COEFFICIENT = 10;
    private static final double HEIGHT_COEFFICIENT = 6.25;
    private static final double AGE_COEFFICIENT = 5;

    private static final double SEDENTARY_MULTIPLIER = 1.2;
    private static final double LIGHTLY_ACTIVE_MULTIPLIER = 1.375;
    private static final double MODERATELY_ACTIVE_MULTIPLIER = 1.55;
    private static final double VERY_ACTIVE_MULTIPLIER = 1.725;
    private static final double EXTRA_ACTIVE_MULTIPLIER = 1.9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your gender (M/F): ");
        String gender = sc.nextLine().trim().toUpperCase();

        if(!gender.equals("M") && !gender.equals("F")) {
            System.out.println("Invalid gender input. Please enter 'M' or 'F' .");
            return;
        }

        System.out.println("Enter your age (in years) :");
        int age = getValidIntInput(sc);

        System.out.println("Enter your weight (in kilograms): ");
        double weight = getValidDoubleInput(sc);

        System.out.println("Enter your height (in centimeters): ");
        double height = getValidDoubleInput(sc);

        System.out.println("Select your activity level:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise/sports 1-3 days/week)");
        System.out.println("3. Moderately active (moderate exercise/sports 3-5 days/week)");
        System.out.println("4. Very active (hard exercise/sports 6-7 days a week)");
        System.out.println("5. Extra active (very hard exercise/sports & physical job or 2x training)");

        int activityLevel = getValidIntInput(sc);

        if(activityLevel < 1 || activityLevel > 5) {
            System.out.println("Invalid activity level input. Please choose a number from 1 to 5.");
            return;
        }

        double bmr = calculateBMR(gender, age, weight, height);

        double calorieNeeds = calculateCalorieNeeds(bmr, activityLevel);

        System.out.printf("Your Basal Metabolic Rate (BMR) is: %.2f calories per day.\n", bmr);
        System.out.printf("Your estimated daily calorie needs are: %.2f calories per day.\n", calorieNeeds);

        sc.close();
    }

    private static double calculateCalorieNeeds(double bmr, int activityLevel) {
        double calorieNeeds;
        switch (activityLevel) {
            case 1:
                calorieNeeds = bmr * SEDENTARY_MULTIPLIER;
                break;
            case 2:
                calorieNeeds = bmr * LIGHTLY_ACTIVE_MULTIPLIER;
                break;
            case 3:
                calorieNeeds = bmr * MODERATELY_ACTIVE_MULTIPLIER;
                break;
            case 4:
                calorieNeeds = bmr * VERY_ACTIVE_MULTIPLIER;
                break;
            case 5:
                calorieNeeds = bmr * EXTRA_ACTIVE_MULTIPLIER;
                break;
            default:
                throw new IllegalArgumentException("Invalid activity level");
        }
        return calorieNeeds;
    }

    private static double calculateBMR(String gender, int age, double weight, double height) {
        double bmr;
        if(gender.equals("M")) {
            bmr = (WEIGHT_COEFFICIENT * weight) + (HEIGHT_COEFFICIENT * height) - (AGE_COEFFICIENT * age) + MALE_BMR_CONSTANT;
        } else {
            bmr = (WEIGHT_COEFFICIENT * height) + (HEIGHT_COEFFICIENT * height) - (AGE_COEFFICIENT * age) + FEMALE_BMR_CONSTANT;
        }
        return bmr;
    }

    private static double getValidDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid double.");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    private static int getValidIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
