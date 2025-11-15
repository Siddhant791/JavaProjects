package src.Arrays;

public class ScoreOfAString {
    public int scoreOfString(String s) {
        char[] input = s.toCharArray();
        int output = 0;
        for (int i = 0; i < input.length - 1; i++) {
            output+= Math.abs(input[i] - input[i+1]);
        }
        return output;
    }
}
