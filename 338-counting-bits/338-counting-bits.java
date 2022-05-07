class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        if(n==0){
            return dp;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }
}