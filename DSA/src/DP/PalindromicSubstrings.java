package src.DP;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int out = 0;
        for (int i = 0; i < s.length(); i++){
            int L = i;
            int R = i;

            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                out++;
                L--;
                R++;
            }

            L = i;
            R= i+1;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                out++;
                L--;
                R++;
            }
        }
        return out;
    }
}
