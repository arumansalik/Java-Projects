import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();

        Map<String, Integer> wordCounts = countWords(input);

        System.out.println("Word Counts:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCounts = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return wordCounts;
        }

        StringTokenizer tokenizer = new StringTokenizer(input.toLowerCase(), " \t\n\r\f.,;:!?\"'()[]{}-"); //Common Punctuation and whitespace
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        return wordCounts;
    }
}