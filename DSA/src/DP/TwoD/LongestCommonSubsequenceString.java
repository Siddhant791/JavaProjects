package src.DP.TwoD;

public class LongestCommonSubsequenceString {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n][m];

        // Instantiating the dp array with -1
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m;j++){
                memo[i][j] = -1;
            }
        }

        return helper(text1, text2, 0, 0, memo);
    }

    public int helper(String str1, String str2, int n, int m, int[][] memo){
        // Base condition when any string has no character
        if (str1.length() == n || str2.length() == m){
            return 0;
        }

        if(memo[n][m] != -1){
            return memo[n][m];
        }

        if (str1.charAt(n) == str2.charAt(m)){
            memo[n][m] = 1 + helper(str1, str2, n+1, m+1, memo);
        }else{
            memo[n][m] = Math.max(helper(str1,str2, n+1, m, memo), helper(str1,str2, n, m+1, memo));
        }

        return memo[n][m];
    }
}
