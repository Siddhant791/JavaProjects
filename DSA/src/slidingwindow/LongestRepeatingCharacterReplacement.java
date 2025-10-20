package src.slidingwindow;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int L = 0;
        int out = 0;
        int[] freq = new int[26];

        for (int R = 0; R < s.length(); R++) {
            freq[(s.charAt(R) - 'A')]++; // Adding new word to frequency array
            int maxFreq = Arrays.stream(freq).max().getAsInt();

            while( (R - L + 1) - maxFreq > k) {
                // Invalid window then shrink it
                freq[(s.charAt(L) - 'A')]--;
                L++;
            }

            // Length of valid window
            int validWindowSize = R - L + 1;

            out = Math.max(validWindowSize,out);
        }

        return out;
    }
}
