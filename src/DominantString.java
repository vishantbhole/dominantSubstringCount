import java.util.HashMap;
import java.util.Map;

class Result {

    public static long getDominantStringCount(String s) {
        int n = s.length();
        long dominantSubstringCount = 0;

        // Traverse all starting points
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> frequencyMap = new HashMap<>();

            // Traverse substrings starting from i
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);

                // Consider only even-length substrings
                if ((j - i + 1) % 2 == 0) {
                    int halfLength = (j - i + 1) / 2;

                    // Check if any character has frequency equal to half the length of the substring
                    if (isDominant(frequencyMap, halfLength)) {
                        dominantSubstringCount++;
                    }
                }
            }
        }

        return dominantSubstringCount;
    }

    // Helper function to check if any character appears exactly half the times of the substring length
    private static boolean isDominant(Map<Character, Integer> frequencyMap, int halfLength) {
        for (int frequency : frequencyMap.values()) {
            if (frequency == halfLength) {
                return true;
            }
        }
        return false;
    }
}

public class DominantString {
    public static void main(String[] args) {
        String s = "idafdffii";
        long result = Result.getDominantStringCount(s);
        System.out.println(result);  // Output the number of dominant substrings
    }
}