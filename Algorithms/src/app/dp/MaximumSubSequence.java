package app.dp;

public class MaximumSubSequence {
	public static int maxSubSequence(String s1,String s2,int m,int n,int[][] dp){
		if(m==0 || n==0){
			return 0;
	}

	if(dp[m][n]!=-1){
		return dp[m][n];
	}

	if(s1.charAt(m-1) == s2.charAt(n-1)){
		dp[m][n] = 1+maxSubSequence(s1,s2,m-1,n-1,dp);
		return dp[m][n];
	}else{
		return dp[m][n] =  Math.max(maxSubSequence(s1,s2,m-1,n,dp),maxSubSequence(s1,s2,m,n-1,dp));
	}	
	}

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "aecb";
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(maxSubSequence(s1, s2, m, n, dp));
		
	}
}
