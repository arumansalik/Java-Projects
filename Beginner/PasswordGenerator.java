import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?/{}[]|";

    private static final Random random = new SecureRandom();

    public static String generatePassword(int length, boolean includesLowerCase, boolean includesUppercase, boolean includesNumbers, boolean includesSpecialChar) {
        if(length <= 0) {
            return "";
        }

        StringBuilder validChars = new StringBuilder();
        if(includesLowerCase) {
            validChars.append(LOWERCASE);
        }
        if(includesUppercase) {
            validChars.append(UPPERCASE);
        }
        if(includesNumbers) {
            validChars.append(NUMBERS);
        }
        if(includesSpecialChar) {
            validChars.append(SPECIAL_CHARACTERS);
        }

        if(validChars.length() == 0) {
            return  "";
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }
        return password.toString();
    }
    public static void main(String[] args) {
        int length = 24;
        boolean includeLowercase = true;
        boolean includeUppercase = true;
        boolean includeNumbers = true;
        boolean includeSpecialCharacters = true;

        String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers,
                includeSpecialCharacters);

        System.out.println("Generated Password: " + password);

        String shortPassword = generatePassword(8, true, false, true, false);
        System.out.println("Generated short Password: "+ shortPassword);

        String simplePassword = generatePassword(10, true, false, true, false);
        System.out.println("Generated simple Password: " + simplePassword);

        String complexPassword = generatePassword(16, false, true, false, true);
        System.out.println("Generated complex Password: " + complexPassword);
    }
}
